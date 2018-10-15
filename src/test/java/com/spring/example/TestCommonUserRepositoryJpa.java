package com.spring.example;

import com.spring.example.Repository.CommonUserRepository;
import com.spring.example.model.CommonUser;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by haoxy on 2018/10/15.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JpaApp.class})
public class TestCommonUserRepositoryJpa {

    @Autowired
    private CommonUserRepository commonUserRepository;

    /**
     * 测试添加数据
     */
    @Test
    public void testSave() {
        for (int i = 0; i < 20; i++) {
            commonUserRepository.save(new CommonUser("user" + i, "用户" + i, "user" + i + "@" + "163.com", LocalDate.now(), LocalDateTime.now()));
        }
    }

    /**
     * 测试删除所有数据
     */
    @Test
    public void testDelAll() {
        commonUserRepository.deleteAll();
    }
    /**
     * 测试模糊查询
     */
    @Test
    public void testLike(){
        List<CommonUser> byUsernameIsLike = commonUserRepository.getByUsernameLike("%2");
        for (CommonUser commonUser : byUsernameIsLike) {
            System.out.println(commonUser);
        }
    }

    /**
     * PagingAndSortingRepository接口则提供了分页和排序功能
     * 测试分页
     * Pageable是一个接口，如果我们需要创建Pageable对象，使用PageRequest类并指定获取的页数和每页的数据量。页是从0开始计数的
     */
    @Test
    public void testPagingRepository(){
        int countPerPage = 5;
        long totalCount = commonUserRepository.count();//总条数
        int totalPage = (int) (totalCount % 5 == 0L ? totalCount / 5 : totalCount / 5 + 1);//总页数
            Page<CommonUser> commonUsers = commonUserRepository.findAll(new PageRequest(0, countPerPage));// page,size
        for (CommonUser commonUser : commonUsers) {
            System.out.println(commonUser);
        }
    }
    @Test
    public void testFindByEmail(){
        List<CommonUser> commonUsers=commonUserRepository.findByEmailEquals("user19@163.com");
        System.out.println(commonUsers);
    }
    /**
     * 对某一属性不区分大小写
     */
    @Test
    public void testIgnoreCase(){
        List<CommonUser> user4 = commonUserRepository.findByUsernameIgnoreCase("USER4");
        System.out.println(user4);
    }
    /**
     * 以ID进行升序
     */
    @Test
    public void testOrderByIdAsc(){
        List<CommonUser> commonUsersByOrderByIdAsc = commonUserRepository.findCommonUsersByOrderByIdAsc();
        System.out.println(commonUsersByOrderByIdAsc);
    }
    /**
     * 以ID进行降序
     */
    @Test
    public void testOrderByIdDesc(){
        List<CommonUser> commonUsersByOrderByIdDesc = commonUserRepository.findCommonUsersByOrderByIdDesc();
        System.out.println(commonUsersByOrderByIdDesc);
    }
    @Test
    public void testTop(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable=new PageRequest(1,5 ,sort);
        List<CommonUser> user4 = commonUserRepository.findTop5ByUsernameLike("user%", pageable);
        System.out.println(user4);
    }

}
