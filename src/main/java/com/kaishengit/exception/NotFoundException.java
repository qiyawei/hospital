package com.kaishengit.exception;

/**
 * Created by qiyawei on 2016/5/20.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(){};

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(Throwable throwable){
        super(throwable);
    }

    public NotFoundException(String message,Throwable throwable){
        super(message,throwable);
    }
}
