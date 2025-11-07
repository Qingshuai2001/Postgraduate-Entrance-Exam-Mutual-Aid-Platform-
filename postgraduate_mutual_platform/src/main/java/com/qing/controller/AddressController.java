package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.qing.common.R;
import com.qing.entity.AddressEntity;
import com.qing.service.AddressService;
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


/**
 * 地址
 * 后端接口
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 前端列表
     * @param params
     * @param address
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AddressEntity address, HttpServletRequest request){
        address.setUserId((Long)request.getSession().getAttribute("userId"));
        EntityWrapper<AddressEntity> ew = new EntityWrapper<AddressEntity>();
		PageUtils page = addressService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, address), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端列表
     * @param params
     * @param address
     * @param request
     * @return
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AddressEntity address, HttpServletRequest request){
        address.setUserId((Long)request.getSession().getAttribute("userId"));
        EntityWrapper<AddressEntity> ew = new EntityWrapper<AddressEntity>();
        PageUtils page = addressService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, address), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AddressEntity address = addressService.selectById(id);
        return R.ok().put("data", address);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AddressEntity address = addressService.selectById(id);
        return R.ok().put("data", address);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AddressEntity address, HttpServletRequest request){
    	address.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	address.setUserId((Long)request.getSession().getAttribute("userId"));
		Long userId = (Long)request.getSession().getAttribute("userId");
    	if(address.getIsDefault().equals("是")) {
    		addressService.updateForSet("is_default='否'", new EntityWrapper<AddressEntity>().eq("userId", userId));
    	}
        addressService.insert(address);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AddressEntity address, HttpServletRequest request){
    	address.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	address.setUserId((Long)request.getSession().getAttribute("userId"));
		Long userId = (Long)request.getSession().getAttribute("userId");
    	if(address.getIsDefault().equals("是")) {
    		addressService.updateForSet("is_default='否'", new EntityWrapper<AddressEntity>().eq("user_id", userId));
    	}
    	address.setUserId(userId);
        addressService.insert(address);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AddressEntity address, HttpServletRequest request){
        if(address.getIsDefault().equals("是")) {
    		addressService.updateForSet("is_default='否'", new EntityWrapper<AddressEntity>().eq("user_id", request.getSession().getAttribute("userId")));
    	}
        addressService.updateById(address);//全部更新
        return R.ok();
    }
    
    /**
     * 获取默认地址
     */
    @RequestMapping("/default")
    public R defaultAddress(HttpServletRequest request){
    	Wrapper<AddressEntity> wrapper = new EntityWrapper<AddressEntity>().eq("is_default", "是").eq("userid", request.getSession().getAttribute("userId"));
        AddressEntity address = addressService.selectOne(wrapper);
        return R.ok().put("data", address);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        addressService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
