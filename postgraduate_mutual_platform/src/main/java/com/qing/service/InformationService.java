package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.common.ResponseResult;
import com.qing.entity.InformationEntity;
import com.qing.utils.PageUtils;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 28
 **/
public interface InformationService extends IService<InformationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Wrapper<InformationEntity> wrapper);

    ResponseResult latestArticleList();

    ResponseResult hotArticleList();
}
