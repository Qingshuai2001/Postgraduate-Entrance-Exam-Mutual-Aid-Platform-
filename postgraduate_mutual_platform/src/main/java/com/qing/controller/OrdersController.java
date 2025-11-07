package com.qing.controller;

import cn.hutool.db.sql.Order;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.R;
import com.qing.entity.CommodityEntity;
import com.qing.entity.OrdersEntity;
import com.qing.service.CommodityService;
import com.qing.service.OrdersService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, OrdersEntity order, HttpServletRequest request){

        order.setUserId((Long)request.getSession().getAttribute("userId"));
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
		PageUtils page = ordersService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, order), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, OrdersEntity order, HttpServletRequest request){
        if(!request.getSession().getAttribute("sessionTable").equals("admin")){
            order.setUserId((Long) request.getSession().getAttribute("userId"));
        }
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
		PageUtils page = ordersService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, order), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 已完成商品订单列表
     * @param params
     * @param order
     * @param request
     * @return
     */
    @RequestMapping("/finishCommodity")
    public R delivery(@RequestParam Map<String, Object> params, OrdersEntity order, HttpServletRequest request){
        Long userId = (Long) request.getSession().getAttribute("userId");
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
        PageUtils page = ordersService.queryDeliveryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, order), params), params),userId);
        return R.ok().put("data", page);
    }

    /**
     * 已完成资料订单列表
     * @param params
     * @param order
     * @param request
     * @return
     */
    @RequestMapping("/finishMaterial")
    public R delivery1(@RequestParam Map<String, Object> params, OrdersEntity order, HttpServletRequest request){
        Long userId = (Long) request.getSession().getAttribute("userId");
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
        PageUtils page = ordersService.queryDeliveryMaterialPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, order), params), params),userId);
        return R.ok().put("data", page);
    }

    /**
     * 商品订单
     * @param params
     * @param order
     * @param request
     * @return
     */
    @RequestMapping("/CommodityOrder")
    public R finishCommodityDelivery(@RequestParam Map<String, Object> params, OrdersEntity order, HttpServletRequest request){
        Long userId = (Long) request.getSession().getAttribute("userId");
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
        PageUtils page = ordersService.queryFinishCommodityDeliveryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, order), params), params),userId);
        return R.ok().put("data", page);
    }

    /**
     * 资料订单
     * @param params
     * @param order
     * @param request
     * @return
     */
    @RequestMapping("/MaterialOrder")
    public R finishMaterialDelivery(@RequestParam Map<String, Object> params, OrdersEntity order, HttpServletRequest request){
        Long userId = (Long) request.getSession().getAttribute("userId");
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
        PageUtils page = ordersService.queryFinishMaterialDeliveryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, order), params), params),userId);
        return R.ok().put("data", page);
    }

	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        OrdersEntity order = ordersService.selectById(id);
        return R.ok().put("data", order);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        OrdersEntity order = ordersService.selectById(id);
        return R.ok().put("data", order);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OrdersEntity order, HttpServletRequest request){
    	order.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	order.setUserId((Long)request.getSession().getAttribute("userId"));
        ordersService.insert(order);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody OrdersEntity order, HttpServletRequest request){
    	order.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        order.setCreatedTime(new Date());
        ordersService.insert(order);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OrdersEntity order, HttpServletRequest request){
        ordersService.updateById(order);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ordersService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
