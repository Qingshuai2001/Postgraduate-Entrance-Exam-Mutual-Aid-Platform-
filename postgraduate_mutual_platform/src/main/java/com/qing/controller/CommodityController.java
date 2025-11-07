package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.CommodityEntity;
import com.qing.entity.CommodityEntity;
import com.qing.service.CommodityService;
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
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, CommodityEntity commodityEntity){
        EntityWrapper<CommodityEntity> ew = new EntityWrapper<CommodityEntity>();
        PageUtils page = commodityService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, commodityEntity), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        CommodityEntity commodityEntity = commodityService.selectById(id);
        return R.ok().put("data", commodityEntity);
    }


    /**
     * 后端详情
     * @param id
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        CommodityEntity commodityEntity = commodityService.selectById(id);
        return R.ok().put("data", commodityEntity);
    }

    /**
     * 发货：修改商品状态为已发货
     * @param id
     * @return
     */
    @RequestMapping("/delivery/{id}")
    public R delivery(@PathVariable("id") String id){
        CommodityEntity commodityEntity = commodityService.selectById(id);
        commodityEntity.setStatus("已发货");
        commodityService.updateById(commodityEntity);
        return R.ok();
    }

    /**
     * 修改
     * @param commodityEntity
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public R update(@RequestBody CommodityEntity commodityEntity, HttpServletRequest request){
        commodityService.updateById(commodityEntity);//全部更新
        return R.ok();
    }

    /**
     * 根据id修改商品状态为已下架
     * @param id
     * @return
     */
    @RequestMapping("/update/{id}")
    public R updateById(@PathVariable("id") String id){
        CommodityEntity commodityEntity = commodityService.selectById(id);
        commodityEntity.setStatus("已下架");
        commodityService.updateById(commodityEntity);//全部更新
        return R.ok();
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CommodityEntity commodity, HttpServletRequest request){
        if(!request.getSession().getAttribute("sessionTable").equals("admin")){
            commodity.setCreatedBy((Long) request.getSession().getAttribute("userId"));
        }
        EntityWrapper<CommodityEntity> ew = new EntityWrapper<CommodityEntity>();
        PageUtils page = commodityService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, commodity), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CommodityEntity commodity, HttpServletRequest request){
        commodity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        Long userId = (Long) request.getSession().getAttribute("userId");
        commodity.setCreatedBy(userId);
        commodity.setStatus("未审核");
        commodity.setCreatedTime(new Date());
        commodityService.insert(commodity);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        commodityService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
