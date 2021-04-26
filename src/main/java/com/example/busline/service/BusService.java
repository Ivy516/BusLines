package com.example.busline.service;

import com.example.busline.bean.Route;

import java.util.List;

public interface BusService {
    List<Route> getLine(String stop);
}
