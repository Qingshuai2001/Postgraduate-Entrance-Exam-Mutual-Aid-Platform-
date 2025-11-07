package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.StoreEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 收藏表
 * 后端返回视图实体辅助类
 */
@TableName("store")
public class StoreView extends StoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public StoreView(){
	}

 	public StoreView(StoreEntity storeEntity){
 	try {
			BeanUtils.copyProperties(this, storeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
