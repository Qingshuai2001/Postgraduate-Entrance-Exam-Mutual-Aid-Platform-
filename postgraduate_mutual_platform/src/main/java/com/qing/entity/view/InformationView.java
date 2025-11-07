package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.InformationEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author QingShuai
 * @Date 2023 04 28
 **/
@TableName("information")
public class InformationView  extends InformationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public InformationView(){
    }

    public InformationView(InformationEntity informationEntity){
        try {
            BeanUtils.copyProperties(this, informationEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
