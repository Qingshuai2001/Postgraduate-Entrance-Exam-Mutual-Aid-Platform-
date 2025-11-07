package com.qing.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;


/**
 * 论坛表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("forum")
public class ForumEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public ForumEntity(T t) {
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
	 * 用户名
	 */

	private String userName;
	/**
	 * 帖子标题
	 */
					
	private String title;
	
	/**
	 * 帖子内容
	 */
					
	private String content;
	
	/**
	 * 父节点id
	 */
					
	private Long parentId;


	private String status;

	private String type;

	/**
	 * 用户id
	 */
					
	private Long createdBy;

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date createdTime;
	
	/**
	 * 状态
	 */
	private String isDone;
	
	private String del_flag;


	@TableField(exist = false)
	private List<ForumEntity> childs;

	@TableField(exist = false)
	private String avatar;


}
