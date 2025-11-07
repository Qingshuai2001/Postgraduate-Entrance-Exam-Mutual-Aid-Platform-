package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.DiscussCommodityEntity;

import com.qing.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;



public interface DiscussCommodityService extends IService<DiscussCommodityEntity> {


   	PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussCommodityEntity> wrapper);
   	
}

