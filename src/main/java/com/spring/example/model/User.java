package com.spring.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by haoxy on 2018/10/15.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Entity
public class User {

    /**
     * unique=true是指这个字段的值在这张表里不能重复，所有记录值都要唯一，就像主键那样。
     * nullable=false是这个字段在保存时必需有值，不能还是null值就调用save去保存入库。
     */
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
