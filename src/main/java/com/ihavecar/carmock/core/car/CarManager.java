package com.ihavecar.carmock.core.car;

import com.ihavecar.carmock.core.Manager;
import com.ihavecar.carmock.entity.Car;
import com.ihavecar.carmock.frame.CarFrame;
import com.ihavecar.carmock.work.FrameWork;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;

/**
 * 车辆调度中心
 * 车辆管理器，用来管理分发对应状态的车辆
 * Created by lsz on 2016/12/5.
 */
public class CarManager implements Manager<Car> {
    BlockingQueue<Car> queue = new LinkedBlockingQueue<>(1000);
    Function<CarManagerInfo,CarFrame> managerFunction = null;
    FrameWork frameWork = null;//属于当前管理器的时间队列

    public CarManager(Function<CarManagerInfo, CarFrame> managerFunction
            , FrameWork frameWork) {
        this.managerFunction = managerFunction;
        this.frameWork = frameWork;
    }

    public FrameWork getFrameWork() {
        return frameWork;
    }

    public CarManager setFrameWork(FrameWork frameWork) {
        this.frameWork = frameWork;
        return this;
    }

    @Override
    public void addToManager(Car entiry) {
        queue.add(entiry);
    }

    @Override
    public void removeFromManager(Car entiry) {
        queue.remove(entiry);
    }

    public Function<CarManagerInfo, CarFrame> getManagerFunction() {
        return managerFunction;
    }

    public CarManager setManagerFunction(Function<CarManagerInfo, CarFrame> managerFunction) {
        this.managerFunction = managerFunction;
        return this;
    }

    @Override
    public void start() {
        CarManager carManager = this;
        frameWork.start();
        new Thread(() -> {
            while (true){
                try {
                    Car car = queue.take();
                    CarFrame frame =  managerFunction.apply(new CarManagerInfo(car,carManager));
                    frameWork.putWorkFrame(frame);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
