package com.brandlee.leeadapter;

/**
 * @ClassName: MultiItemType
 * @Description:
 * @Author liqi1
 * @Date 17/4/19
 */

public interface MultiItemType<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T data);
}
