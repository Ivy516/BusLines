package com.example.busline.mapper;

import com.example.busline.bean.Route;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetBusMapper {
    @Select("select * from stop_routes where stop = stop")
    List<Route> getBus(String stop);
}
