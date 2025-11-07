package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.ForumEntity;
import com.qing.utils.PageUtils;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 29
 **/
public interface ForumService extends IService<ForumEntity> {

    PageUtils queryPage(Map<String, Object> params, Wrapper<ForumEntity> wrapper);
}
