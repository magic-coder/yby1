package com.itislevel.lyl.mvp.model.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * desc:功能说明必写
 * user:itisi
 * date:2017/12/15.17:35
 * path:com.itislevel.lyl.mvp.model.bean.Level1Item
 **/
public class Level1Item extends AbstractExpandableItem<Level2Item> implements MultiItemEntity {
    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public int getItemType() {
        return 1;
    }
}
