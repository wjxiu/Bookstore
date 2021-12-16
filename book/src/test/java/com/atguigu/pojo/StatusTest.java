package com.atguigu.pojo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiu
 * @create 2021-12-16 23:27
 */
public class StatusTest {

    @Test
    public void getStatus() {
        System.out.println(Status.DELIVERY.getStatus().getClass());
    }
}