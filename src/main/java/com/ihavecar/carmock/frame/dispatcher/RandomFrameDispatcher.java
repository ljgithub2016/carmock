package com.ihavecar.carmock.frame.dispatcher;

import java.util.Random;

/**
 * Created by lsz on 2016/12/6.
 */
public class RandomFrameDispatcher extends AbstractFrameDispatcher implements FrameDispatcher{
    Random random = new Random();
    @Override
    int get() {
        return random.nextInt();
    }
}
