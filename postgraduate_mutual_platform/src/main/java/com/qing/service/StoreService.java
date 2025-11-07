package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import com.qing.entity.StoreEntity;
import com.qing.entity.view.StoreView;
import com.qing.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 收藏表
 */
public interface StoreService extends IService<StoreEntity> {

   	List<StoreView> selectListView(Wrapper<StoreEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params, Wrapper<StoreEntity> wrapper);
   	
}

