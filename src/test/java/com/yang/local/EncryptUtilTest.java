package com.yang.local;

import com.yang.springbootyangclub.libs.encrypts.EncryptUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * package name : com.yang.local
 * Date : 2023-08-23
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
@RunWith(SpringRunner.class)
public class EncryptUtilTest {

    String value = "sample test .. ! ";

    @Test
    public void encryptByAES(){
        String encryptData = EncryptUtil.encrypt(value);
        System.out.println("encrypt = " + encryptData);
        String decryptData = EncryptUtil.decrypt(encryptData);
        System.out.println("decrypt = " + decryptData);
    }

}
