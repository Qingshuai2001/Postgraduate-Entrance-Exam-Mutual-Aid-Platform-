package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.CategoryDao;
import com.qing.dao.CommodityCategoryDao;
import com.qing.entity.CategoryEntity;
import com.qing.entity.CommodityCategoryEntity;
import com.qing.entity.MaterialCategoryEntity;
import com.qing.service.CommodityCategoryService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 08
 **/
@Service
public class CommodityCategoryServiceImpl extends ServiceImpl<CommodityCategoryDao, CommodityCategoryEntity> implements CommodityCategoryService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CommodityCategoryEntity> wrapper) {
        Page<CommodityCategoryEntity> page =new Query<CommodityCategoryEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
