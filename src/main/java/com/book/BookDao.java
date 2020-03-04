package com.book;

import java.util.List;

public interface BookDao {

    public void insert(Book book);



    public void update(Book book);


    public void delete(int[] ids);


    public List<Book> getAll();


    public List<Book> getUserForPage(int pagesize, int pageOrder);



    public Book getBookById(int id);




}
