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
 * 考研资讯
 * @Author QingShuai
 * @Date 2023 04 28
 **/
@Data
@TableName("information")
public class InformationEntity<T> implements Serializable {

    public InformationEntity() {

    }

    public InformationEntity(T t) {
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
     * 资讯标题
     */

    private String title;

    /**
     * 类型
     */

    private String categoryName;

    /**
     * 图片
     */

    private String picture;

    /**
     * 内容
     */

    private String content;

    /**
     * 点击次数
     */

    private Integer clickNum;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date createdTime;

    private Long createdBy;

    private Long updatedBy;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date updatedTime;


    /**
     * 发布日期
     */

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @DateTimeFormat
    private Date publishTime;


    /**
     * 最近点击时间
     */

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date clickTime;

    private String status;



//    public Date getAddtime() {
//        return addtime;
//    }
//    public void setAddtime(Date addtime) {
//        this.addtime = addtime;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//    /**
//     * 设置：资讯标题
//     */
//    public void setZixunbiaoti(String zixunbiaoti) {
//        this.zixunbiaoti = zixunbiaoti;
//    }
//    /**
//     * 获取：资讯标题
//     */
//    public String getZixunbiaoti() {
//        return zixunbiaoti;
//    }
//    /**
//     * 设置：类型
//     */
//    public void setLeixing(String leixing) {
//        this.leixing = leixing;
//    }
//    /**
//     * 获取：类型
//     */
//    public String getLeixing() {
//        return leixing;
//    }
//    /**
//     * 设置：图片
//     */
//    public void setTupian(String tupian) {
//        this.tupian = tupian;
//    }
//    /**
//     * 获取：图片
//     */
//    public String getTupian() {
//        return tupian;
//    }
//    /**
//     * 设置：内容
//     */
//    public void setNeirong(String neirong) {
//        this.neirong = neirong;
//    }
//    /**
//     * 获取：内容
//     */
//    public String getNeirong() {
//        return neirong;
//    }
//    /**
//     * 设置：发布日期
//     */
//    public void setFaburiqi(Date faburiqi) {
//        this.faburiqi = faburiqi;
//    }
//    /**
//     * 获取：发布日期
//     */
//    public Date getFaburiqi() {
//        return faburiqi;
//    }
//    /**
//     * 设置：最近点击时间
//     */
//    public void setClicktime(Date clicktime) {
//        this.clicktime = clicktime;
//    }
//    /**
//     * 获取：最近点击时间
//     */
//    public Date getClicktime() {
//        return clicktime;
//    }
//    /**
//     * 设置：点击次数
//     */
//    public void setClicknum(Integer clicknum) {
//        this.clicknum = clicknum;
//    }
//    /**
//     * 获取：点击次数
//     */
//    public Integer getClicknum() {
//        return clicknum;
//    }
}
