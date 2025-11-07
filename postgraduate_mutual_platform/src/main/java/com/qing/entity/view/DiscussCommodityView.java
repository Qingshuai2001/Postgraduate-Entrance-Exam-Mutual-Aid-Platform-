package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.DiscussCommodityEntity;
import com.qing.entity.DiscussMaterialEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


@TableName("discusscommodity")
public class DiscussCommodityView extends DiscussCommodityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussCommodityView(){
	}

 	public DiscussCommodityView(DiscussCommodityEntity discussCommodityEntity){
 	try {
			BeanUtils.copyProperties(this, discussCommodityEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
