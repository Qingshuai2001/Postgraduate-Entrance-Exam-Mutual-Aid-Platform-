package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.CommodityEntity;
import com.qing.entity.MaterialEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
@TableName("commodity")
public class CommodityView extends CommodityEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public CommodityView(){
    }

    public CommodityView(CommodityEntity commodityEntity){
        try {
            BeanUtils.copyProperties(this, commodityEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
