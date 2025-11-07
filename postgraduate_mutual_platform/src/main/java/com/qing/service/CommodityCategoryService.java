package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.CategoryEntity;
import com.qing.entity.CommodityCategoryEntity;
import com.qing.entity.MaterialCategoryEntity;
import com.qing.utils.PageUtils;

import java.util.Map;


public interface CommodityCategoryService extends IService<CommodityCategoryEntity> {

   	PageUtils queryPage(Map<String, Object> params, Wrapper<CommodityCategoryEntity> wrapper);
   	
}

