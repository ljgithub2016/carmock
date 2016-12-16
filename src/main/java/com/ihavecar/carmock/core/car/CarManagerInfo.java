package com.ihavecar.carmock.core.car;

import com.ihavecar.carmock.entity.Car;

/**
 * Created by lsz on 2016/12/5.
 */
public class CarManagerInfo {
    private Car car;
    private CarManager manager;

    public CarManagerInfo() {
    }

    public CarManagerInfo(Car car, CarManager manager) {
        this.car = car;
        this.manager = manager;
    }

    public Car getCar() {
        return car;
    }

    public CarManagerInfo setCar(Car car) {
        this.car = car;
        return this;
    }

    public CarManager getManager() {
        return manager;
    }

    public CarManagerInfo setManager(CarManager manager) {
        this.manager = manager;
        return this;
    }
}
