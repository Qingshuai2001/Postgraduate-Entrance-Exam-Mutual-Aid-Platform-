package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.qing.dao.AddressDao;
import com.qing.entity.AddressEntity;
import com.qing.entity.view.AddressView;
import com.qing.service.AddressService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {


    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<AddressEntity> wrapper) {
        Page<AddressView> page =new Query<AddressView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
