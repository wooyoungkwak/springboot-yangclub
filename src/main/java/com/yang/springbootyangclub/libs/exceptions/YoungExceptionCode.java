package com.yang.springbootyangclub.libs.exceptions;

import lombok.Getter;

/**
 * package name : com.yang.springbootyangclub.exception
 * Date : 2023-06-03
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
@Getter
public enum YoungExceptionCode {

    VIEW_404("페이지를 찾을 수 없습니다."),

    VIEW_405("허용되지 않는 메서드를 요청 하고 있습니다.")

    ;

    private String value;

    YoungExceptionCode(String _value) {
        this.value = _value;
    }

}
