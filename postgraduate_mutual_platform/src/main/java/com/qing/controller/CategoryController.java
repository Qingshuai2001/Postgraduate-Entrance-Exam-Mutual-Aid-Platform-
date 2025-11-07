package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qing.common.R;
import com.qing.entity.CategoryEntity;
import com.qing.entity.view.CategoryView;
import com.qing.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CategoryEntity category, HttpServletRequest request){
        EntityWrapper<CategoryEntity> ew = new EntityWrapper<CategoryEntity>();
		PageUtils page = categoryService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, category), params), params));
        return R.ok().put("data", page);
    }
    

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        CategoryEntity category = categoryService.selectById(id);
        return R.ok().put("data", category);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        CategoryEntity category = categoryService.selectById(id);
        return R.ok().put("data", category);
    }
    

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category, HttpServletRequest request){
    	category.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        category.setCreatedTime(new Date());
        categoryService.insert(category);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category, HttpServletRequest request){
        categoryService.updateById(category);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        categoryService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
