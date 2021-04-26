package com.example.busline.controller;

import com.example.busline.apiResult.ApiResult;
import com.example.busline.bean.Route;
import com.example.busline.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusService busService;
    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "/getBusLines" , method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getBusLines(@RequestParam("stop") String stop) throws SQLException {

        try {
            System.out.println("数据库连接成功："+ dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(stop);

        List<Route> route = busService.getLine(stop);
        for (int i = 0; i < route.size(); i++) {
            System.out.println("get到："+ route.get(i).getStop()
            + ","+route.get(i).getPosition()
            + ","+route.get(i).getRoute());
        }
        System.out.println(route.size());
        ApiResult apiResult = new ApiResult();
        if (route != null) {
            apiResult.setCode(200);
            apiResult.setStatus("Success");
            apiResult.setData(route);
            return apiResult;
        }

        return null;
    }
}
