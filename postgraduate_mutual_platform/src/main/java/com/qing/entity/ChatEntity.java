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


@Data
@TableName("chat")
public class ChatEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChatEntity() {
		
	}
	
	public ChatEntity(T t) {
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
	 * 管理员id
	 */
					
	private Long adminId;
	
	/**
	 * 提问
	 */
					
	private String ask;
	
	/**
	 * 回复
	 */
					
	private String reply;
	
	/**
	 * 是否回复
	 */
					
	private Integer isReply;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addTime;


}
