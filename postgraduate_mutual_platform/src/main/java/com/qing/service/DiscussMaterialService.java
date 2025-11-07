package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.DiscussMaterialEntity;
import com.qing.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;



public interface DiscussMaterialService extends IService<DiscussMaterialEntity> {

   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussMaterialEntity> wrapper);
   	
}

