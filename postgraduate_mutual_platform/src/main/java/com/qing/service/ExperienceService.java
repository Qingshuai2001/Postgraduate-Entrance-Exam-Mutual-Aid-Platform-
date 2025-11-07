package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.common.ResponseResult;
import com.qing.entity.ExperienceEntity;
import com.qing.utils.PageUtils;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
public interface ExperienceService extends IService<ExperienceEntity> {
    PageUtils queryPage(Map<String, Object> params, Wrapper<ExperienceEntity> wrapper);

    ResponseResult hotArticleList();

    ResponseResult latestArticleList();
}
