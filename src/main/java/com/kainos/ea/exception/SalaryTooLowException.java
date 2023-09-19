package com.kainos.ea.exception;

public class SalaryTooLowException extends Throwable {

    @Override
    public String getMessage() {
        return "Salary must be above 20,000£";
    }
}
