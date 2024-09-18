package com.federal.drisyaHome.controller;

import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.service.common.LogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    RedisDao redisDao;
    @Autowired
    LogDataService logDataService;

    @GetMapping("/getRedisData")
    public Map<Integer, DrisyaTable> getRedisData(){
        Map<Integer,DrisyaTable> data = redisDao.getRedisData();
        return data;
    }

    @GetMapping("/addDataToRedis")
    public void addDataToRedis() throws IOException{
        redisDao.addDataToRedis();
    }

}