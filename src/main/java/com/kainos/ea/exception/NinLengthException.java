package com.kainos.ea.exception;

public class NinLengthException extends Throwable{
    @Override
    public String getMessage() {
        return "Nin length is not correct";
    }
}
