package com.ihavecar.carmock.core;

/**
 * Created by lsz on 2016/12/5.
 */
public interface Manager<T> {
    void addToManager(T entiry);
    void removeFromManager(T entiry);
    void start();
}
