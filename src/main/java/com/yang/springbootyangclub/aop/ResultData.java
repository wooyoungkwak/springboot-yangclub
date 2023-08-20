package com.yang.springbootyangclub.aop;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultData {
    String status;
    String message;
    String data;
}
