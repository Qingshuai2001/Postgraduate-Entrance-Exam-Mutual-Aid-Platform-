package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.CartEntity;
import com.qing.entity.view.CartView;
import com.qing.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;



public interface CartService extends IService<CartEntity> {

	PageUtils queryPage(Map<String, Object> params, Wrapper<CartEntity> wrapper);



}

