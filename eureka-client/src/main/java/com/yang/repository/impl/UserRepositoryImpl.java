package com.yang.repository.impl;

import com.yang.entity.User;
import com.yang.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static Map<Integer, User> userMap;

    static {
        userMap = new HashMap<>(8);
        userMap.put(1, new User(1, "张三"));
        userMap.put(2, new User(2, "李四"));
        userMap.put(3, new User(3, "王五"));
        userMap.put(4, new User(4, "赵六"));
    }

    @Override
    public Collection<User> findAll() {
        return userMap.values();
    }

    @Override
    public User findById(Integer id) {
        return userMap.get(id);
    }

    @Override
    public void saveOrUpdate(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public void deleteById(Integer id) {
        userMap.remove(id);
    }
}
