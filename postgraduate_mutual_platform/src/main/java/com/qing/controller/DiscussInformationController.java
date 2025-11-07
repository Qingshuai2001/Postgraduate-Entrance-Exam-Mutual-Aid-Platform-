package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.DiscussInformationEntity;
import com.qing.service.DiscussCommodityService;
import com.qing.service.DiscussExperienceService;
import com.qing.service.DiscussInformationService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/discussinformation")
public class DiscussInformationController {
    @Autowired
    private DiscussInformationService discussInformationService;

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscussInformationEntity discussInformationEntity, HttpServletRequest request){
        EntityWrapper<DiscussInformationEntity> ew = new EntityWrapper<DiscussInformationEntity>();
        PageUtils page = discussInformationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussInformationEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussInformationEntity discussInformationEntity, HttpServletRequest request){
        discussInformationEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        discussInformationEntity.setAddTime(new Date());
        discussInformationService.insert(discussInformationEntity);
        return R.ok();
    }

}