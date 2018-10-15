package com.spring.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by haoxy on 2018/10/15.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@Entity
public class CommonUser {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String nickname;
    @Column
    private String email;

    @Column
    private LocalDate birthday;
    @Column(nullable = false)
    private LocalDateTime registerTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public CommonUser(String username, String nickname, String email, LocalDate birthday, LocalDateTime registerTime) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.birthday = birthday;
        this.registerTime = registerTime;
    }
    public CommonUser(){

    }

    @Override
    public String toString() {
        return "CommonUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", registerTime=" + registerTime +
                '}';
    }
}
