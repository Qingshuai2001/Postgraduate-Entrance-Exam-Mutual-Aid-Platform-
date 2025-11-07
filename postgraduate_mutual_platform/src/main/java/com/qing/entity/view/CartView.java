package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.CartEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


@TableName("cart")
public class CartView extends CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CartView(){
	}
 
 	public CartView(CartEntity cartEntity){
 	try {
			BeanUtils.copyProperties(this, cartEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
