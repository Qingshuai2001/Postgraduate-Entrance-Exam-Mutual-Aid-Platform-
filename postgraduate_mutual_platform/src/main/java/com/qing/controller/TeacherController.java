package com.qing.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.StudentEntity;
import com.qing.entity.TeacherEntity;
import com.qing.entity.TokenEntity;
import com.qing.service.TeacherService;
import com.qing.service.TokenService;
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
 * @Date 2023 05 02
 **/
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TokenService tokenService;


    /**
     * 登录
     * @param account
     * @param password
     * @param request
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String account, String password, HttpServletRequest request) {
        TeacherEntity teacher = teacherService.selectOne(new EntityWrapper<TeacherEntity>().eq("account", account));
        if(teacher==null || !teacher.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        request.getSession().setAttribute("userId",teacher.getId());
//        request.getSession().setAttribute("role","teacher");
        request.getSession().setAttribute("userName",teacher.getUserName());
        String token = tokenService.generateToken(teacher.getId(), account,"teacher", "teacher" );
        return R.ok().put("token", token);
    }

    @IgnoreAuth
    @RequestMapping(value = "/autoLogin")
    public R autoLogin(String account, HttpServletRequest request) {
        TeacherEntity teacher = teacherService.selectOne(new EntityWrapper<TeacherEntity>().eq("account", account));
        if(teacher==null) {
            return R.error("账号或密码不正确");
        }
        request.getSession().setAttribute("userId",teacher.getId());
//        request.getSession().setAttribute("role","student");
        request.getSession().setAttribute("sessionTable","teacher");
        request.getSession().setAttribute("userName",teacher.getUserName());

//        String token = tokenService.generateToken(teacher.getId(), account,"teacher", "teacher" );
//        return R.ok().put("token", token);
        EntityWrapper<TokenEntity> tokenWrapper = new EntityWrapper<>();
        TokenEntity token1 = tokenService.selectOne(tokenWrapper.eq("account", teacher.getAccount()));
        String token = token1.getToken();
        return R.ok().put("token", token);
    }

    @IgnoreAuth
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 获取用户的session用户信息
     */
    @IgnoreAuth
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        request.getSession().setAttribute("sessionTable","teacher");
        TeacherEntity teacher = teacherService.selectById(id);
        return R.ok().put("data",teacher);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody TeacherEntity teacherEntity){
        TeacherEntity teacher = teacherService.selectOne(new EntityWrapper<TeacherEntity>().eq("account", teacherEntity.getAccount()));
        if(teacher!=null) {
            return R.error("注册用户已存在");
        }
        Long uId = new Date().getTime();
        teacherEntity.setId(uId);
        teacherEntity.setCreatedTime(new Date());
        teacherService.insert(teacherEntity);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TeacherEntity teacherEntity, HttpServletRequest request){
        if(!request.getSession().getAttribute("sessionTable").equals("admin")){
            Long userId = (Long) request.getSession().getAttribute("userId");
            teacherEntity.setId(userId);
        }
        teacherService.updateById(teacherEntity);//全部更新
        return R.ok();
    }

    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, TeacherEntity teacher, HttpServletRequest request){
        EntityWrapper<TeacherEntity> ew = new EntityWrapper<TeacherEntity>();
        PageUtils page = teacherService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, teacher), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        teacherService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        TeacherEntity teacher = teacherService.selectById(id);
        return R.ok().put("data", teacher);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TeacherEntity teacher, HttpServletRequest request){
        teacher.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        TeacherEntity user = teacherService.selectOne(new EntityWrapper<TeacherEntity>().eq("account", teacher.getAccount()));
        if(user!=null) {
            return R.error("用户已存在");
        }
        teacher.setCreatedTime(new Date());
        teacherService.insert(teacher);
        return R.ok();
    }
}

