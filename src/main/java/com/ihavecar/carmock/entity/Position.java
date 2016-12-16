package com.ihavecar.carmock.entity;

/**
 * Created by lsz on 2016/12/5.
 */
public class Position {
    int current;

    public Position(int current) {
        this.current = current;
    }

    public int getCurrent() {
        return current;
    }

    public Position setCurrent(int current) {
        this.current = current;
        return this;
    }
    public Position reset(){
        this.current = -1;
        return this;
    }
    public Position next(){
        this.current++;
        return this;
    }
}
