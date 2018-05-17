package com.brandlee.anonymous.entities;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/17 1204
 */
public class OrderEntity extends BaseEntity {
    public static final int TYPE_WAIT_CONFIRM = 0;
    public static final int TYPE_WAIT_PAY = 1;
    public static final int TYPE_COMPLETE = 2;
    public static final int TYPE_ALL = 3;

    public int orderType;

    public OrderEntity(int orderType) {
        this.orderType = orderType;
    }
}
