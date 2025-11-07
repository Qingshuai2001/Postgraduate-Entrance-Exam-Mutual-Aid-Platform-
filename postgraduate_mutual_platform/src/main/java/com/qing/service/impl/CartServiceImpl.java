package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.CartDao;
import com.qing.entity.CartEntity;
import com.qing.entity.view.CartView;
import com.qing.service.CartService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 04
 **/
@Service
public class CartServiceImpl extends ServiceImpl<CartDao, CartEntity> implements CartService {


    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CartEntity> wrapper) {
        Page<CartView> page =new Query<CartView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
