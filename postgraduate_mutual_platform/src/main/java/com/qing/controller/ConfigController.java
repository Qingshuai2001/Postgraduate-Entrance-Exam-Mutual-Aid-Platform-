package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.ConfigEntity;
import com.qing.service.ConfigService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 28
 **/
@RestController
@RequestMapping("/config")
@Slf4j
public class ConfigController {

    @Autowired
    private ConfigService configService;


    @IgnoreAuth
    @GetMapping("/list")
    public R list(@RequestParam Map<String,Object> params){
        PageUtils page = configService.queryPage(params);
        return R.ok().put("data",page);
    }

    /**
     * 后端列表
     * @param params
     * @param config
     * @return
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ConfigEntity config){
        EntityWrapper<ConfigEntity> ew = new EntityWrapper<ConfigEntity>();
        PageUtils page = configService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, config), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 详细信息
     * @param id
     * @return
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ConfigEntity config = configService.selectById(id);
        return R.ok().put("data", config);
    }

    /**
     * 后端保存
     * @param config
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody ConfigEntity config){
        configService.insert(config);
        return R.ok();
    }

    /**
     * 修改
     * @param config
     * @return
     */
    @RequestMapping("/update")
    public R update(@RequestBody ConfigEntity config){
        configService.updateById(config);//全部更新
        return R.ok();
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        configService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
