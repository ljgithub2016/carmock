package com.ihavecar.carmock.road;

import com.ihavecar.carmock.core.Initailze;
import com.ihavecar.carmock.entity.Road;

/**
 * 路线获取接口
 * Created by lsz on 2016/12/5.
 */
public interface RoadInitalize extends Initailze<Road> {
    Road load();
}
