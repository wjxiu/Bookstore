package com.atguigu.pojo;
/**
 * @author xiu
 * @create 2021-12-15 23:44
 */
public enum Status {
//    未发货
    UNSHIPPED (0),
//    运输中
    DELIVERY(1),
//    已收获
    RECEIVE(2);
    private final Integer STATUS;
    Status(Integer status) {
        STATUS = status;
    }
//    获取状态的数值
    public Integer getStatus(){
        return STATUS;
    }

}
