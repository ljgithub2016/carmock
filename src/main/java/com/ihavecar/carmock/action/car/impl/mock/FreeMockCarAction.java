package com.ihavecar.carmock.action.car.impl.mock;

import com.google.gson.Gson;
import com.ihavecar.carmock.action.car.CarAction;
import com.ihavecar.carmock.entity.Car;
import com.ihavecar.carmock.exception.CarRunningException;
import com.ihavecar.carmock.exception.Try;
import com.ihavecar.carmock.log.LogLevel;
import com.ihavecar.carmock.log.LogUtils;
import com.ihavecar.carmock.utils.HttpUtils;
import sun.rmi.runtime.Log;

import java.io.IOException;

/**
*Free车辆模拟行为实现类
* @author Created by lsz on 2016/12/8.
* @param <T>
*/
public class FreeMockCarAction implements CarAction {
    @Override
    public void doRun(Car car) {
        car.next();
        LogUtils.log(LogLevel.DEBUG,"mock车辆经过--%s--点!",car.getCurrentPoint());
    }
    @Override
    public void doEnd(Car car) {
        car.resetPosition();
        LogUtils.log(LogLevel.DEBUG,"mock车辆在--%s--点结束!",car.getCurrentPoint());
    }

}
