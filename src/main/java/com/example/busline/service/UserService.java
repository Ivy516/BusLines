package com.example.busline.service;

import com.example.busline.bean.User;

public interface UserService {
    User getUser(String userName, String userPass);
}
