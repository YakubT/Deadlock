package com.solvd.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        Object objA = new Object();
        Object objB = new Object();
        MyThread threadA = new MyThread();
        MyThread threadB = new MyThread();
        threadA.setIFunc(()->{
            LOGGER.info("Thread A start");
            synchronized (objA){
                try {
                    Thread.sleep(100);
                }
                catch (Exception e){
                    LOGGER.info(e);
                }
                synchronized (objB){

                }
            }
            LOGGER.info("Thread A stopped");
        });
        threadB.setIFunc(()->{
            LOGGER.info("Thread B start");
            synchronized (objB){
                synchronized (objA){

                }
            }
            LOGGER.info("Thread B stopped");
        });
        threadA.start();
        threadB.start();
    }
}
