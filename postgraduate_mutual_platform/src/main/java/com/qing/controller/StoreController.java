package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qing.common.R;
import com.qing.entity.StoreEntity;
import com.qing.service.StoreService;
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


/**
 * 收藏表
 * 后端接口
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * 后端列表
     * @param params
     * @param store
     * @param request
     * @return
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,StoreEntity store, HttpServletRequest request){
        store.setCreatedBy((Long)request.getSession().getAttribute("userId"));
        EntityWrapper<StoreEntity> ew = new EntityWrapper<StoreEntity>();
        PageUtils page = storeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, store), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,StoreEntity store, HttpServletRequest request){
        store.setCreatedBy((Long)request.getSession().getAttribute("userId"));
        EntityWrapper<StoreEntity> ew = new EntityWrapper<StoreEntity>();
		PageUtils page = storeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, store), params), params));
        return R.ok().put("data", page);
    }


    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StoreEntity store = storeService.selectById(id);
        return R.ok().put("data", store);
    }


    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StoreEntity store = storeService.selectById(id);
        return R.ok().put("data", store);
    }

    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        storeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 后端保存
     * @param store
     * @param request
     * @return
     */
    @RequestMapping("/save")
    public R save(@RequestBody StoreEntity store, HttpServletRequest request){
        store.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        store.setCreatedBy((Long)request.getSession().getAttribute("userId"));
        store.setCreatedTime(new Date());
        storeService.insert(store);
        return R.ok();
    }
}
