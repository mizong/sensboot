package com.liuyanzhao.sens.service;

import com.liuyanzhao.sens.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 业务逻辑接口
 * Spring Data JPA 版本
 */
public interface UserService {


    /**
     * 新增
     *
     * @param user
     */
    void insert(User user);

    /**
     * 根据ID更新
     *
     * @param user
     */
    void update(User user);

    /**
     * 根据ID删除
     *
     * @param userId Id
     */
    void deleteById(Long userId);

    /**
     * 分页查询
     *
     * @param pageable 分页信息
     * @return 列表
     */
    Page<User> findAll(Pageable pageable);

    /**
     * 根据Id查询
     *
     * @param userId
     * @return
     */
    User findById(Long userId);


}
