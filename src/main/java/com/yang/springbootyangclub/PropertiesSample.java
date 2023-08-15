package com.yang.springbootyangclub;

import lombok.Getter;

@Getter
public class PropertiesSample {

    private String username;

    private String password;

    public PropertiesSample(String username, String password) {

        this.username = username;
        this.password = password;
    }


}
