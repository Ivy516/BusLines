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
    public List<Route> getLine(String stop) {
        System.out.println("BusService = "+stop);
        return getBusMapper.getBus(stop);
    }
}
