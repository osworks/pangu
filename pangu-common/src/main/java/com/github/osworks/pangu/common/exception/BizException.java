package com.github.osworks.pangu.common.exception;

import com.github.osworks.pangu.toolbox.util.Strings;

import lombok.Getter;

/**
 * Business Exception
 * 
 * @author xiongchun
 * @since 1.0.0
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -1030469420838093832L;

    @Getter
    private int code = -1;

    public BizException() {}

    public BizException(String msg) {
        super(msg);
    }

    public BizException(String messageTemplate, Object... params) {
        super(Strings.format(messageTemplate, params));
    }

    public BizException(int code, String msg) {
        super(Strings.format("code：{}，msg：{}", code, msg));
        this.code = code;
    }

    public BizException(int code, String messageTemplate, Object... params) {
        super(Strings.format("code：{}，" + messageTemplate, params));
        this.code = code;
    }

    public BizException(Throwable throwable) {
        super(throwable);
    }

    public BizException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
