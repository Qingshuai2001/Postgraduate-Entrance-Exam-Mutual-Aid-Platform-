package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.DiscussExperienceEntity;
import com.qing.service.DiscussCommodityService;
import com.qing.service.DiscussExperienceService;
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
@RequestMapping("/discussexperience")
public class DiscussExperienceController {
    @Autowired
    private DiscussExperienceService discussExperienceService;

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscussExperienceEntity discussExperienceEntity, HttpServletRequest request){
        EntityWrapper<DiscussExperienceEntity> ew = new EntityWrapper<DiscussExperienceEntity>();
        PageUtils page = discussExperienceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussExperienceEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussExperienceEntity discussExperienceEntity, HttpServletRequest request){
        discussExperienceEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        discussExperienceEntity.setAddTime(new Date());
        discussExperienceService.insert(discussExperienceEntity);
        return R.ok();
    }



}