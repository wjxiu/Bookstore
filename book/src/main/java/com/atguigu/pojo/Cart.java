package com.atguigu.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xiu
 * @create 2021-11-20 11:30
 */
public class Cart {
    //    总商品数量
    private Integer totalCount=0;
    //    总商品金额
    private Double totalPrice=0.0;
    //    购物车商品
//    这里的集合可以换成hashmap，这样会更快
    private List<CartItems> items = new ArrayList<>();

    public Cart() {
    }

    public Cart(Integer totalCount, Double totalPrice, List<CartItems> items) {
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public void addItem(CartItems c) {
        CartItems cartemsById = getCartemsById(c.getId());
        if (cartemsById==null){
            items.add(c);
        }else{
            cartemsById.setCount(cartemsById.getCount()+1);
        }
        updateCartTotalCountAndTotalPrice();
    }

    /**
     * 根据id删除商品
     * @param id
     */
    public void deleteItem(Integer id) {
        CartItems cartemsById = getCartemsById(id);
//        如果商品数量大于1就修改数量，否则就直接去掉
        if (cartemsById.getCount()>1){
            cartemsById.setCount(cartemsById.getCount()-1);
        }else{
            items.remove(cartemsById);
        }
        updateCartTotalCountAndTotalPrice();
    }

    /**
     * 清空购物车的内容
     */
    public void clear() {
        items.clear();
        totalCount=0;
        totalPrice=0.0;
    }

    /**
     * 更新操作
     *
     * @param id    书的id
     * @param count 更新后的数目
     */
    public void updateCount(Integer id, Integer count) {
        CartItems cartemsById = getCartemsById(id);
        cartemsById.setCount(count);
        updateCartTotalCountAndTotalPrice();
    }

    /**
     * 通过id查找商品
     * @param id 查找的id值
     * @return 存在返回该商品，不存在返回null
     */
    public CartItems getCartemsById(Integer id) {
        CartItems cartItem=null;
        for (int i = 0; i < items.size(); i++) {
            CartItems cartItems = items.get(i);
            if (id.equals(cartItems.getId())){
                return cartItems;
            }
        }
        return cartItem;
    }

    /**
     * 更新购物车的数目和每一个商品的总价
     */
    public void updateCartTotalCountAndTotalPrice(){
        int count=0;
        double price=0;
        if (items.size()>0){
        for (int i = 0; i < items.size(); i++) {
            CartItems next = items.get(i);
            price+= next.getPrice()*next.getCount();
            count+=next.getCount();
            next.setTotalPrice(next.getCount()*next.getPrice());
        }
        }
        totalPrice=price;
        totalCount=count;
    }


    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItems> getItems() {
        return items;
    }

    public void setItems(List<CartItems> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
