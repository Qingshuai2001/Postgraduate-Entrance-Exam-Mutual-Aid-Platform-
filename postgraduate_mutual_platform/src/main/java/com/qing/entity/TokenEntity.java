package com.qing.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
@Data
@NoArgsConstructor
@TableName("token")
public class TokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public TokenEntity(Long userId, String account, String tableName,String role, String token, Date expiredTime) {
        super();
        this.userId = userId;
        this.account = account;
        this.tableName = tableName;
        this.role = role;
        this.token = token;
        this.expiredTime = expiredTime;
    }

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 账号
     */
    private String account;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 角色
     */
    private String role;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Date expiredTime;

    /**
     * 新增时间
     */
    private Date createdTime;



}

