package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.common.ResponseResult;
import com.qing.dao.InformationDao;
import com.qing.entity.InformationEntity;
import com.qing.entity.view.HotArticleView;
import com.qing.entity.view.InformationView;
import com.qing.service.InformationService;
import com.qing.utils.BeanCopyUtils;
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
 * @Date 2023 04 28
 **/
@Service
public class InformationServiceImpl extends ServiceImpl<InformationDao, InformationEntity> implements InformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<InformationEntity> page = this.selectPage(
                new Query<InformationEntity>(params).getPage(),
                new EntityWrapper<InformationEntity>()
        );
        return new PageUtils(page);
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<InformationEntity> wrapper) {
       Page<InformationView> page = new Query<InformationView>(params).getPage();
       page.setRecords(baseMapper.selectListView(page,wrapper));
       PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public ResponseResult latestArticleList() {
        Page<InformationEntity> page = new Page<>(1,10);
        EntityWrapper<InformationEntity> queryWrapper = new EntityWrapper<>();
        queryWrapper.orderDesc(Arrays.asList(new String[]{"publishTime"}));
        this.selectPage(page,queryWrapper);
        List<InformationEntity> information = page.getRecords();
        List<HotArticleView> hotArticleViews = new ArrayList<>();
        for (InformationEntity informationEntity : information) {
            HotArticleView hotArticleView = new HotArticleView();
            BeanUtils.copyProperties(informationEntity,hotArticleView);
            hotArticleViews.add(hotArticleView);
        }
        return ResponseResult.okResult(hotArticleViews);
    }

    @Override
    public ResponseResult hotArticleList() {
        Page<InformationEntity> page = new Page<>(1,10);
        EntityWrapper<InformationEntity> queryWrapper = new EntityWrapper<>();
        queryWrapper.orderDesc(Arrays.asList(new String[]{"clickNum"}));
        this.selectPage(page,queryWrapper);
        List<InformationEntity> information = page.getRecords();
        List<HotArticleView> hotArticleViews = new ArrayList<>();
        for (InformationEntity informationEntity : information) {
            HotArticleView hotArticleView = new HotArticleView();
            BeanUtils.copyProperties(informationEntity,hotArticleView);
            hotArticleViews.add(hotArticleView);
        }
        return ResponseResult.okResult(hotArticleViews);
    }
}
