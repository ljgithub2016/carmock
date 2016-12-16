package com.ihavecar.carmock.entity;

import java.io.Serializable;
import java.util.Date;

/**
*车辆行为-消息封装类
* @author Created by lsz on 2016/12/8.
* @param <T>
*/
public class CarCurrentBody implements Serializable {
    public String name;
    public Double lat;
    public Double lng;

    private transient  Date updateTime;
    public CarCurrentBody() {
    }

    public CarCurrentBody(String name, Double lat, Double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public CarCurrentBody setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public CarCurrentBody setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLng() {
        return lng;
    }

    public CarCurrentBody setLng(Double lng) {
        this.lng = lng;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public CarCurrentBody setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
