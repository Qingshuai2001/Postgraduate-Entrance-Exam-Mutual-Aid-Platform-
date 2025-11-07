package com.qing.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.DiscussCommodityEntity;
import com.qing.entity.DiscussMaterialEntity;
import com.qing.service.DiscussCommodityService;
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
@RequestMapping("/discusscommodity")
public class DiscussCommodityController {
    @Autowired
    private DiscussCommodityService discussCommodityService;

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscussCommodityEntity discussCommodityEntity, HttpServletRequest request){
        EntityWrapper<DiscussCommodityEntity> ew = new EntityWrapper<DiscussCommodityEntity>();
        PageUtils page = discussCommodityService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussCommodityEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussCommodityEntity discussCommodityEntity, HttpServletRequest request){
        discussCommodityEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        discussCommodityEntity.setAddTime(new Date());
        discussCommodityService.insert(discussCommodityEntity);
        return R.ok();
    }

}
