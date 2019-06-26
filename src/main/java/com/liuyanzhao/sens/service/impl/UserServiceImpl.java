package com.liuyanzhao.sens.service.impl;

import com.liuyanzhao.sens.mapper.UserMapper;
import com.liuyanzhao.sens.entity.User;
import com.liuyanzhao.sens.repository.UserRepository;
import com.liuyanzhao.sens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * 用户业务逻辑实现类
 * Spring Data JPA 版本
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void insert(User user) {
        user.setCreateTime(new Date());
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);

    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return !Objects.equals(optionalUser, Optional.empty()) ? optionalUser.get() : null;
    }


}
