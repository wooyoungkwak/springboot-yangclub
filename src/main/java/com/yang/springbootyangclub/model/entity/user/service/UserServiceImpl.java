package com.yang.springbootyangclub.model.entity.user.service;

import com.yang.springbootyangclub.model.entity.user.domain.User;
import com.yang.springbootyangclub.model.entity.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * package name : com.yang.springbootyangclub.model.entity.user.service
 * Date : 2023-05-29
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User get(Integer personSeq) {
        Optional optional = userRepository.findById(personSeq);
        if ( optional.isEmpty()) {
            return null;
        }
        return userRepository.findById(personSeq).get();
    }

    @Override
    public User set(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> sets(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public boolean isUser(String id, String password) {
        User user = userRepository.findUserByIdAndPassword(id, password);
        if ( user != null) return true;
        return false;
    }

}
