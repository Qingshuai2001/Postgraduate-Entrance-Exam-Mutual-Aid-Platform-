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
 * @Author QingShuai
 * @Date 2023 04 30
 **/
@Data
@TableName("experience")
public class ExperienceEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ExperienceEntity() {

    }

    public ExperienceEntity(T t) {
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
     * 标题
     */

    private String title;

    private String categoryName;

    /**
     * 图片
     */

    private String picture;


    private String content;

    private Integer storeNum;

    private Integer clickNum;

    private Long createdBy;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date createdTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @DateTimeFormat
    private Date publishTime;


    private String status;

    private String delFlag;

    private String result;

}
