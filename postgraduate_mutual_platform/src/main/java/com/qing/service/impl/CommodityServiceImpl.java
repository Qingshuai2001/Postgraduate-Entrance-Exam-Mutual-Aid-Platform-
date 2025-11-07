package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.CommodityDao;
import com.qing.dao.MaterialDao;
import com.qing.entity.CommodityEntity;
import com.qing.entity.MaterialEntity;
import com.qing.entity.view.CommodityView;
import com.qing.entity.view.MaterialView;
import com.qing.service.CommodityService;
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
public class CommodityServiceImpl extends ServiceImpl<CommodityDao, CommodityEntity> implements CommodityService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CommodityEntity> wrapper) {
        Page<CommodityView> page =new Query<CommodityView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
