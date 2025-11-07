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

/**
 * @Author QingShuai
 * @Date 2023 05 01
 **/
@Data
@TableName("commodity")
public class CommodityEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public CommodityEntity() {

    }

    public CommodityEntity(T t) {
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

    private String name;

    /**
     * 分类
     */

    private String categoryName;

    /**
     * 图片
     */

    private String picture;


    private BigDecimal price;

    private String introduction;

    private Long createdBy;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date createdTime;

    private String status;

    private String delFlag;

    private String result;


}