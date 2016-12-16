package com.ihavecar.carmock.frame;

import com.ihavecar.carmock.core.Frame;
import com.ihavecar.carmock.core.car.CarManager;
import com.ihavecar.carmock.entity.Car;
import com.ihavecar.carmock.road.RoadInitalize;

/**
 * Created by lsz on 2016/12/5.
 */
public interface CarFrame extends Frame<Car> {
    void setRoadInit(RoadInitalize roadInit);
    void setEndManager(CarManager carManager);
}
