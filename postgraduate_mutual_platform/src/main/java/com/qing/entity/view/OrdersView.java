package com.qing.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.qing.entity.OrdersEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


@TableName("orders")
public class OrdersView extends OrdersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrdersView(){
	}

 	public OrdersView(OrdersEntity ordersEntity){
 	try {
			BeanUtils.copyProperties(this, ordersEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
