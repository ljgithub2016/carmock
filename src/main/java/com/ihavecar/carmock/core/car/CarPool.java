package com.ihavecar.carmock.core.car;

import com.google.common.collect.Maps;
import com.ihavecar.carmock.entity.Car;
import com.ihavecar.carmock.entity.CarState;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 车辆池，用来初始化所有的车辆
 * Created by lsz on 2016/12/5.
 */
public class CarPool {
    private Map<String,Car> carMap = Maps.newHashMap();
    private static CarPool pool = new CarPool();

    public Set<Car> getCars(){
        return (Set<Car>) carMap.values();
    }
    public Set<Car> getFreeCars(){
        return getCarByState(CarState.Free);
    }
    public Set<Car> getPreCars(){
        return getCarByState(CarState.PreOrder);
    }
    public Set<Car> getInOrder(){
        return getCarByState(CarState.InOrder);
    }
    private CarPool(){}
    public static CarPool getInstance(){
        return pool;
    }
    public CarPool addAll(Map<String,Car> carMap){
        Map<String,Car> stringCarMap = this.carMap;
       carMap.forEach((x,y)->stringCarMap.put(x,y));
       return this;
    }
    public CarPool add(String name,Car car){
        carMap.put(name,car);
        return this;
    }
    public Set<Car> getCarByState(CarState state){
        return  carMap.values()
                .stream()
                .filter(car -> car.getCarState()== CarState.Free)
                .collect(Collectors.toSet());
    }
}
