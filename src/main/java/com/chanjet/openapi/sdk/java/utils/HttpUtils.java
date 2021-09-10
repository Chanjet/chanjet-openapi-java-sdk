package com.chanjet.openapi.sdk.java.utils;


import com.chanjet.openapi.sdk.java.HttpResponse;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.*;
import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.net.Proxy.Type;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HTTP 工具类
 *
 * @author zsc
 * @create 2020/8/2 11:06 上午
 **/
public class HttpUtils {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_PUT = "PUT";

    private static HostnameVerifier verifier = null;

    private static SSLSocketFactory socketFactory = null;

    private static int keepAliveTimeout = 0;

    /**
     * 是否校验SSL服务端证书，默认为不需要校验
     */
    private static volatile boolean needCheckServerTrusted = false;

    private HttpUtils() {
    }

    /**
     * 设置是否校验SSL服务端证书
     *
     * @param needCheckServerTrusted true：需要校验（默认，推荐）；
     *                               <p>
     *                               false：不需要校验（仅当部署环境不便于进行服务端证书校验，且已有其他方式确保通信安全时，可以关闭SSL服务端证书校验功能）
     */
    public static void setNeedCheckServerTrusted(boolean needCheckServerTrusted) {
        HttpUtils.needCheckServerTrusted = needCheckServerTrusted;
    }

    /**
     * 设置KeepAlive连接超时时间，一次HTTP请求完成后，底层TCP连接将尝试尽量保持该超时时间后才关闭，以便其他HTTP请求复用TCP连接
     * <p>
     * KeepAlive连接超时时间设置为0，表示使用默认的KeepAlive连接缓存时长（目前为5s）
     * <p>
     * 连接并非一定能保持指定的KeepAlive超时时长，比如服务端断开了连接
     * <p>
     * @param timeout KeepAlive超时时间，单位秒
     */
    public static void setKeepAliveTimeout(int timeout) {
        if (timeout < 0 || timeout > 60) {
            throw new RuntimeException("keep-alive timeout value must be between 0 and 60.");
        }
        keepAliveTimeout = timeout;
    }

