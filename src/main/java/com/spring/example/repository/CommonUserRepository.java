package com.spring.example.repository;

import com.spring.example.model.CommonUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by haoxy on 2018/10/15.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public interface CommonUserRepository extends CrudRepository<CommonUser,Long>, PagingAndSortingRepository<CommonUser,Long> {

    List<CommonUser> getByUsernameLike(String username);

    List<CommonUser> findByEmailEquals(String email);

    List<CommonUser> findByUsernameIgnoreCase(String username);

    List<CommonUser> findCommonUsersByOrderByIdAsc();

    List<CommonUser> findCommonUsersByOrderByIdDesc();

    List<CommonUser> findTop5ByUsernameLike(String lastname, Pageable pageable);

}
