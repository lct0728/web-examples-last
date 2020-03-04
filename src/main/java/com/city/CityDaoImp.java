package com.city;

import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImp {
    public List<City> getCityByPid(int pid){
        List<City> list=new ArrayList<>();
        String sql="select * from shopping.city where pid=?";
        try (Connection connection= DataSourceUtils.getConnection();
             PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1, pid);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                list.add(new City(rs.getInt("id"), rs.getString("name")));
            }
        }catch (Exception e){

        }
        return list;
    }
}
