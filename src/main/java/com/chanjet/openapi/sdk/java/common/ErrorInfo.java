package com.chanjet.openapi.sdk.java.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: zsc
 * @create: 2020/8/24 4:53 下午
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ErrorInfo implements Serializable {
    private static final long serialVersionUID = -336682010335821321L;
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 错误提示信息
     */
    private String hint;
}
