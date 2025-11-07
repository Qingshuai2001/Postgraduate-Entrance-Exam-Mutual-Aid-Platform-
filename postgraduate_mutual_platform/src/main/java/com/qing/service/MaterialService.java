package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.MaterialEntity;
import com.qing.utils.PageUtils;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
public interface MaterialService extends IService<MaterialEntity> {
    PageUtils queryPage(Map<String, Object> params, Wrapper<MaterialEntity> wrapper);
}
