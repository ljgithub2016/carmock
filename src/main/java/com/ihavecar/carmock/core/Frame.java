package com.ihavecar.carmock.core;

/**
 * Created by lsz on 2016/12/2.
 */
public interface Frame<T> extends Runnable {
    void setDoEntiry(T entiry);
}
