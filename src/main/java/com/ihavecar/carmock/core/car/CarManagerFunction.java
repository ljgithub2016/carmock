package com.ihavecar.carmock.core.car;

import com.ihavecar.carmock.frame.CarFrame;
import com.ihavecar.carmock.frame.CarFrameImpl;
import com.ihavecar.carmock.road.FreeRoadInitalize;

import java.util.function.Function;

/**
 * 用来包装carFrame的行为
 * Created by lsz on 2016/12/5.
 */
public class CarManagerFunction implements Function<CarManagerInfo,CarFrame> {

    @Override
    public CarFrame apply(CarManagerInfo carManagerInfo) {
        CarFrame carFrame = new CarFrameImpl();
        carFrame.setDoEntiry(carManagerInfo.getCar());
        carFrame.setEndManager(carManagerInfo.getManager());
        carFrame.setRoadInit(new FreeRoadInitalize());
        return carFrame;
    }
}
