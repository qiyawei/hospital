package com.kaishengit.exception;

/**
 * Created by qiyawei on 2016/5/20.
 */
public class LockedException extends RuntimeException {
    public LockedException(){};

    public LockedException(String message){
        super(message);
    }

    public LockedException(Throwable throwable){
        super(throwable);
    }

    public LockedException(String message,Throwable throwable){
        super(message,throwable);
    }
}
