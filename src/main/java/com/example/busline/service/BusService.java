package com.example.busline.service;

import com.example.busline.bean.Route;

import java.util.List;

public interface BusService {
    String getTableName(String busName);
    List<Route> getLines(String busName);
    void deleteLine(String name);
    void modifyBusData(String busName, String name, String value);
    void modifyBusData(String busName, String name, float value);
    void modifyBusLine(String busName, int position, String name);
}
