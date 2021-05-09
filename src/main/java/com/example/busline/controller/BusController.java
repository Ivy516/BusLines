package com.example.busline.controller;

import com.example.busline.apiResult.ApiResult;
import com.example.busline.bean.Route;
import com.example.busline.bean.User;
import com.example.busline.service.BusService;
import com.example.busline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "/getBusLines" , method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getBusLines(@RequestParam("busName") String busName) throws SQLException {
        List<Route> lines = new ArrayList<>();
        try {
            System.out.println("数据库连接成功："+ dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Route> route = busService.getLines(busName);

        for (int i = 0; i < route.size(); i++) {
            if (!route.get(i).getStop().equals("")) {
                lines.add(route.get(i));
            }
        }
        ApiResult apiResult = new ApiResult();
        if (route != null) {
            apiResult.setCode(200);
            apiResult.setStatus("Success");
            apiResult.setData(lines);
            return apiResult;
        }

        return null;
    }

    @Autowired
    private UserService userService;
    //用户连接
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult login(@RequestParam("userName") String userName,
                           @RequestParam("userPass") String userPass) {
        User user = userService.getUser(userName,userPass);
        ApiResult result = new ApiResult();
        if (user != null) {
            result.setStatus("success");
            result.setMessage("登录成功");
        } else {
            result.setStatus("failed");
            result.setMessage("登录失败");
        }
        return result;
    }


}