    private static class DefaultTrustManager implements X509TrustManager {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain,
                                       String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain,
                                       String authType) throws CertificateException {
        }
    }

    static {

        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager()},
                    new SecureRandom());

            ctx.getClientSessionContext().setSessionTimeout(15);
            ctx.getClientSessionContext().setSessionCacheSize(1000);

            socketFactory = ctx.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        verifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
    }

    /**
     * 执行HTTP POST请求，可使用代理proxy。
     *
     * @param url            请求地址
     * @param headers        请求头
     * @param params         请求参数
     * @param contentType    请求类型
     * @param body           请求体
     * @param connectTimeout 连接超时时间
     * @param readTimeout    请求超时时间
     * @param proxyHost      代理host，传null表示不使用代理
     * @param proxyPort      代理端口，传0表示不使用代理
     * @return 响应字符串
     * @throws IOException
     */
    public static HttpResponse doPost(String url, Map<String, String> headers, Map<String, String> params,
                                      String contentType, String body, int connectTimeout, int readTimeout,
                                      String proxyHost, int proxyPort) throws IOException {
        String query = buildQuery(params);
        if (StringUtils.isNotBlank(query)) {
            url = url + "?" + query;
        }
        byte[] content = body.getBytes("UTF-8");
        return doPost(url, headers, contentType, content, connectTimeout, readTimeout, proxyHost, proxyPort);
    }

    /**
     * 执行HTTP POST请求。
     *
     * @param url            请求地址
     * @param headers        请求头
     * @param contentType    请求类型
     * @param content        请求字节数组
     * @param connectTimeout 连接超时时间
     * @param readTimeout    请求超时时间
     * @param proxyHost      代理host，传null表示不使用代理
     * @param proxyPort      代理端口，传0表示不使用代理
     * @return 响应字符串
     * @throws IOException
     */
    public static HttpResponse doPost(String url, Map<String, String> headers, String contentType,
                                      byte[] content, int connectTimeout, int readTimeout,
                                      String proxyHost, int proxyPort) throws IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        HttpResponse rsp = null;
        try {
            try {
                conn = null;
                if (!StringUtils.isEmpty(proxyHost)) {
                    conn = getConnection(new URL(url), METHOD_POST, headers, contentType, proxyHost, proxyPort);
                } else {
                    conn = getConnection(new URL(url), METHOD_POST, headers, contentType);
                }
                conn.setConnectTimeout(connectTimeout);
                conn.setReadTimeout(readTimeout);
            } catch (IOException e) {
                throw e;
            }
            try {
                out = conn.getOutputStream();
                out.write(content);
                rsp = getHttpResponse(conn);
            } catch (IOException e) {
                throw e;
            }
        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();

            }
        }

        return rsp;
    }

    /**
     * 执行HTTP GET请求。
     *
     * @param url            请求地址
     * @param headers        请求头
     * @param params         请求参数
     * @param contentType    请求格式
     * @param connectTimeout 连接超时时间
     * @param readTimeout    请求超时时间
     * @return 响应字符串
     * @throws IOException
     */
    public static HttpResponse doGet(String url, Map<String, String> headers, Map<String, String> params,
                                     String contentType, int connectTimeout, int readTimeout) throws IOException {
        HttpURLConnection conn = null;
        HttpResponse rsp = null;
        try {
            String query = buildQuery(params);
            try {
                conn = getConnection(buildGetUrl(url, query), METHOD_GET, headers, contentType);
                conn.setConnectTimeout(connectTimeout);
                conn.setReadTimeout(readTimeout);
            } catch (IOException e) {
                throw e;
            }

            try {
                rsp = getHttpResponse(conn);
            } catch (IOException e) {
                throw e;
            }

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return rsp;
    }

    /**
     * 执行HTTP PUT请求
     *
     * @param url            请求地址
     * @param headers        请求头
     * @param params         请求参数
     * @param connectTimeout 连接超时时间
     * @param readTimeout    请求超时时间
     * @param proxyHost      代理host，传null表示不使用代理
     * @param proxyPort      代理端口，传0表示不使用代理
     * @param contentType    请求格式
     * @return
     * @throws IOException
     */
    public static HttpResponse doPut(String url, Map<String, String> headers, Map<String, String> params, String contentType,
                                     String body, int connectTimeout, int readTimeout, String proxyHost,
                                     int proxyPort) throws IOException {
        String query = buildQuery(params);
        if (StringUtils.isNotBlank(query)) {
            url = url + "?" + query;
        }
        byte[] content = body.getBytes("UTF-8");
        return doPut(url, headers, contentType, content, connectTimeout, readTimeout, proxyHost, proxyPort);
    }

    /**
     * @param url            请求地址
     * @param headers        请求头
     * @param ctype          请求类型
     * @param content        请求字节数组
     * @param connectTimeout 连接超时时间
     * @param readTimeout    请求超时时间
     * @param proxyHost      代理host，传null表示不使用代理
     * @param proxyPort      代理端口，传0表示不使用代理
     * @return
     * @throws IOException
     */
    public static HttpResponse doPut(String url, Map<String, String> headers, String ctype, byte[] content, int connectTimeout,
                                     int readTimeout, String proxyHost, int proxyPort) throws IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        HttpResponse rsp = null;
        try {
            try {
                conn = null;
                if (!StringUtils.isEmpty(proxyHost)) {
                    conn = getConnection(new URL(url), METHOD_PUT, headers, ctype, proxyHost, proxyPort);
                } else {
                    conn = getConnection(new URL(url), METHOD_PUT, headers, ctype);
                }
                conn.setConnectTimeout(connectTimeout);
                conn.setReadTimeout(readTimeout);
            } catch (IOException e) {
                throw e;
            }
            try {
                out = conn.getOutputStream();
                out.write(content);
                rsp = getHttpResponse(conn);
            } catch (IOException e) {
                throw e;
            }

        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();

            }
        }

        return rsp;
    }

    /**
     * 执行HTTP DELETE请求。
     *
     * @param url            请求地址
     * @param headers        请求头
     * @param params         请求参数
     * @param contentType    请求格式
     * @param connectTimeout 请求格式
     * @param readTimeout    请求格式
     * @return 响应字符串
     * @throws IOException
     */
    public static HttpResponse doDelete(String url, Map<String, String> params, Map<String, String> headers,
                                        String contentType, int connectTimeout, int readTimeout) throws IOException {
        HttpURLConnection conn = null;
        HttpResponse rsp = null;
        try {
            String query = buildQuery(params);
            try {
                conn = getConnection(buildGetUrl(url, query), METHOD_DELETE, headers, contentType);
                conn.setConnectTimeout(connectTimeout);
                conn.setReadTimeout(readTimeout);
            } catch (IOException e) {
                throw e;
            }
            try {
                rsp = getHttpResponse(conn);
            } catch (IOException e) {
                throw e;
            }

        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rsp;
    }

    public static HttpURLConnection getConnection(URL url, String method, Map<String, String> headers, String ctype) throws IOException {
        return getConnection(url, method, headers, ctype, null);
    }

    public static HttpURLConnection getConnection(URL url, String method, Map<String, String> headers, String contentType,
                                                  String proxyHost, int proxyPort) throws IOException {
        Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        return getConnection(url, method, headers, contentType, proxy);
    }

    private static HttpURLConnection getConnection(URL url, String method, Map<String, String> headers, String contentType, Proxy proxy) throws IOException {
        HttpURLConnection conn = null;
        if ("https".equals(url.getProtocol())) {
            HttpsURLConnection connHttps = null;
            if (proxy != null) {
                connHttps = (HttpsURLConnection) url.openConnection(proxy);
            } else {
                connHttps = (HttpsURLConnection) url.openConnection();
            }
            if (!needCheckServerTrusted) {
                //设置不校验服务端证书的SSLContext
                connHttps.setSSLSocketFactory(socketFactory);
                connHttps.setHostnameVerifier(verifier);
            }
            conn = connHttps;
        } else {
            if (proxy != null) {
                conn = (HttpURLConnection) url.openConnection(proxy);
            } else {
                conn = (HttpURLConnection) url.openConnection();
            }
        }

        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "text/plain,text/xml,text/javascript,text/html,application/json");
        conn.setRequestProperty("User-Agent", "chanjet-openapi-sdk-java");
        conn.setRequestProperty("Content-Type", contentType);
        if (null != headers) {
            for (Entry<String, String> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return conn;
    }

    private static URL buildGetUrl(String strUrl, String query) throws IOException {
        URL url = new URL(strUrl);
        if (StringUtils.isEmpty(query)) {
            return url;
        }

        if (StringUtils.isEmpty(url.getQuery())) {
            if (strUrl.endsWith("?")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "?" + query;
            }
        } else {
            if (strUrl.endsWith("&")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "&" + query;
            }
        }
        return new URL(strUrl);
    }

    public static String buildQuery(Map<String, String> params) throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuilder query = new StringBuilder();
        Set<Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }

                query.append(name).append("=").append(URLEncoder.encode(value, "UTF-8"));
            }
        }

        return query.toString();
    }

    protected static HttpResponse getHttpResponse(HttpURLConnection conn) throws IOException {
        HttpResponse apiResponse = new HttpResponse();
        String charset = getResponseCharset(conn.getContentType());

        //此时设置KeepAlive超时所需数据结构才刚初始化完整，可以通过反射修改
        //同时也不宜将修改时机再滞后，因为可能后续连接缓存类已经消费了默认的KeepAliveTimeout值，再修改已经无效
        setKeepAliveTimeout(conn);

        InputStream es = conn.getErrorStream();
        if (es == null) {
            apiResponse.setBody(getStreamAsString(conn.getInputStream(), charset));
            apiResponse.setHeaders(getHeader(conn.getHeaderFields()));
            apiResponse.setStatusCode(conn.getResponseCode());
            return apiResponse;
        } else {
            String msg = getStreamAsString(es, charset);
            if (StringUtils.isEmpty(msg)) {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                throw new IOException(msg);
            }
        }
    }

    private static Map<String, String> getHeader(Map<String, List<String>> headerFields) {
        Map<String, String> headers = new HashMap<String, String>();
        if (headerFields != null) {
            for (Entry<String, List<String>> headerField : headerFields.entrySet()) {
                if (StringUtils.isNotBlank(headerField.getKey()) && headerField.getValue() != null && headerField.getValue().size() > 0) {
                    headers.put(headerField.getKey(), headerField.getValue().get(0));
                }
            }
        }
        return headers;
    }

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            StringWriter writer = new StringWriter();

            char[] chars = new char[256];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }

            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private static String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;

        if (!StringUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtils.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }

        return charset;
    }

    /**
     * 从URL中提取所有的参数。
     *
     * @param query URL地址
     * @return 参数映射
     */
    public static Map<String, String> splitUrlQuery(String query) {
        Map<String, String> result = new HashMap<String, String>();

        String[] pairs = query.split("&");
        if (pairs != null && pairs.length > 0) {
            for (String pair : pairs) {
                String[] param = pair.split("=", 2);
                if (param != null && param.length == 2) {
                    result.put(param[0], param[1]);
                }
            }
        }

        return result;
    }

    /**
     * 由于HttpUrlConnection不支持设置KeepAlive超时时间，该方法通过反射机制设置
     *
     * @param connection 需要设置KeepAlive的连接
     */
    private static void setKeepAliveTimeout(HttpURLConnection connection) {
        if (keepAliveTimeout == 0) {
            return;
        }
        try {

            Field delegateHttpsUrlConnectionField = Class.forName("sun.net.www.protocol.https.HttpsURLConnectionImpl").getDeclaredField(
                    "delegate");
            delegateHttpsUrlConnectionField.setAccessible(true);
            Object delegateHttpsUrlConnection = delegateHttpsUrlConnectionField.get(connection);

            Field httpClientField = Class.forName("sun.net.www.protocol.http.HttpURLConnection").getDeclaredField("http");
            httpClientField.setAccessible(true);
            Object httpClient = httpClientField.get(delegateHttpsUrlConnection);

            Field keepAliveTimeoutField = Class.forName("sun.net.www.http.HttpClient").getDeclaredField("keepAliveTimeout");
            keepAliveTimeoutField.setAccessible(true);
            keepAliveTimeoutField.setInt(httpClient, keepAliveTimeout);
        } catch (Throwable ignored) {
            //设置KeepAlive超时只是一种优化辅助手段，设置失败不应阻塞主链路，设置失败不应影响功能
        }
    }
}

