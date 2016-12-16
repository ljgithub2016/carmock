package com.ihavecar.carmock.core.car;

import com.ihavecar.carmock.entity.Car;

import java.util.Map;

/**
 * 定义接口生产初始化车辆
 * Created by lsz on 2016/12/5.
 */
public interface CarFactory {
    Map<String,Car> initCars();
    static CarFactory mock(int n){
        return new MockCarFactory(n);
    }
    static CarFactory mock(){
        return new MockCarFactory(1);
    }
}
