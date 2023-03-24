package com.study.sharding.controller;

import com.study.sharding.mapper.OrderInfoMapper;
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
 * @date: 2023/3/14 11:23
 */
@RestController
@RequestMapping("orderInfo")
public class OrderInfoController {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @PostMapping("/save")
    public String save() {
        for (int i = 0; i < 10; i++) {
            orderInfoMapper.save(i, "空调" + i, 1);
        }
        return "success";
    }

    @GetMapping("find")
    public List<Map> find() {
        List<Long> ids = new ArrayList<>();
        ids.add(842395200243367936L);
        ids.add(842395198800527361L);

        List<Map> list = orderInfoMapper.find(ids);
        return list;
    }

}
