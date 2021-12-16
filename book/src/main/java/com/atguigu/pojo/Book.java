package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 * @author xiu
 * @create 2021-10-28 21:42
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
    private BigDecimal price;
//    销量
    private Integer saleds;
//    库存
    private Integer stock;
    private String img_path="static/img/default.img";

    public Book() {
    }

    public Book(Integer id, String name, String author, BigDecimal price, Integer saleds, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.saleds = saleds;
        this.stock = stock;
//        对图书封面进行判断
        if (img_path!=null&&!"".equals(img_path)){
            this.img_path = img_path;
        }
    }

    public Book( String name, String author, BigDecimal price, Integer saleds, Integer stock, String img_path) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.saleds = saleds;
        this.stock = stock;
//        对图书封面进行判断
        if (img_path!=null&&!"".equals(img_path)){
            this.img_path = img_path;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSaleds() {
        return saleds;
    }

    public void setSaleds(Integer saleds) {
        this.saleds = saleds;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        //        对图书封面进行判断
        if (img_path!=null&&!"".equals(img_path)){
            this.img_path = img_path;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", saleds=" + saleds +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
