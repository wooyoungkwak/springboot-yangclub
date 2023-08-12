package com.yang.springbootyangclub.exception;

/**
 * package name : com.yang.springbootyangclub.exception
 * Date : 2023-06-03
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
public class YoungException extends Exception{

    public YoungException(String message) {
        super(message);
    }

    public YoungException(String message, ExceptionCode code) {
        super(message + " /n" + code.getValue());
    }

    public YoungException(ExceptionCode code) {
        super(code.getValue());
    }

    public YoungException(Throwable e) {
        super(e);
    }

    public YoungException(ExceptionCode code, Throwable e) {
        super(code.getValue(), e);
    }



}
