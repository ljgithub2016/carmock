package com.ihavecar.carmock.core;

/**
 * Created by lsz on 2016/12/2.
 */
public interface Work<T>{
    void putWorkFrame(T t);
    void delWorkFrame(T t);
    void start();
}
