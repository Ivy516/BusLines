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

    @Override
    public void deleteLine(String name) {
        String tableName = getBusMapper.getBusTableName(name);
        getBusMapper.deleteLine(tableName);
    }

    @Override
    public void modifyBusData(String busName, String name, String value) {
        String tableName = getTableName(busName);
        getBusMapper.modifyBusData(tableName, name, value);
    }

    @Override
    public void modifyBusData(String busName, String name, float value) {
        String tableName = getTableName(busName);
        getBusMapper.modifyBusData(tableName, name, value);
    }

    @Override
    public void modifyBusLine(String busName, int position, String stopName) {
        String tableName = getTableName(busName);
        getBusMapper.modifyBusLine(tableName, position, stopName);
    }
}
