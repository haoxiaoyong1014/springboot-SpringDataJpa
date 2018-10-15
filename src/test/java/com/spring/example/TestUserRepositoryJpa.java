package com.spring.example;

import com.spring.example.Repository.UserRepository;
import com.spring.example.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by haoxy on 2018/10/15.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JpaApp.class})
public class TestUserRepositoryJpa {

    @Autowired
    private UserRepository userRepository;

    /**
     * 添加10条记录
     */
    @Test
    public void test(){
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));

    }
    /**
     * 测试查找全部记录
     */
    @Test
    public void testAll(){
        Assert.assertEquals(10,userRepository.findAll().size());
    }

    /**
     * 测试findByName
     */
    @Test
    public void testFindByName(){
        Assert.assertEquals(60,userRepository.findByName("FFF").getAge().longValue());
    }
    /**
     * 测试findUser
     */
    @Test
    public void testFindUser(){
        Assert.assertEquals(20,userRepository.findUser("BBB").getAge().longValue());
    }
    /**
     * 测试查找不重复数据
     */
    @Test
    public void testFindDistinct(){

    }

    /**
     * 测试findByNameAndAge
     */
    @Test
    public void testFindByNameAndAge(){
        Assert.assertEquals("FFF",userRepository.findByNameAndAge("FFF",60).getName());
    }

    /**
     * 测试删除姓名为AAA的User
     */
    public void testDel(){
        userRepository.delete(userRepository.findByName("AAA"));
    }

    /**
     * 测试findAll, 查询所有记录, 验证上面的删除是否成功
     */
    public void testDelFindAll(){
        Assert.assertEquals(9,userRepository.findAll().size());
    }
}
