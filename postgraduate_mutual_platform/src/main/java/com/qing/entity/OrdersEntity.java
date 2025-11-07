package com.qing.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;


@Data
@TableName("orders")
public class OrdersEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public OrdersEntity() {

	}

	public OrdersEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 订单编号
	 */
					
	private String orderId;
	
	/**
	 * 商品表名
	 */
					
	private String tableName;
	
	/**
	 * 用户id
	 */
	private Long userId;

	private String userName;

	private String phone;
	/**
	 * 商品id
	 */
					
	private Long goodId;
	
	/**
	 * 商品名称
	 */
					
	private String goodName;
	
	/**
	 * 商品图片
	 */
					
	private String picture;
	
	/**
	 * 购买数量
	 */
					
	private Integer quantity;
	
	/**
	 * 价格/积分
	 */
					
	private BigDecimal totalPrice;

	private BigDecimal price;
	
	/**
	 * 状态
	 */
					
	private String status;
	
	/**
	 * 地址
	 */
					
	private String detailAddress;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date createdTime;

	private String delFlag;

	private String link;


}
