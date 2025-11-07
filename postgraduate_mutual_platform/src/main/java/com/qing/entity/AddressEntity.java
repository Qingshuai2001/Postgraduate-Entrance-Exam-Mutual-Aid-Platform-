package com.qing.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 地址
 * 数据库通用操作实体类（普通增删改查）
 */
@Data
@TableName("address")
public class AddressEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public AddressEntity() {
		
	}
	
	public AddressEntity(T t) {
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
	 * 用户id
	 */
					
	private Long userId;
	
	/**
	 * 地址
	 */
					
	private String detailAddress;
	
	/**
	 * 收货人
	 */
					
	private String userName;
	
	/**
	 * 电话
	 */
					
	private String phone;
	
	/**
	 * 是否默认地址[是/否]
	 */
					
	private String isDefault;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date createdTime;

	private String delFlag;


}
