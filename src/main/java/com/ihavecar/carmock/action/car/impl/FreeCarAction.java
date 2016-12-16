package com.ihavecar.carmock.action.car.impl;

import com.google.gson.Gson;
import com.ihavecar.carmock.action.car.CarAction;
import com.ihavecar.carmock.entity.Car;
import com.ihavecar.carmock.entity.CarCurrentBody;
import com.ihavecar.carmock.exception.CarRunningException;
import com.ihavecar.carmock.exception.Try;
import com.ihavecar.carmock.utils.HttpUtils;
import static com.ihavecar.carmock.config.Global.*;
import static com.ihavecar.carmock.entity.Constants.*;
import java.io.IOException;

/**
*Free车辆行为实现类
* @author Created by lsz on 2016/12/8.
* @param <T>
*/
public class FreeCarAction implements CarAction {
    Gson gson = new Gson();
    
    @Override
    public void doRun(Car car) {
        if(car == null)return;
        Try.lift(car)
                .ifPresent(c->{
                       c.next();
                        postCurrentPosition(c);
                }).ifThrowable(e->e.printStackTrace());
    }
    
    @Override
    public void doEnd(Car car) {
        if(car == null) return ;
        Try.lift(car)
                .ifPresent(c->{
                        postEndPosition(c);
                        c.resetPosition();
                }).ifThrowable(e->e.printStackTrace());
    }
    /**
     * 上报位置
     * @param car
     * @param apiUrl
     * @return
     */
    public Car postPosition(Car car,String apiUrl)  {
        CarCurrentBody body = new CarCurrentBody(car.getName(),
                car.getCurrentPoint().getLat(),
                car.getCurrentPoint().getLng());
        try {
            HttpUtils.post(apiUrl,gson.toJson(body));
        } catch (IOException e) {
            throw new CarRunningException("车辆post 数据"+e);
        }
        return car;
    }
    
    /**
     * 上报当前位置
     * @param car
     * @return
     */
    public Car postCurrentPosition(Car car)  {
        String apiUrl = getString(POST_CURRENT_POSITION_API);
        return postPosition(car,apiUrl);
    }
    
    /**
     * 上报最后位置 
     * @param car
     * @return
     */
    public Car postEndPosition(Car car)  {
        String apiUrl = getString(POST_END_POSITION_API);
        return postPosition(car,apiUrl);
    }
}
