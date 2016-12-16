package com.ihavecar.carmock.entity;

/**
 * Created by lsz on 2016/12/5.
 */
public class Point {
    private double lat;
    private double lng;

    public Point(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public Point setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLng() {
        return lng;
    }

    public Point setLng(double lng) {
        this.lng = lng;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Point{");
        sb.append("lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append('}');
        return sb.toString();
    }
}
