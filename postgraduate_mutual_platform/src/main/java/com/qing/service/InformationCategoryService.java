package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.CategoryEntity;
import com.qing.entity.InformationCategoryEntity;
import com.qing.utils.PageUtils;

import java.util.Map;


public interface InformationCategoryService extends IService<InformationCategoryEntity> {

   	PageUtils queryPage(Map<String, Object> params, Wrapper<InformationCategoryEntity> wrapper);
   	
}

