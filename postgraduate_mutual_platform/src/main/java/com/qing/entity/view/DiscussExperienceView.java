package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.DiscussExperienceEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


@TableName("discussexperience")
public class DiscussExperienceView extends DiscussExperienceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussExperienceView(){
	}

 	public DiscussExperienceView(DiscussExperienceEntity discussExperienceEntity){
 	try {
			BeanUtils.copyProperties(this, discussExperienceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
