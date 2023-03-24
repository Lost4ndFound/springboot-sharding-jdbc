package com.study.sharding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: lsw
 * @date: 2023/3/14 11:24
 */
@Mapper
public interface OrderInfoMapper {

    @Insert("INSERT INTO order_info(user_id,product_name,COUNT) VALUES(#{user_id},#{product_name},#{count})")
    int save(@Param("user_id") int user_id, @Param("product_name") String product_name, @Param("count") int count);

    @Select({"<script>"+
            "select * from order_info p where p.order_id in " +
            "<foreach collection='orderIds' item='id' open='(' separator = ',' close=')'>#{id}</foreach>"
            +"</script>"})
    List<Map> find(@Param("orderIds") List<Long> orderIds);

}
