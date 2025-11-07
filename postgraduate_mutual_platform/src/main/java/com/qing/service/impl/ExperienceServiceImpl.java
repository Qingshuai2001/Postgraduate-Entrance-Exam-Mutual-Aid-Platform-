package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.common.ResponseResult;
import com.qing.dao.ExperienceDao;
import com.qing.entity.ExperienceEntity;
import com.qing.entity.InformationEntity;
import com.qing.entity.view.ExperienceView;
import com.qing.entity.view.HotArticleView;
import com.qing.entity.view.InformationView;
import com.qing.service.ExperienceService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
@Service
public class ExperienceServiceImpl extends ServiceImpl<ExperienceDao, ExperienceEntity> implements ExperienceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ExperienceEntity> wrapper) {
        Page<ExperienceView> page = new Query<ExperienceView>(params).getPage();
        wrapper.orderDesc(Arrays.asList(new String[]{"publish_time"}));
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public ResponseResult hotArticleList() {
        Page<ExperienceEntity> page = new Page<>(1,10);
        EntityWrapper<ExperienceEntity> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("status","通过");
        queryWrapper.orderDesc(Arrays.asList(new String[]{"clickNum"}));
        this.selectPage(page,queryWrapper);
        List<ExperienceEntity> experience = page.getRecords();
        List<HotArticleView> hotArticleViews = new ArrayList<>();
        for (ExperienceEntity experienceEntity : experience) {
            HotArticleView hotArticleView = new HotArticleView();
            BeanUtils.copyProperties(experienceEntity,hotArticleView);
            hotArticleViews.add(hotArticleView);
        }
        return ResponseResult.okResult(hotArticleViews);
    }

    @Override
    public ResponseResult latestArticleList() {
        Page<ExperienceEntity> page = new Page<>(1,10);
        EntityWrapper<ExperienceEntity> queryWrapper = new EntityWrapper<>();
        queryWrapper.eq("status","通过");
        queryWrapper.orderDesc(Arrays.asList(new String[]{"publishTime"}));
        this.selectPage(page,queryWrapper);
        List<ExperienceEntity> experience = page.getRecords();
        List<HotArticleView> hotArticleViews = new ArrayList<>();
        for (ExperienceEntity experienceEntity : experience) {
            HotArticleView hotArticleView = new HotArticleView();
            BeanUtils.copyProperties(experienceEntity,hotArticleView);
            hotArticleViews.add(hotArticleView);
        }
        return ResponseResult.okResult(hotArticleViews);
    }
}
