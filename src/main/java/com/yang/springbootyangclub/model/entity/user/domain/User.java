package com.yang.springbootyangclub.model.entity.user.domain;

import com.yang.springbootyangclub.model.entity.user.enums.PersonType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * package name : com.young.springbootstarbucks.model.entity
 * Date : 2023-05-23
 * Author : zilet
 * Project : springboot-starbucks
 * Description :
 */

@Getter
@Setter
@Entity(name = "Person")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer personSeq;

    @Column(nullable = false)
    String id;

    @Column(nullable = false, name = "pwd")
    String password;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    PersonType personType;

    @Column(nullable = false)
    String name;

    @Column
    String tel;

    @Column
    String hp;

    @Column
    String email;

    @Column
    String fax;

}
