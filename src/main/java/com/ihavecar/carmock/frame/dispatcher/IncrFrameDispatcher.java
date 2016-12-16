package com.ihavecar.carmock.frame.dispatcher;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lsz on 2016/12/6.
 */
public class IncrFrameDispatcher extends AbstractFrameDispatcher implements FrameDispatcher {
    AtomicInteger i = new AtomicInteger(0);
    @Override
    int get() {
        return i.getAndIncrement();
    }
}
