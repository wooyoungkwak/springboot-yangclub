package com.yang.springbootyangclub;

import com.yang.springbootyangclub.config.AnnotationConfig;
import com.yang.springbootyangclub.libs.annotations.YoungAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * package name : com.yang.springbootyangclub
 * Date : 2023-08-15
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
public class AnnotationSample {

    @YoungAnnotation(value = "sample", version = "1.0.1")
    public void printAnnotation(){
        Method[] methods = AnnotationSample.class.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("printAnnotation")) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    YoungAnnotation youngAnnotation = (YoungAnnotation) annotation;
                    System.out.println("version :" + youngAnnotation.version());
                    System.out.println("value : " + youngAnnotation.value());
                }
            }
        }
    }
}
