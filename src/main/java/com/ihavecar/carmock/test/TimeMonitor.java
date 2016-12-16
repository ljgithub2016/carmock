package com.ihavecar.carmock.test;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by lsz on 2016/12/6.
 */
public class TimeMonitor {
    private static Map<String,Long> timeMap = Maps.newHashMap();
    public static long spendTime(String name){
        Long lastTime = timeMap.get(name);
        long currentTime = System.currentTimeMillis();
        if(lastTime == null){
            lastTime = currentTime;
        }
        timeMap.put(name,currentTime);
        return currentTime - lastTime;
    }
}
