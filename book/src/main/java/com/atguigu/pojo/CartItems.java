package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author xiu
 * @create 2021-11-20 11:31
 */
public class CartItems {
    //    商品id
    private Integer id;
    //    商品名称
    private String name;
    //    商品数目
    private Integer count;
    //    商品价格
    private Double price;
    //    商品总价
    private Double totalPrice;
    public CartItems() {
    }

    public CartItems(Integer id, String name, Integer count, Double price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = count*price;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
