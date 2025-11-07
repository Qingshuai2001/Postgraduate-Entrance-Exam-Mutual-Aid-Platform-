package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.CommodityEntity;
import com.qing.entity.MaterialEntity;
import com.qing.service.MaterialService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, MaterialEntity materialEntity){
        EntityWrapper<MaterialEntity> ew = new EntityWrapper<MaterialEntity>();
        PageUtils page = materialService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, materialEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        MaterialEntity materialEntity = materialService.selectById(id);
        return R.ok().put("data", materialEntity);
    }

    /**
     * 发货
     * @param id
     * @return
     */
    @RequestMapping("/delivery/{id}")
    public R delivery(@PathVariable("id") String id){
        MaterialEntity materialEntity = materialService.selectById(id);
        materialEntity.setStatus("已发货");
        materialService.updateById(materialEntity);
        return R.ok();
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        MaterialEntity materialEntity =materialService.selectById(id);
        return R.ok().put("data", materialEntity);
    }

    @RequestMapping("/update")
    public R update(@RequestBody MaterialEntity materialEntity, HttpServletRequest request){
        materialService.updateById(materialEntity);//全部更新
        return R.ok();
    }

    /**
     * 修改：根据id
     * @param id
     * @return
     */
    @RequestMapping("/update/{id}")
    public R updateById(@PathVariable("id") String id){
        MaterialEntity materialEntity = materialService.selectById(id);
        materialEntity.setStatus("已下架");
        materialService.updateById(materialEntity);//全部更新
        return R.ok();
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MaterialEntity material, HttpServletRequest request){
        if(!request.getSession().getAttribute("sessionTable").equals("admin")){
            material.setCreatedBy((Long) request.getSession().getAttribute("userId"));
        }
        EntityWrapper<MaterialEntity> ew = new EntityWrapper<MaterialEntity>();
        PageUtils page = materialService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, material), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialEntity material, HttpServletRequest request){
        material.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        Long userId = (Long) request.getSession().getAttribute("userId");
        material.setCreatedBy(userId);
        material.setStatus("未审核");
        material.setCreatedTime(new Date());
        materialService.insert(material);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        materialService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
