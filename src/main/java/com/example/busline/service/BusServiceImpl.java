package com.example.busline.service;

import com.example.busline.bean.Route;
import com.example.busline.mapper.GetBusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private GetBusMapper getBusMapper;

    @Override
    public String getTableName(String busName) {
        System.out.println("BusService = "+busName);
        return getBusMapper.getBusTableName(busName);
    }

    @Override
    public List<Route> getLines(String busName) {
        String tableName = getTableName(busName);
        System.out.println("获取到的table = "+ tableName);
        return getBusMapper.getBusLines(tableName);
    }
}
