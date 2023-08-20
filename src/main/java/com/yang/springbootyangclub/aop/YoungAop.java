package com.yang.springbootyangclub.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.springbootyangclub.libs.utils.ObjectMapperUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * package name : com.yang.springbootyangclub.aop
 * Date : 2023-08-16
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */

@Aspect
@Component
public class YoungAop {

    /**
     * Data Structure
     *
     * {
     *     status: success or fail
     *     data: ....  ( if success )
     *     message: .... ( if fail )
     * }
     *
     */

    private ObjectMapper objectMapper = new ObjectMapper();

    @Pointcut(value = " execution(* com.yang.springbootyangclub.controller..*PostController.*(..) )")
    private String controllerPointCut(ProceedingJoinPoint joinPoint) {
        ResultData resultData = new ResultData();

        try {
            resultData.data = ObjectMapperUtil.objectToJsonStr(objectMapper, joinPoint.proceed());
            resultData.status = "success";
            resultData.message = "";
        } catch (Throwable e) {
            resultData.data = "";
            resultData.status = "fail";
            resultData.message = e.getMessage();
            e.printStackTrace();
        } finally {
            return ObjectMapperUtil.objectToJsonStr(objectMapper, resultData);
        }
    }
}
