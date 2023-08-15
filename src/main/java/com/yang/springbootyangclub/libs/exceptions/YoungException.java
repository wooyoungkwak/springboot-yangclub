package com.yang.springbootyangclub.libs.exceptions;

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

    public YoungException(String message, YoungExceptionCode code) {
        super(message + " /n" + code.getValue());
    }

    public YoungException(YoungExceptionCode code) {
        super(code.getValue());
    }

    public YoungException(Throwable e) {
        super(e);
    }

    public YoungException(YoungExceptionCode code, Throwable e) {
        super(code.getValue(), e);
    }



}
