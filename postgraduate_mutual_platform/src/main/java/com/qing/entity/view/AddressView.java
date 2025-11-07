package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.AddressEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 地址
 */
@TableName("address")
public class AddressView extends AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AddressView(){
	}
 
 	public AddressView(AddressEntity addressEntity){
 	try {
			BeanUtils.copyProperties(this, addressEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
