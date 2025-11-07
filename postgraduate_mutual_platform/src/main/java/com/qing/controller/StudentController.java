package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.StudentEntity;
import com.qing.entity.TokenEntity;
import com.qing.service.StudentService;
import com.qing.service.TokenService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

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
        StudentEntity student = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("account", account));
        if(student==null || !student.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        request.getSession().setAttribute("userId",student.getId());
//        request.getSession().setAttribute("role","student");
        request.getSession().setAttribute("sessionTable","student");
        request.getSession().setAttribute("userName",student.getUserName());

        String token = tokenService.generateToken(student.getId(), account,"student", "student" );
        return R.ok().put("token", token);
    }

    /**
     * 跳转后台
     * @param account
     * @param request
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "/autoLogin")
    public R autoLogin(String account, HttpServletRequest request) {
        StudentEntity student = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("account", account));
        if(student==null) {
            return R.error("账号或密码不正确");
        }
        request.getSession().setAttribute("userId",student.getId());
//        request.getSession().setAttribute("role","student");
        request.getSession().setAttribute("sessionTable","student");
        request.getSession().setAttribute("userName",student.getUserName());

//        String token = tokenService.generateToken(student.getId(), account,"student", "student" );
        EntityWrapper<TokenEntity> tokenWrapper = new EntityWrapper<>();
        TokenEntity token1 = tokenService.selectOne(tokenWrapper.eq("account", student.getAccount()));
        String token = token1.getToken();
        return R.ok().put("token", token);
    }


    /**
     * 退出
     * @param request
     * @return
     */
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
        request.getSession().setAttribute("sessionTable","student");
        StudentEntity student = studentService.selectById(id);
        return R.ok().put("data",student);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody StudentEntity studentEntity){
        StudentEntity student = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("account", studentEntity.getAccount()));
        if(student!=null) {
            return R.error("注册用户已存在");
        }
        Long uId = new Date().getTime();
        studentEntity.setId(uId);
        studentEntity.setCreatedTime(new Date());
       studentService.insert(studentEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StudentEntity studentEntity, HttpServletRequest request){
        if(!request.getSession().getAttribute("sessionTable").equals("admin")){
            Long userId = (Long) request.getSession().getAttribute("userId");
            studentEntity.setId(userId);
        }
        studentService.updateById(studentEntity);//全部更新
        return R.ok();
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, StudentEntity student, HttpServletRequest request){
        EntityWrapper<StudentEntity> ew = new EntityWrapper<StudentEntity>();
        PageUtils page = studentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, student), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        studentService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @IgnoreAuth
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        StudentEntity student = studentService.selectById(id);
        return R.ok().put("data", student);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StudentEntity student, HttpServletRequest request){
        student.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        StudentEntity user = studentService.selectOne(new EntityWrapper<StudentEntity>().eq("account", student.getAccount()));
        if(user!=null) {
            return R.error("用户已存在");
        }
        student.setCreatedTime(new Date());
        studentService.insert(student);
        return R.ok();
    }

}
