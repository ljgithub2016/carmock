package com.ihavecar.carmock.action;

/**
 *行为接口 
 * @author Created by lsz on 2016/12/8.
 * @param <T>
 */
public interface Action<T> {
	/**
	 * 普通行为
	 * @param thiz
	 */
    void doRun(T thiz);
    
    /**
     * 终止行为 
     * @param thiz
     */
    void doEnd(T thiz);
}
