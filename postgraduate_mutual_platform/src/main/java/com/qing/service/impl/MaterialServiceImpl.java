package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.MaterialDao;
import com.qing.entity.MaterialEntity;
import com.qing.entity.view.MaterialView;
import com.qing.service.MaterialService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialDao, MaterialEntity> implements MaterialService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<MaterialEntity> wrapper) {
        Page<MaterialView> page =new Query<MaterialView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
