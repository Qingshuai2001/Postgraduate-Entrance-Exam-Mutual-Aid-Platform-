package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.OrdersEntity;
import com.qing.utils.PageUtils;

import java.util.Map;


public interface OrdersService extends IService<OrdersEntity> {


   	PageUtils queryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper);

	PageUtils queryDeliveryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper,Long userId);

	PageUtils queryFinishCommodityDeliveryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper, Long userId);

	PageUtils queryFinishMaterialDeliveryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper, Long userId);


	PageUtils queryDeliveryMaterialPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper, Long userId);
}

