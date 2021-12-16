package com.atguigu.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-11-27 13:30
 */
public class CartTest {
    Cart cart=new Cart();
    @Test
    public void addItem() {
        CartItems cartItems = new CartItems(1, "aa", 12, 12.0);
        cart.addItem(cartItems);
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        System.out.println(new BigDecimal(3 * 9.9));
    }

    @Test
    public void clear() {
        CartItems cartItems = new CartItems(1, "aa", 12, 12.0);
        CartItems cartItems1 = new CartItems(2, "aa", 12, 12.0);

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        CartItems cartItems = new CartItems(1, "aa", 12, 12.0);
        CartItems cartItems1 = new CartItems(2, "aa", 12, 12.0);
        cart.updateCount(1, 14);
        System.out.println(cart);
    }

    @Test
    public void testToString() {
    }
}