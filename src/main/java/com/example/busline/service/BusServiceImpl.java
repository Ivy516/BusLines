package com.example.busline.service;

import com.example.busline.bean.Route;
import com.example.busline.mapper.GetBusMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService{

    @Autowired
    private GetBusMapper getBusMapper;

    @Override
    public String getTableName(String busName) {
        System.out.println("busName = "+busName);
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
        if (name.equals("name")) {
            getBusMapper.modifyBusName(value, busName);
        }
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

    @Override
    public boolean addBusData(String busName, String startTime, String endTime, float price, float distance) {
        String bus = getBusMapper.getBus(busName);
        System.out.println("bus = " + bus);
        if (bus == null) {
            String tableName = creatBusTable(busName);
            getBusMapper.insertBusData(startTime,endTime,price,distance,busName,tableName);
            getBusMapper.addBusTable(busName, tableName);
            return true;
        }
        return false;
    }

    public String creatBusTable(String busName) {
        char[] chs = busName.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("r");
        for (int i = 0; i < chs.length; i++) {
            if (chs[i]>='0' && chs[i]<='9') {
                stringBuilder.append(chs[i]);
            }
        }
        String tableName = stringBuilder.toString();
        System.out.println("tableName = " + tableName);
        getBusMapper.creatTable(tableName);
        return tableName;
    }

    @Override
    public void addBusLine(String busName, List<Route> lines) {
        String tableName = getBusMapper.getBusTableName(busName);
        for (Route line: lines) {
            getBusMapper.insertLine(tableName,line.getPosition(), line.getStop(),
                    line.getIsArrived(), line.getLatitude(), line.getLongitude());
        }
    }
}
