package com.yang.springbootyangclub.model.entity.user.enums;

/**
 * package name : com.young.springbootstarbucks.model.entity
 * Date : 2023-05-29
 * Author : zilet
 * Project : springboot-starbucks
 * Description :
 */
public enum PersonType {
    CEO("대표"),
    ASSOCIATE_MANAGER("대리"),
    ASSOCIATE("주임"),
    EMPLOYEE("사원");

    private String value;

    PersonType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
