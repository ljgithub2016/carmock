package com.ihavecar.carmock.exception;

/**
 * Created by lsz on 2016/12/8.
 */
public class CarRunningException extends RuntimeException{
    public CarRunningException() {
    }

    public CarRunningException(String message) {
        super(message);
    }

    public CarRunningException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarRunningException(Throwable cause) {
        super(cause);
    }

    public CarRunningException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
