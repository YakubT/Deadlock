package com.solvd.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(MyThread.class);
    private IFunc iFunc;
    @Override
    public void run() {
        iFunc.start();
        super.start();
    }

    public void setIFunc(IFunc iFunc) {
        this.iFunc = iFunc;
    }
}
