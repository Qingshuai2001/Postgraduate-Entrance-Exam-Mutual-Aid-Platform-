package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.CategoryDao;
import com.qing.dao.InformationCategoryDao;
import com.qing.entity.CategoryEntity;
import com.qing.entity.InformationCategoryEntity;
import com.qing.entity.view.CategoryView;
import com.qing.service.InformationCategoryService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 08
 **/
@Service
public class InformationCategoryServiceImpl extends ServiceImpl<InformationCategoryDao, InformationCategoryEntity>  implements InformationCategoryService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<InformationCategoryEntity> wrapper) {
        Page<InformationCategoryEntity> page =new Query<InformationCategoryEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
