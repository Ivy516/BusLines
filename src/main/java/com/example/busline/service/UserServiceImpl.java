package com.example.busline.service;

import com.example.busline.bean.User;
import com.example.busline.mapper.GetBusMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private GetBusMapper mapper;
    @Override
    public User getUser(String userName, String userPass) {
        return mapper.getUser(userName,userPass);
    }
}
