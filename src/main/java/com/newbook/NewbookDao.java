package com.newbook;

import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewbookDao {
    public List<Newbook> getNewBook(){
        String sql="select * from shopping.newbook";
        List<Newbook> list=new ArrayList<>();
        try (Connection connection= DataSourceUtils.getConnection();
             PreparedStatement ps=connection.prepareStatement(sql)){

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                list.add(new Newbook(rs.getInt("id"), rs.getString("name"), rs.getString("kind")));
            }
        }catch (Exception e){

        }
        return list;
    }
}
