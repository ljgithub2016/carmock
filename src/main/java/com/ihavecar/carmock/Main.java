package com.ihavecar.carmock;

import static com.ihavecar.carmock.config.Global.getInt;
import static com.ihavecar.carmock.config.Global.getString;
import static com.ihavecar.carmock.entity.Constants.*;

import com.ihavecar.carmock.core.car.CarFactory;
import com.ihavecar.carmock.core.car.CarManager;
import com.ihavecar.carmock.core.car.CarManagerFunction;
import com.ihavecar.carmock.core.car.CarPool;
import com.ihavecar.carmock.work.FrameWork;
import com.ihavecar.carmock.work.QueueFrameWorkGroup;
import com.ihavecar.carmock.work.SleepThreadQueueFrameWork;
/**
 * Created by lsz on 2016/12/5.
 */
public class Main {
    public static void main(String[] args) {

        //初始化车辆相关
        CarFactory factory = CarFactory.mock(getInt(CAR_COUNT));
        CarPool carPool = CarPool.getInstance().addAll(factory.initCars());
        FrameWork work3 = new SleepThreadQueueFrameWork(1,3000,"car_work_3s");
        FrameWork work5 = new SleepThreadQueueFrameWork(1,5000,"car_work_5s");
        FrameWork workGroup = new QueueFrameWorkGroup(getString(WORKGROUP_NAME),work3,work5);
        CarManager manager = new CarManager(new CarManagerFunction(),workGroup);
        carPool.getFreeCars()
                .forEach(car->manager.addToManager(car));

        manager.start();
    }
}
