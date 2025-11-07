package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.StoreDao;
import com.qing.entity.StoreEntity;
import com.qing.entity.view.StoreView;
import com.qing.service.StoreService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 03
 **/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreDao, StoreEntity> implements StoreService {
    @Override
    public List<StoreView> selectListView(Wrapper<StoreEntity> wrapper) {
        return null;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<StoreEntity> wrapper) {
        Page<StoreView> page =new Query<StoreView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
