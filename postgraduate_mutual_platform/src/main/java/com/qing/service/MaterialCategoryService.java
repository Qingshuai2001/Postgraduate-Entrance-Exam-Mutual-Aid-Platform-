package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.CategoryEntity;
import com.qing.entity.InformationCategoryEntity;
import com.qing.entity.MaterialCategoryEntity;
import com.qing.utils.PageUtils;

import java.util.Map;


public interface MaterialCategoryService extends IService<MaterialCategoryEntity> {

   	PageUtils queryPage(Map<String, Object> params, Wrapper<MaterialCategoryEntity> wrapper);
   	
}

