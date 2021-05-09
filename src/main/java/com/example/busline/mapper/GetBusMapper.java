package com.example.busline.mapper;

import com.example.busline.bean.Route;
import com.example.busline.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GetBusMapper {
    @Select("select tableName from bus_table where busName = #{busName}")
    String getBusTableName(String busName);
    @Select("select * from ${tableName}")
    List<Route> getBusLines(@Param("tableName") String tableName);
    @Select("select * from bus_user where userName = userName and userPass = userPass")
    User getUser(String userName, String userPass);
}
