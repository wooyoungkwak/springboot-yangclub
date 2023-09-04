package com.yang.local;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * package name : com.yang.local
 * Date : 2023-08-24
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
public class Sample {

    String key;
    String val;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime regDate;

    public Sample() {
    }

    public Sample(String key, String val, LocalDateTime regDate) {
        this.key = key;
        this.val = val;
        this.regDate = regDate;
    }


    public String getKey() {
        return key;
    }

    public String getVal() {
        return val;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

}
