package com.chanjet.openapi.sdk.java.utils;

import com.chanjet.openapi.sdk.java.common.ChanjetConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
 * 日志工具类
 *
 * @author zsc
 * @create 2020/8/2 11:06 上午
 **/
public class ChanjetLogger {

    private static final Log COMM_LOGGER = LogFactory.getLog("chanjet.sdk.comm.err");
    private static final Log BIZ_LOGGER = LogFactory.getLog("chanjet.sdk.biz.err");
    private static final String OS_NAME = System.getProperties().getProperty("os.name");

    private static String ip = null;
    private static boolean needEnableLogger = true;

    private ChanjetLogger() {
    }

    public static void setNeedEnableLogger(boolean needEnableLogger) {
        ChanjetLogger.needEnableLogger = needEnableLogger;
    }

    public static String getIp() {
        if (ip == null) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ip;
    }

    public static void setIp(String ip) {
        ChanjetLogger.ip = ip;
    }

    public static boolean isBizDebugEnabled() {
        return BIZ_LOGGER.isDebugEnabled();
    }

    public static boolean isCommDebugEnabled() {
        return COMM_LOGGER.isDebugEnabled();
    }

    /**
     * 打印业务错误日志
     */
    public static void logBizError(Object msg, Throwable throwable) {
        if (!needEnableLogger){
            return;
        }
        BIZ_LOGGER.error(msg, throwable);
    }

    /**
     * 打印业务info日志
     */
    public static void logBizInfo(Object msg) {
        if (!needEnableLogger){
            return;
        }
        BIZ_LOGGER.info(msg);
    }

    /**
     * 打印业务debug日志
     */
    public static void logBizDebugger(Object msg) {
        if (!needEnableLogger){
            return;
        }
        if (isBizDebugEnabled()) {
            BIZ_LOGGER.debug(msg);
        }
    }


    /**
     * 打印公共错误日志
     */
    public static void logCommError(Object msg, Throwable throwable) {
        if (!needEnableLogger){
            return;
        }
        COMM_LOGGER.error(msg, throwable);
    }

    /**
     * 打印公共info日志
     */
    public static void logCommInfo(Object msg) {
        if (!needEnableLogger){
            return;
        }
        COMM_LOGGER.info(msg);
    }

    /**
     * 打印公共debug日志
     */
    public static void logCommDebugger(Object msg) {
        if (!needEnableLogger){
            return;
        }
        if (isCommDebugEnabled()) {
            COMM_LOGGER.debug(msg);
        }
    }

    /**
     * 打印公共debug日志
     */
    public static void logBizCommonParam(String appKey) {
        if (!needEnableLogger){
            return;
        }
        StringBuilder sb = new StringBuilder();
        DateFormat df = new SimpleDateFormat(ChanjetConstants.DATE_TIME_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone(ChanjetConstants.DATE_TIMEZONE));
        String sdkName = ChanjetConstants.SDK_VERSION;
        sb.append("time: ");
        sb.append(df.format(new Date()));
        sb.append("\n");
        sb.append("appKey: ");
        sb.append(appKey);
        sb.append("\n");
        sb.append("ip: ");
        sb.append(getIp());
        sb.append("\n");
        sb.append("os: ");
        sb.append(OS_NAME);
        sb.append("\n");
        sb.append("sdk: ");
        sb.append(sdkName);
        sb.append("\n");
        BIZ_LOGGER.info(sb.toString());
    }

    /**
     * 打印http请求日志
     */
    public static void logHttpRequest(String httpMethod, String url, Map<String, String> queryParams, Map<String, String> headers, String body) throws UnsupportedEncodingException {
        if (!needEnableLogger){
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(httpMethod);
        sb.append(" ");
        sb.append(getUrl(url, queryParams));
        sb.append("\n");
        sb.append("RequestHeaders:\n");
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                sb.append(entry.getKey());
                sb.append(" : ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
        }
        sb.append("RequestBody:\n");
        if (StringUtils.isNotBlank(body)) {
            sb.append(body);
            sb.append("\n");
            sb.append("--> END (");
            sb.append(body.getBytes("UTF-8").length);
            sb.append("-byte body)\n");
        } else {
            sb.append("--> END (0-byte body)\n");
        }
        BIZ_LOGGER.info(sb.toString());

    }

    /**
     * 打印http响应日志
     */
    public static void logHttpResponse(String httpMethod, String url, Map<String, String> queryParams, Map<String, String> headers, String body) throws UnsupportedEncodingException {
        if (!needEnableLogger){
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<-- ");
        sb.append(httpMethod);
        sb.append(" ");
        sb.append(getUrl(url, queryParams));
        sb.append("\n");
        sb.append("ResponseHeaders:\n");
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                sb.append(entry.getKey());
                sb.append(" : ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
        }
        sb.append("ResponseBody:\n");
        if (StringUtils.isNotBlank(body)) {
            sb.append(body);
            sb.append("\n");
            sb.append("<-- END (");
            sb.append(body.getBytes("UTF-8").length);
            sb.append("-byte body)\n");
        } else {
            sb.append("<-- END (0-byte body)\n");
        }
        BIZ_LOGGER.info(sb.toString());
    }

    private static String getUrl(String url, Map<String, String> queryParams) {
        if (queryParams != null && queryParams.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("?");
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = url + stringBuilder.toString().substring(0, stringBuilder.length() - 1);
        }
        return url;
    }
}
