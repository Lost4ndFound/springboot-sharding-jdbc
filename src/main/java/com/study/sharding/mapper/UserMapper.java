package com.study.sharding.mapper;

import com.study.sharding.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: lsw
 * @date: 2023/3/13 16:28
 */
@Mapper
public interface UserMapper {

    int addUser(User user);

    List<User> findUsers();

}
