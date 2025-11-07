package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.MaterialEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
@TableName("material")
public class MaterialView extends MaterialEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public MaterialView(){
    }

    public MaterialView(MaterialEntity materialEntity){
        try {
            BeanUtils.copyProperties(this, materialEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
