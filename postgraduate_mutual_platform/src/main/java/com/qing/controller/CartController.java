package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.qing.common.R;
import com.qing.entity.CartEntity;
import com.qing.entity.view.CartView;
import com.qing.service.CartService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CartEntity cart, HttpServletRequest request){
        EntityWrapper<CartEntity> ew = new EntityWrapper<CartEntity>();
		PageUtils page = cartService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cart), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        CartEntity cart = cartService.selectById(id);
        return R.ok().put("data", cart);
    }
    

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CartEntity cart, HttpServletRequest request){
    	cart.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	cart.setUserId((Long)request.getSession().getAttribute("userId"));
        cart.setAddTime(new Date());
        cartService.insert(cart);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CartEntity cart, HttpServletRequest request){
        cart.setAddTime(new Date());
        cartService.updateById(cart);
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cartService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
