package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.CategoryDao;
import com.qing.entity.CategoryEntity;
import com.qing.entity.view.CategoryView;
import com.qing.service.CategoryService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 06
 **/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao,CategoryEntity> implements CategoryService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CategoryEntity> wrapper) {
        Page<CategoryView> page =new Query<CategoryView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
