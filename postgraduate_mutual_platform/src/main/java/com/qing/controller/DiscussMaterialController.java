package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.DiscussMaterialEntity;
import com.qing.service.DiscussCommodityService;
import com.qing.service.DiscussExperienceService;
import com.qing.service.DiscussInformationService;
import com.qing.service.DiscussMaterialService;
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
@RequestMapping("/discussmaterial")
public class DiscussMaterialController {
    @Autowired
    private DiscussMaterialService discussMaterialService;

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscussMaterialEntity discussMaterialEntity, HttpServletRequest request){
        EntityWrapper<DiscussMaterialEntity> ew = new EntityWrapper<DiscussMaterialEntity>();
        PageUtils page = discussMaterialService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussMaterialEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussMaterialEntity discussMaterialEntity, HttpServletRequest request){
        discussMaterialEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        discussMaterialEntity.setAddTime(new Date());
        discussMaterialService.insert(discussMaterialEntity);

        return R.ok();
    }

}