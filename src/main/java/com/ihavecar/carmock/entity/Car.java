package com.ihavecar.carmock.entity;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by lsz on 2016/12/5.
 */
public class Car {
    private String name;
    private Road road;
    private Position position;
    private CarState carState;

    public Car() {
    }
    public Car(String name){
        this.name = name;
    }
    public Car(String name,Road road, Position position, CarState carState) {
        this.road = road;
        this.position = position;
        this.carState = carState;
    }

    public Car(Road road, Position position) {
        this.road = road;
        this.position = position;
    }

    public Road getRoad() {
        return road;
    }

    public Car setRoad(Road road) {
        this.road = road;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Car setPosition(Position position) {
        this.position = position;
        return this;
    }

    public CarState getCarState() {
        return carState;
    }

    public Car setCarState(CarState carState) {
        this.carState = carState;
        return this;
    }

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }
    public void resetPosition(){
        if(position == null){
            position = new Position(-1);
        }
        position.reset();
    }
    public Position next(){
        return position.next();
    }
    public Point getCurrentPoint(){
        return this.getRoad().getPoint(this.position);
    }
    public void loadRoadIfEmpty(Supplier<Road> supplier){
        if(road == null){
            resetPosition();
            road = supplier.get();
        }
    }
    public boolean EOF(){
        return this.getRoad().isEnd(position);
    }
    public void ifEOF(Consumer<Car> consumer){
        if(EOF()){
           consumer.accept(this);
        }
    }
    public void ifEOFThenState(CarState carState,Consumer<Car> consumer){
        if(EOF()&&this.getCarState() == carState){
            consumer.accept(this);
        }
    }
    public void ifState(CarState carState,Consumer<Car> consumer){
        if(this.getCarState() == carState){
            consumer.accept(this);
        }
    }
}
