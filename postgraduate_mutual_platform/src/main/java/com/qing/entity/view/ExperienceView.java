package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.ExperienceEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author QingShuai
 * @Date 2023 05 01
 **/
@TableName("experience")
public class ExperienceView extends ExperienceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ExperienceView(){
    }

    public ExperienceView(ExperienceEntity experienceEntity){
        try {
            BeanUtils.copyProperties(this, experienceEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
