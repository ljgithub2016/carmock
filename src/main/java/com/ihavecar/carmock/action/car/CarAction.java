package com.ihavecar.carmock.action.car;

import com.ihavecar.carmock.action.Action;
import com.ihavecar.carmock.action.car.impl.OrderAction;
import com.ihavecar.carmock.action.car.impl.PreOrderAction;
import com.ihavecar.carmock.action.car.impl.mock.FreeMockCarAction;
import com.ihavecar.carmock.entity.Car;

 /**
 *车辆行为接口 
 * @author Created by lsz on 2016/12/8.
 * @param <T>
 */
public interface CarAction extends Action<Car>{


    static CarAction free(){
        return Actions.freeCarAction;
    }
    static CarAction preOrder(){
        return Actions.preOrderAction;
    }
    static CarAction inOrder(){
        return Actions.orderAction;
    }
    
   class Actions{
        private final static CarAction freeCarAction = new FreeMockCarAction();
        private final static CarAction preOrderAction = new PreOrderAction();
        private final static CarAction orderAction = new OrderAction();
    }
}
