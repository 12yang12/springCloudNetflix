package com.yang.repository;

import com.yang.entity.User;

import java.util.Collection;

public interface UserRepository {
    Collection<User> findAll();

    User findById(Integer id);

    void saveOrUpdate(User student);

    void deleteById(Integer id);
}
