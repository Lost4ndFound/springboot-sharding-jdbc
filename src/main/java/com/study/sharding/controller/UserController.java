package com.study.sharding.controller;

import com.study.sharding.entity.User;
import com.study.sharding.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lsw
 * @date: 2023/3/13 16:33
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @PostMapping("add")
    public String add(@RequestBody User user){
        int i = userMapper.addUser(user);
        return i>0?"添加成功":"添加失败";
    }

    @GetMapping("get")
    public List<User> get(){
        return userMapper.findUsers();
    }

}
