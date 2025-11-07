package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.OrdersDao;
import com.qing.entity.CommodityEntity;
import com.qing.entity.MaterialEntity;
import com.qing.entity.OrdersEntity;
import com.qing.entity.view.OrdersView;
import com.qing.service.CommodityService;
import com.qing.service.MaterialService;
import com.qing.service.OrdersService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 04
 **/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private MaterialService  materialService;

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper) {
        Page<OrdersView> page =new Query<OrdersView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public PageUtils queryDeliveryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper,Long userId) {
        Page<OrdersEntity> page =new Query<OrdersEntity>(params).getPage();
        EntityWrapper<CommodityEntity> ew = new EntityWrapper<>();
        List<CommodityEntity> commodityList = commodityService.selectList(ew.eq("created_by", userId).eq("status", "已下架"));
        List<OrdersEntity> ordersEntityList = new ArrayList<>();
        for (CommodityEntity commodityEntity : commodityList) {
            EntityWrapper<OrdersEntity> wrap = new EntityWrapper<>();
            OrdersEntity orders = this.selectOne(wrap.eq("good_id", commodityEntity.getId()).eq("status", "已完成"));
            ordersEntityList.add(orders);
        }
        page.setRecords(ordersEntityList);
        page.setTotal(ordersEntityList.size());
        PageUtils pageUtil = new PageUtils(page);

        return pageUtil;
    }

    @Override
    public PageUtils queryFinishCommodityDeliveryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper, Long userId) {
        Page<OrdersEntity> page =new Query<OrdersEntity>(params).getPage();
        EntityWrapper<CommodityEntity> ew = new EntityWrapper<>();
        List<CommodityEntity> commodityList = commodityService.selectList(ew.eq("created_by", userId).eq("status", "已购买"));
        List<OrdersEntity> ordersEntityList = new ArrayList<>();
        for (CommodityEntity commodityEntity : commodityList) {
            EntityWrapper<OrdersEntity> wrap = new EntityWrapper<>();
            OrdersEntity orders = this.selectOne(wrap.eq("good_id", commodityEntity.getId()).eq("status", "已支付"));
            ordersEntityList.add(orders);
        }
        page.setRecords(ordersEntityList);
        page.setTotal(ordersEntityList.size());
        PageUtils pageUtil = new PageUtils(page);

        return pageUtil;
    }

    @Override
    public PageUtils queryFinishMaterialDeliveryPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper, Long userId) {
        Page<OrdersEntity> page =new Query<OrdersEntity>(params).getPage();
        EntityWrapper<MaterialEntity> ew = new EntityWrapper<>();
        List<MaterialEntity> materialList = materialService.selectList(ew.eq("created_by", userId).eq("status", "已购买"));
        List<OrdersEntity> ordersEntityList = new ArrayList<>();
        for (MaterialEntity materialEntity : materialList) {
            EntityWrapper<OrdersEntity> wrap = new EntityWrapper<>();
            OrdersEntity orders = this.selectOne(wrap.eq("good_id", materialEntity.getId()).eq("status", "已支付"));
            ordersEntityList.add(orders);
        }
        page.setRecords(ordersEntityList);
        page.setTotal(ordersEntityList.size());
        PageUtils pageUtil = new PageUtils(page);

        return pageUtil;
    }

    @Override
    public PageUtils queryDeliveryMaterialPage(Map<String, Object> params, Wrapper<OrdersEntity> wrapper, Long userId) {
        Page<OrdersEntity> page =new Query<OrdersEntity>(params).getPage();
        EntityWrapper<MaterialEntity> ew = new EntityWrapper<>();
        List<MaterialEntity> materialList = materialService.selectList(ew.eq("created_by", userId).eq("status", "已下架"));
        List<OrdersEntity> ordersEntityList = new ArrayList<>();
        for (MaterialEntity materialEntity : materialList) {
            EntityWrapper<OrdersEntity> wrap = new EntityWrapper<>();
            OrdersEntity orders = this.selectOne(wrap.eq("good_id", materialEntity.getId()).eq("status", "已完成"));
            ordersEntityList.add(orders);
        }
        page.setRecords(ordersEntityList);
        page.setTotal(ordersEntityList.size());
        PageUtils pageUtil = new PageUtils(page);

        return pageUtil;
    }
}
