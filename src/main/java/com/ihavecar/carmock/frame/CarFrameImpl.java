package com.ihavecar.carmock.frame;

import com.ihavecar.carmock.action.car.CarAction;
import com.ihavecar.carmock.core.car.CarManager;
import com.ihavecar.carmock.entity.Car;
import com.ihavecar.carmock.entity.CarState;
import com.ihavecar.carmock.entity.Point;
import com.ihavecar.carmock.log.LogUtils;
import com.ihavecar.carmock.road.RoadInitalize;
import com.ihavecar.carmock.test.TimeMonitor;

/**
 * 空车运行的帧
 * Created by lsz on 2016/12/5.
 */
public class CarFrameImpl implements CarFrame {
    Car car;
    RoadInitalize roadInitalize;
    CarManager endManager;
    @Override
    public void setDoEntiry(Car entiry) {
        this.car = entiry;
    }

    @Override
    public void run() {
        LogUtils.log("%s-process!spend time is %d ms",car.getName(), TimeMonitor.spendTime(car.getName()));//记录处理车
        //空车如果路线为空，则初始化路线
        car.loadRoadIfEmpty(()->roadInitalize.load());

        //对应状态的车辆动作
        doRun(car);


        Point point = car.getCurrentPoint();
        LogUtils.log(car.getName()+"-------current point is ==="+car.getPosition().getCurrent()+"=="+LogUtils.toJSON(point));

        //增加到达终点的事件触发
        doCompleted(car);

        sleep(1);
        endManager.addToManager(car);

    }
    private void doRun(Car car){
        car.ifState(CarState.Free,(c)-> CarAction.free().doRun(c));
        car.ifState(CarState.PreOrder,(c)-> CarAction.preOrder().doRun(c));
        car.ifState(CarState.InOrder,(c)-> CarAction.inOrder().doRun(c));
    }
    private void doCompleted(Car car){
        car.ifEOFThenState(CarState.Free,(c)->CarAction.free().doEnd(c));
        car.ifEOFThenState(CarState.PreOrder,(c)->CarAction.preOrder().doEnd(c));
        car.ifEOFThenState(CarState.InOrder,(c)->CarAction.inOrder().doEnd(c));
    }
    @Override
    public void setRoadInit(RoadInitalize roadInit) {
        this.roadInitalize = roadInit;
    }

    @Override
    public void setEndManager(CarManager carManager) {
        this.endManager = carManager;
    }
    public void sleep(long ms){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
