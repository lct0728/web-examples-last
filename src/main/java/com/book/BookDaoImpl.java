package com.book;


import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
    @Override
    public void insert(Book book) {
        String name=book.getName();
        String title=book.getTitle();
        int price=book.getPrice();
        int number=book.getNumber();
        String sql="insert into shopping.book(name,title,price,number) values(?,?,?,?)";
        try(Connection connection= DataSourceUtils.getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
        ){
            ps.setString(1, name);
            ps.setString(2, title);
            ps.setInt(3, price);
            ps.setInt(4, number);
            ps.executeUpdate();

        }catch(Exception e){

        }
    }

    @Override
    public void update(Book book) {
        String sql="update shopping.book set name=? ,title=?,price=?,number=? where bookno=?";
        try(Connection connection=DataSourceUtils.getConnection();
        PreparedStatement ps=connection.prepareStatement(sql)){

            ps.setString(1, book.getName());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getPrice());
            ps.setInt(4, book.getNumber());
            ps.setInt(5, book.getBookno());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int[] ids) {
       for(int i=0;i<ids.length;i++){
           delete(ids[i]);
       }
    }
    public void delete(int bookno){
        String sql="delete from shopping.book where bookno=?";
        try(Connection conn=DataSourceUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
                ps.setInt(1,bookno);
            ps.execute();
           // System.out.println("删除成功");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() {
        String sql="select * from shopping.book";
        List<Book> list=new ArrayList<>();
        try(Connection conn=DataSourceUtils.getConnection();
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql)){

            while(rs.next()){
                list.add(new Book(rs.getInt("bookno"),rs.getString("name"),rs.getString("title"),rs.getInt("price"),rs.getInt("number")));
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAll(Integer start,Integer size) {
        String sql="select * from shopping.book limit ?,?";
        List<Book> list=new ArrayList<>();
        try(Connection conn=DataSourceUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ){
            ps.setInt(1, start);
            ps.setInt(2, size);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Book(rs.getInt("bookno"),rs.getString("name"),rs.getString("title"),rs.getInt("price"),rs.getInt("number")));
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getBooksForPage(int pageNo){
        return getAll((pageNo-1)*5,5);
    }

    public Long getCount(){
        Long count=0l;
        String sql="select count(*) from shopping.book";
        try(Connection connection=DataSourceUtils.getConnection();
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();){
            while (rs.next()){
            count=rs.getLong("count(*)");
            }
        }catch (Exception e){

        }
        return  count;
    }



    //pagesize：每页的记录条数   pageOrder：页号（即第几页）
    @Override
    public List<Book> getUserForPage(int pagesize, int pageOrder) {
        String sql="select bookno,name,title,price,number from shopping.book limit ?,?";
        List<Book> list=new ArrayList<Book>();
        try(Connection conn=DataSourceUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){

            ps.setInt(1, (pageOrder-1)*pagesize);
            ps.setInt(2, pagesize);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                Book b=new Book();
                b.setBookno(rs.getInt("bookno"));
                b.setName(rs.getString("name"));
                b.setTitle(rs.getString("title"));
                b.setPrice(rs.getInt("price"));
                b.setNumber(rs.getInt("number"));
                list.add(b);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Book getBookById(int id) {
        String sql="select bookno,name,title,price,number from shopping.book where bookno=?";
        try(Connection conn=DataSourceUtils.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
        ){

            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Book(rs.getInt("bookno"),rs.getString("name"),rs.getString("title"),rs.getInt("price"),rs.getInt("number"));
            }
            // return null;
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }


}
