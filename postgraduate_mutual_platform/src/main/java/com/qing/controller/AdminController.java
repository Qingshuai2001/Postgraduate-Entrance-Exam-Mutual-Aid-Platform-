package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.AdminEntity;
import com.qing.service.AdminService;
import com.qing.service.StudentService;
import com.qing.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     * @param account
     * @param password
     * @param captcha
     * @param request
     * @return
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String account, String password, String captcha, HttpServletRequest request) {
        AdminEntity admin = adminService.selectOne(new EntityWrapper<AdminEntity>().eq("account", account));
        if(admin==null || !admin.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }

        request.getSession().setAttribute("userId",admin.getId());
        String token = tokenService.generateToken(admin.getId(),account, "admin", "admin");
        return R.ok().put("token", token);
    }


    /**
     * 注册
     * @param admin
     * @return
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody AdminEntity admin){
        if(adminService.selectOne(new EntityWrapper<AdminEntity>().eq("account", admin.getAccount())) !=null) {
            return R.error("用户已存在");
        }
        Long uId = new Date().getTime();
        admin.setId(uId);
        admin.setCreatedTime(new Date());
        adminService.insert(admin);
        return R.ok();
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @IgnoreAuth
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 密码重置
     * @param account
     * @param request
     * @return
     */
    @RequestMapping(value = "/resetPass")
    public R resetPass(String account, HttpServletRequest request){
        AdminEntity admin = adminService.selectOne(new EntityWrapper<AdminEntity>().eq("account", account));
        if(admin==null) {
            return R.error("账号不存在");
        }
        admin.setPassword("123456");
        adminService.update(admin,null);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取登录用户信息
     * @param request
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        AdminEntity admin = adminService.selectById(id);
        request.getSession().setAttribute("userName",admin.getUserName());
        request.getSession().setAttribute("sessionTable","admin");
        return R.ok().put("data", admin);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public R update(@RequestBody AdminEntity user){
        adminService.updateById(user);//全部更新
        return R.ok();
    }

}
