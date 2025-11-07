package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.common.ResponseResult;
import com.qing.entity.ExperienceEntity;
import com.qing.service.ExperienceService;
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
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    /**
     * 前台列表
     * @param params
     * @param experienceEntity
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ExperienceEntity experienceEntity){
        EntityWrapper<ExperienceEntity> ew = new EntityWrapper<>();
        PageUtils page = experienceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, experienceEntity), params), params));
        return R.ok().put("data",page);
    }

    /**
     * 最热文章
     * @return
     */
    @IgnoreAuth
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        ResponseResult result =  experienceService.hotArticleList();
        return result;
    }

    /**
     * 最新文章
     * @return
     */
    @IgnoreAuth
    @GetMapping("/latestArticleList")
    public ResponseResult latestArticleList(){
        ResponseResult result =  experienceService.latestArticleList();
        return result;
    }

    /**
     * 前端详情
     * @param id
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ExperienceEntity experience = experienceService.selectById(id);
        experience.setClickNum(experience.getClickNum()+1);
        experienceService.updateById(experience);
        return R.ok().put("data", experience);
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ExperienceEntity experience, HttpServletRequest request){
        if(!request.getSession().getAttribute("sessionTable").equals("admin")){
            experience.setCreatedBy((Long) request.getSession().getAttribute("userId"));
        }
        EntityWrapper<ExperienceEntity> ew = new EntityWrapper<ExperienceEntity>();
        PageUtils page = experienceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, experience), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ExperienceEntity experience = experienceService.selectById(id);
        return R.ok().put("data", experience);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExperienceEntity experience, HttpServletRequest request){
        experience.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        Long userId = (Long) request.getSession().getAttribute("userId");
        experience.setCreatedBy(userId);
        experience.setCreatedTime(new Date());
        experience.setStatus("未审核");
        experience.setClickNum(0);
        experience.setStoreNum(0);
        experienceService.insert(experience);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ExperienceEntity experience, HttpServletRequest request){
        experience.setPublishTime(new Date());
        experienceService.updateById(experience);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        experienceService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
