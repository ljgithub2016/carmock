package com.ihavecar.carmock.core.car;

import com.google.common.collect.Maps;
import com.ihavecar.carmock.entity.Car;
import com.ihavecar.carmock.entity.CarState;

import java.util.Map;

/**
 * Created by lsz on 2016/12/5.
 */
public class MockCarFactory implements CarFactory {
    private int carNum = 1;
    public MockCarFactory(){
    }
    public MockCarFactory(int num){
        this.carNum = num;
    }
    @Override
    public Map<String, Car> initCars() {
        Map<String,Car> carMap = Maps.newHashMap();
        for (int i = 0 ; i<carNum ; i++){
            String name = "car#"+i;
            carMap.put(name,new Car(name).setCarState(CarState.Free));
        }

        return carMap;
    }
}
