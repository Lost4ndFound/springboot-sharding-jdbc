package com.study.sharding.controller;

import com.study.sharding.entity.Order;
import com.study.sharding.mapper.OrderMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: lsw
 * @date: 2023/3/13 17:28
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    @PostMapping("save")
    public String save(){
        for (int i = 0; i < 20; i++) {
            Order order = new Order();
            order.setUserId(100+i);
            order.setCount(10);
            order.setProductName("空调"+i);
            orderMapper.add(order);
        }
        return "success";
    }

    @GetMapping("find")
    public List<Map> testFindOrderByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(842340934405324801L);
        ids.add(842340934250135552L);

        List<Map> list = orderMapper.findOrderByIds(ids);
        return list;
    }

}
