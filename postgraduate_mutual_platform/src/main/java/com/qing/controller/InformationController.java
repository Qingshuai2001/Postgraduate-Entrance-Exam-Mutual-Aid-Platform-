package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.common.ResponseResult;
import com.qing.entity.InformationEntity;
import com.qing.service.InformationService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 28
 **/
@RestController
@RequestMapping("/information")
@Slf4j
public class InformationController {

    @Autowired
    private InformationService informationService;

    /**
     * 前台列表
     * @param params
     * @param informationEntity
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, InformationEntity informationEntity){
        EntityWrapper<InformationEntity> ew = new EntityWrapper<>();
        PageUtils page = informationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, informationEntity), params), params));
        return R.ok().put("data",page);
    }


    /**
     * 最新资讯
     * @return
     */
    @IgnoreAuth
    @GetMapping("/latestArticleList")
    public ResponseResult latestArticleList(){
        ResponseResult result =  informationService.latestArticleList();
        return result;
    }

    /**
     * 热门文章
     * @return
     */
    @IgnoreAuth
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){
        ResponseResult result =  informationService.hotArticleList();
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
        InformationEntity Information = informationService.selectById(id);
        Information.setClickNum(Information.getClickNum()+1);
        Information.setClickTime(new Date());
        informationService.updateById(Information);
        return R.ok().put("data", Information);
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,InformationEntity information, HttpServletRequest request){
        EntityWrapper<InformationEntity> ew = new EntityWrapper<InformationEntity>();
        PageUtils page = informationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, information), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id) {
        InformationEntity information = informationService.selectById(id);
        information.setClickNum(information.getClickNum() + 1);
        information.setClickTime(new Date());
        informationService.updateById(information);
        return R.ok().put("data", information);

    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody InformationEntity information, HttpServletRequest request){
        information.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        information.setCreatedTime(new Date());
        Long userId = (Long) request.getSession().getAttribute("userId");
        information.setCreatedBy(userId);
        information.setStatus("正常");
        informationService.insert(information);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody InformationEntity information, HttpServletRequest request){
        information.setUpdatedTime(new Date());
        informationService.updateById(information);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        informationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
