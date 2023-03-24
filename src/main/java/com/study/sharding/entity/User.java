package com.study.sharding.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: lsw
 * @date: 2023/3/13 16:27
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String nickname;

    private String password;

    private Integer sex;

    private String birthday;

}
