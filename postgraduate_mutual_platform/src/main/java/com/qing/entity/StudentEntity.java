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
 * @Date 2023 05 02
 **/
@Data
@TableName("student")
public class StudentEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public StudentEntity() {

    }

    public StudentEntity(T t) {
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


    private String userName;

    private String account;

    /**
     * 密码
     */

    private String password;


    private String avatar;

    /**
     * 性别
     */

    private String gender;


    /**
     * 专业
     */

    private String major;


    private String email;

    /**
     * 手机
     */

    private String phone;

    /**
     * 余额
     */

    private BigDecimal money;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date createdTime;

    private Long adminId;

    private String status;

    private String delFlag;


}
