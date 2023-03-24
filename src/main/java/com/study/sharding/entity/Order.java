package com.study.sharding.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: lsw
 * @date: 2023/3/14 9:38
 */
@Data
public class Order implements Serializable {

    private Long orderId;

    private Integer userId;

    private String productName;

    private Integer count;

}
