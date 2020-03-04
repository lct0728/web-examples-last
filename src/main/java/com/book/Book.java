package com.book;

public class Book {
    int bookno;
    String name;
    String title;
    int price;
    int number;

    public int getBookno() {
        return bookno;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBookno(int bookno) {
        this.bookno = bookno;
    }

    public Book(String name, String title, int price, int number) {
        this.name = name;
        this.title = title;
        this.price = price;
        this.number = number;
    }

    public Book(int bookno, String name, String title, int price, int number) {
        this.bookno = bookno;
        this.name = name;
        this.title = title;
        this.price = price;
        this.number = number;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "bookno:"+bookno+" name:"+name+" title:"+title+" price:"+price+" number:"+number;
    }
}
