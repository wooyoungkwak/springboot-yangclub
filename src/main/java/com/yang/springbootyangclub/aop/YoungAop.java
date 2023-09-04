package com.yang.springbootyangclub.aop;

import com.yang.springbootyangclub.libs.utils.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

    @Around(value = " execution(* com.yang.springbootyangclub.controller..*PostController.*(..) )")
    private Object controllerPointCut(ProceedingJoinPoint joinPoint) {
        ResultData resultData = new ResultData();

        try {
            // ==================================
            // if bebore process
            // ..
            // ==================================

            resultData.data = JsonUtil.toString(joinPoint.proceed());
            resultData.status = "success";
            resultData.message = "";

            // ==================================
            // if after prcocess
            // ..
            // ==================================

        } catch (Throwable e) {
            resultData.data = "";
            resultData.status = "fail";
            resultData.message = e.getMessage();
            e.printStackTrace();
        } finally {
            return JsonUtil.toString(resultData);
        }
    }

}
