package com.yang.database;

import com.yang.springbootyangclub.ApplicationTests;
import com.yang.springbootyangclub.model.entity.user.domain.User;
import com.yang.springbootyangclub.model.entity.user.enums.PersonType;
import com.yang.springbootyangclub.model.entity.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * package name : com.yang.database
 * Date : 2023-05-29
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "debug2")
@SpringBootTest(classes = ApplicationTests.class)
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void get() {
        Integer personSeq = 1;
        User user = userService.get(personSeq);

        if (user != null) {
            System.out.println(user.getName());
            System.out.println(user.getPersonType().getValue());
        }
    }

    @Test
    public void set() {
        User user = new User();
        user.setEmail("sample@gmail.com");
        user.setName("홍길동");
        user.setFax("123-4567");
        user.setHp("010-1234-5678");
        user.setTel("123-4567");
        user.setPassword("ghdrlfehd");
        user.setId("hong");
        user.setPersonType(PersonType.EMPLOYEE);

        user = userService.set(user);

        if (user != null) {
            System.out.println(user.getName());
            System.out.println(user.getPersonType().getValue());
        }
    }


}
