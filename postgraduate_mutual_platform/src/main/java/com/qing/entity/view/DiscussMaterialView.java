package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.DiscussMaterialEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;



@TableName("discussmaterial")
public class DiscussMaterialView extends DiscussMaterialEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussMaterialView(){
	}

 	public DiscussMaterialView(DiscussMaterialEntity discussMaterialEntity){
 	try {
			BeanUtils.copyProperties(this, discussMaterialEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
