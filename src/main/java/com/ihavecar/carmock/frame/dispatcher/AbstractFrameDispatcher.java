package com.ihavecar.carmock.frame.dispatcher;

import com.ihavecar.carmock.core.Frame;
import com.ihavecar.carmock.work.FrameWork;

/**
 * Created by lsz on 2016/12/6.
 */
public abstract class AbstractFrameDispatcher implements FrameDispatcher {
    public FrameWork put(Frame frame, FrameWork[] frameWorks){
        if(frameWorks == null || frameWorks.length == 0 )return null;
        FrameWork frameWork = frameWorks[get()%frameWorks.length];
        frameWork.putWorkFrame(frame);
        return frameWork;
    }
    abstract int get();
}
