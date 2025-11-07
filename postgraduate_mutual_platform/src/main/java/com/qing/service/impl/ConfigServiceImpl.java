package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.ConfigDao;
import com.qing.entity.ConfigEntity;
import com.qing.entity.view.CommodityView;
import com.qing.service.ConfigService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 28
 **/
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ConfigEntity> page = this.selectPage(new Query<ConfigEntity>(params).getPage(), new EntityWrapper<ConfigEntity>());
        return new PageUtils(page);

    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ConfigEntity> wrapper) {
        Page<ConfigEntity> page =new Query<ConfigEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
