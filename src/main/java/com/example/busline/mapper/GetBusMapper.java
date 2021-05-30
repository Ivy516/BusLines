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

    @Select("select * from bus_user where userName = #{userName} and userPass = #{userPass}")
    User getUser(String userName, String userPass);

    @Select("drop table ${tableName}")
    void deleteLine(String tableName);

    @Select("update bus_table set busName=#{newBusName} where busName=#{oldBusName}")
    void modifyBusName(String newBusName,String oldBusName);

    @Select("update bus set ${name}=#{value} where route=#{tableName}")
    void modifyBusData(String tableName, String name, String value);
    void modifyBusData(String tableName, String name, float value);

    @Select("update ${busName} set stop=#{stopName} where position=#{position}")
    void modifyBusLine(String busName, int position, String stopName);

    @Select("select busName from bus_table where busName=#{busName}")
    String getBus(String busName);

    @Select("CREATE TABLE r123 (position INT," +
            "stop VARCHAR(50)," +
            "isArrived INT ," +
            "latitude DOUBLE , " +
            "longitude DOUBLE," +
            "PRIMARY KEY(position))")
    void creatTable(String tableName);

    @Select("insert into bus_table (busName,tableName) values (#{busName},#{busTable})")
    void addBusTable(String busName,String busTable);

    @Select("insert into bus (start_time,end_time,price,distance,name," +
            "route) values (#{startTime},#{endTime},#{price}," +
            "#{distance},#{name},#{route})")
    void insertBusData(String startTime,String endTime, float price, float distance,
                       String name, String route);

    @Select("insert into ${tableName} (position,stop,isArrived, latitude,longitude)" +
            "values (#{position},#{stop},#{isArrived},#{latitude},#{longitude})")
    void insertLine(String tableName, int position, String stop,int isArrived,
                    double latitude,double longitude);
}
