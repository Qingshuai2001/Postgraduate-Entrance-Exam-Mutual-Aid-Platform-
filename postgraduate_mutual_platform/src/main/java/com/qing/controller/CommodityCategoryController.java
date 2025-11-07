package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.R;
import com.qing.entity.CategoryEntity;
import com.qing.entity.CommodityCategoryEntity;
import com.qing.service.CategoryService;
import com.qing.service.CommodityCategoryService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("/commoditycategory")
public class CommodityCategoryController {
    @Autowired
    private CommodityCategoryService commoditycategoryService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CommodityCategoryEntity commoditycategory, HttpServletRequest request){
        EntityWrapper<CommodityCategoryEntity> ew = new EntityWrapper<CommodityCategoryEntity>();
		PageUtils page = commoditycategoryService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, commoditycategory), params), params));
        return R.ok().put("data", page);
    }
    

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        CommodityCategoryEntity category = commoditycategoryService.selectById(id);
        return R.ok().put("data", category);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        CommodityCategoryEntity category = commoditycategoryService.selectById(id);
        return R.ok().put("data", category);
    }
    


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CommodityCategoryEntity category, HttpServletRequest request){
    	category.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        category.setCreatedTime(new Date());
        commoditycategoryService.insert(category);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CommodityCategoryEntity category, HttpServletRequest request){
        commoditycategoryService.updateById(category);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        commoditycategoryService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
