package com.ihavecar.carmock.exception;

/**
 * Created by lsz on 2016/12/14.
 */
public class RoadInitException extends RuntimeException {
    public RoadInitException() {
        super();
    }

    public RoadInitException(String message) {
        super(message);
    }

    public RoadInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoadInitException(Throwable cause) {
        super(cause);
    }

    protected RoadInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
