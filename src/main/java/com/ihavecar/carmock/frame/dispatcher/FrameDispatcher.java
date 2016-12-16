package com.ihavecar.carmock.frame.dispatcher;

import com.ihavecar.carmock.core.Frame;
import com.ihavecar.carmock.work.FrameWork;

/**
 * 在时间队列阶段对帧进行分配
 * Created by lsz on 2016/12/6.
 */
public interface FrameDispatcher {
    FrameWork put(Frame frame, FrameWork[] frameWorks);
}
