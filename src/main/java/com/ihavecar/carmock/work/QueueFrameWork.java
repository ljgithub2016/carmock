package com.ihavecar.carmock.work;

import com.google.common.collect.Lists;
import com.ihavecar.carmock.core.Frame;

import java.util.List;
import java.util.Queue;

/**
 * Created by lsz on 2016/12/2.
 */
public abstract class QueueFrameWork implements FrameWork {
    Queue<Frame> workQueue ;

    @Override
    public void putWorkFrame(Frame frame) {
        workQueue.add(frame);
    }

    @Override
    public void delWorkFrame(Frame frame) {
        workQueue.remove(frame);
    }
    public Frame pollFrame(){
        return workQueue.poll();
    }
    public List<Frame> pollFrames(){
        List<Frame> frameList = Lists.newArrayList();
        while(true){
            Frame frame = workQueue.poll();
            if(frame == null){
                return frameList;
            }
            frameList.add(frame);
        }
    }
}
