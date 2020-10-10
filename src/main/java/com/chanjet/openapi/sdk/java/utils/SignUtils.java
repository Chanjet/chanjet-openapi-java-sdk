package com.chanjet.openapi.sdk.java.utils;

import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: zsc
 * @create: 2020/10/10 11:43 上午
 **/
public class SignUtils {
    /**
     * 对报文进行加签
     *
     * @param msg       需要签名的字符串
     * @param appKey    开发者中心的appKey
     * @param signKey   开发者中心的加签秘钥
     * @param timestamp 时间戳
     * @return 签名
     */
    public static String sign(String msg, String appKey, String signKey, String timestamp) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(msg)) {
            map = new Gson().fromJson(msg, Map.class);
        }
        map.put("timestamp", timestamp);
        map.put("appKey", appKey);
        return getSign(assembelSignaturingData(map), signKey);
    }

    /**
     * 计算字符串的MD5值
     *
     * @param signStr   需要签名的字符串
     * @param appSecret 开发者中心的appSecret
     * @return
     */
    private static String getSign(String signStr, String appSecret) throws UnsupportedEncodingException {
        signStr = signStr + appSecret;
        return DigestUtils.md5Hex(signStr.getBytes("UTF-8"));
    }

    /**
     * 顺序组装请求参数，用于签名/校验
     *
     * @param data 需要签名的map
     * @return
     */
    private static String assembelSignaturingData(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>(data);
        for (Map.Entry<String, Object> ent : treeMap.entrySet()) {
            String name = ent.getKey();
            if (!"sign".equals(name)) {
                sb.append(name).append('=').append(ent.getValue()).append('&');
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
