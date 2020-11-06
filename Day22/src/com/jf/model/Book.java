package com.jf.model;

/**
 * 书籍实体
 */
public class Book {
    private String id;
    private String name;
    private String autho;
    private int price;

    public Book(String id, String name, String autho, int price) {
        this.id = id;
        this.name = name;
        this.autho = autho;
        this.price = price;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutho() {
        return autho;
    }

    public void setAutho(String autho) {
        this.autho = autho;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", autho='" + autho + '\'' +
                ", price=" + price +
                '}';
    }
}
