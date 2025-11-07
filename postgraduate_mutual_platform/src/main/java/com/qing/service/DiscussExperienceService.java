package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.DiscussExperienceEntity;
import com.qing.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;



public interface DiscussExperienceService extends IService<DiscussExperienceEntity> {


   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussExperienceEntity> wrapper);
   	
}

