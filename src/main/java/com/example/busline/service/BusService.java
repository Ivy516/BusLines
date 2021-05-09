package com.example.busline.service;

import com.example.busline.bean.Route;

import java.util.List;

public interface BusService {
    String getTableName(String busName);
    List<Route> getLines(String busName);
}
