package com.solvd.deadlock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main2 {
    private static final Logger LOGGER = LogManager.getLogger(Main2.class);
    public static void main(String[] args){
        Object objA = new Object();
        Object objB = new Object();
        Runnable func1 = ()->{
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
        };
        Runnable func2 = ()->{
            LOGGER.info("Thread B start");
            synchronized (objB){
                synchronized (objA){

                }
            }
            LOGGER.info("Thread B stopped");
        };
        Thread threadA = new Thread(func1,"0");
        Thread threadB = new Thread(func2,"1");
        threadA.start();
        threadB.start();
    }
}
