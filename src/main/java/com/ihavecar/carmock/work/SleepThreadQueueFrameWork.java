package com.ihavecar.carmock.work;

import com.ihavecar.carmock.core.Frame;
import com.ihavecar.carmock.exception.Try;
import com.ihavecar.carmock.log.LogUtils;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by lsz on 2016/12/2.
 */
public class SleepThreadQueueFrameWork extends QueueFrameWork{
    private String name;
    private Executor executor ;
    private int workNum = 1;
    private long sleepTime = 1000;
    public SleepThreadQueueFrameWork(int workNum,long sleepTime,String name) {
        if(workNum<=0){
            throw  new NumberFormatException("workNum must gt 0;");
        }
        workQueue = new ConcurrentLinkedQueue();
        this.workNum = workNum;
        this.sleepTime = sleepTime;
        executor = Executors.newFixedThreadPool(this.workNum);
        this.name = name;
    }
    public SleepThreadQueueFrameWork(String name){
        this(1,1000,name);
    }
    @Override
    public void start() {
        new Thread(()->{
        LogUtils.log(name+"-work-start!");
        while (true){
            List<Frame> frames = pollFrames();
            frames.forEach((frame)->{
                executor.execute(()-> Try.lift(frame).ifPresent(x->x.run()).ifThrowable(e->e.printStackTrace()));
            });
            sleep();
        }
        }).start();

    }
    public void sleep(){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
