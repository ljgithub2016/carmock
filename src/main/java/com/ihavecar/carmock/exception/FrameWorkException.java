package com.ihavecar.carmock.exception;

/**
 * Created by lsz on 2016/12/6.
 */
public class FrameWorkException extends RuntimeException {
    public FrameWorkException() {
    }

    public FrameWorkException(String message) {
        super(message);
    }

    public FrameWorkException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameWorkException(Throwable cause) {
        super(cause);
    }

    public FrameWorkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
