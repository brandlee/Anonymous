package com.brandlee.anonymous.entities;

/**
 * @Description:
 * @Author: liqi
 * @Date: 2018/05/27 1501
 */
public class ShopEntity extends BaseEntity {

    public int type = TYPE_AVALIABLE_AFTER_CERTIFICATED;

    public ShopEntity(int type) {
        this.type = type;
    }

    public static final int TYPE_AVALIABLE_AFTER_CERTIFICATED = 0;
    public static final int TYPE_EDIT = 1;
    public static final int TYPE_VERIFY_ING = 2;
    public static final int TYPE_VERIFY_FAILED = 3;
    public static final int TYPE_EMPTY = 4;
}
