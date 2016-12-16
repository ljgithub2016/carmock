package com.ihavecar.carmock.work;

import com.ihavecar.carmock.core.Frame;
import com.ihavecar.carmock.frame.dispatcher.FrameDispatcher;
import com.ihavecar.carmock.frame.dispatcher.IncrFrameDispatcher;
import com.ihavecar.carmock.log.LogLevel;
import com.ihavecar.carmock.log.LogUtils;

/**
 * Created by lsz on 2016/12/2.
 */
public class QueueFrameWorkGroup implements  FrameWorkGroup {
    private FrameWork[] frameWorks;
    private String name ;
    private FrameDispatcher dispatcher = new IncrFrameDispatcher();
    public QueueFrameWorkGroup(String name,FrameWork ... frameWorks){
        this.frameWorks = frameWorks;
        this.name = name;
    }
    public QueueFrameWorkGroup(FrameWork ... fameWorks){
        this.name = "workgroup-"+Math.random();
        this.frameWorks = fameWorks;
    }
    @Override
    public void putWorkFrame(Frame frame) {
        FrameWork frameWork =  dispatcher.put(frame,frameWorks);
        LogUtils.log(LogLevel.DEBUG,"dispatcher to -%s",frameWork.getName());
    }

    @Override
    public void delWorkFrame(Frame frame) {

    }

    @Override
    public void start() {
        LogUtils.log(name+"-work-start!");
        for (FrameWork work:frameWorks){
            work.start();
        }
    }

    public void putWorks(Frame... frames) {
        for (Frame frame:frames){
            putWorkFrame(frame);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
