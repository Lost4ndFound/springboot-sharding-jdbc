package com.study.sharding.mapper;

import com.study.sharding.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: lsw
 * @date: 2023/3/13 17:28
 */
@Mapper
public interface OrderMapper {

    int add(Order order);

    /**
     * 查询订单
     */
    @Select({"<script>" +
            "select * from order p where p.order_id in " +
            "<foreach collection='orderIds' item='id' open='(' separator = ',' close=')'>#{id}</foreach>"
            + "</script>"})
    List<Map> findOrderByIds(@Param("orderIds") List<Long> orderIds);

}
