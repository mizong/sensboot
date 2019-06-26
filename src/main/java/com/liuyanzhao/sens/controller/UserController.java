package com.liuyanzhao.sens.controller;

import com.liuyanzhao.sens.entity.User;
import com.liuyanzhao.sens.service.UserService;
import com.liuyanzhao.sens.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * 后台用户管理控制器
 * Spring Data JPA 版本
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页获得用户列表
     *
     * @param page  页码
     * @param size  页大小
     * @param model model
     * @return JSON格式数据
     */
    @GetMapping
    public Response<Page<User>> paging(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size, Model model) {
        //用户列表
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userService.findAll(pageable);
        return Response.yes(users);
    }

    /**
     * 添加用户
     *
     * @param user 用户
     * @return JSON格式数据
     */
    @PostMapping
    public Response add(@RequestBody User user) {
        try {
            userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }
        return Response.yes();
    }

    /**
     * 删除用户
     *
     * @param user 用户
     * @return JSON格式数据
     */
    @PutMapping
    public Response update(@RequestBody User user) {
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }
        return Response.yes();
    }

    /**
     * 删除用户
     *
     * @param id ID
     * @return JSON格式数据
     */
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }
        return Response.yes();
    }

    /**
     * 根据ID查询用户
     *
     * @param id ID
     * @return JSON格式数据
     */
    @GetMapping("/{id}")
    public Response get(@PathVariable("id") Long id) {
        User user = null;
        try {
            user = userService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }
        return Response.yes(user);
    }





}
