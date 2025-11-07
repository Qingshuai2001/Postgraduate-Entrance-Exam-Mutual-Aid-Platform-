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
@TableName("cart")
public class CartEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CartEntity() {
		
	}
	
	public CartEntity(T t) {
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
	 * 商品表名
	 */
					
	private String tableName;
	
	/**
	 * 用户id
	 */
					
	private Long userId;
	
	/**
	 * 商品id
	 */
					
	private Long goodId;
	
	/**
	 * 商品名称
	 */
					
	private String goodName;
	
	/**
	 * 图片
	 */
					
	private String picture;
	
	/**
	 * 购买数量
	 */
					
	private Integer quantity;
	
	/**
	 * 单价
	 */
					
	private BigDecimal price;
	

					
	private String delFlag;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addTime;


}
