package com.yang.springbootyangclub.model.entity.user.repository;

import com.yang.springbootyangclub.model.entity.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * package name : com.yang.springbootyangclub.model.entity.user.repository
 * Date : 2023-05-29
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
