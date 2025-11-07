package com.qing.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Data
@TableName("discussmaterial")
public class DiscussMaterialEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DiscussMaterialEntity() {

	}

	public DiscussMaterialEntity(T t) {
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
	 * 关联表id
	 */
					
	private Long refid;
	
	/**
	 * 评论内容
	 */
					
	private String content;
	
	/**
	 * 用户id
	 */
					
	private Long userId;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addTime;

	@TableField(exist = false)
	private String avatar;

	@TableField(exist = false)
	private String userName;

}
