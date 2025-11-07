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
 * 收藏表
 * 数据库通用操作实体类（普通增删改查）
 */
@Data
@TableName("store")
public class StoreEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public StoreEntity() {

	}

	public StoreEntity(T t) {
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
					
	private Long createdBy;
	
	/**
	 * 收藏id
	 */
					
	private Long refid;
	
	/**
	 * 表名
	 */
					
	private String tableName;
	
	/**
	 * 收藏名称
	 */
					
	private String title;
	
	/**
	 * 收藏图片
	 */
					
	private String picture;

	private String delFlag;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date createdTime;


}
