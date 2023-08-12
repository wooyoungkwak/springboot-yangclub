package com.yang.springbootyangclub.model.entity.user.service;

import com.yang.springbootyangclub.model.entity.user.domain.User;

import java.util.List;

/**
 * package name : com.yang.springbootyangclub.model.entity.user.service
 * Date : 2023-05-29
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */

public interface UserService {

    User get(Integer personSeq);

    User set(User user);

    List<User> sets(List<User> users);
}
