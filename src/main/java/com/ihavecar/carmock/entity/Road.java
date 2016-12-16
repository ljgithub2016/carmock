package com.ihavecar.carmock.entity;

/**
 * Created by lsz on 2016/12/5.
 */
public class Road {
    Point[] lines = null;

    public Road(Point[] lines) {
        this.lines = lines;
    }

    public boolean isEnd(Position position){
        return lines.length == position.getCurrent()+1;
    }
    public Point getPoint(Position position){
        return lines[position.getCurrent()];
    }
}
