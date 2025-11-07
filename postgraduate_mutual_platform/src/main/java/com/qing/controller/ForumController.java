package com.qing.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.entity.ForumEntity;
import com.qing.entity.StudentEntity;
import com.qing.entity.TeacherEntity;
import com.qing.service.ForumService;
import com.qing.service.StudentService;
import com.qing.service.TeacherService;
import com.qing.utils.MPUtil;
import com.qing.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author QingShuai
 * @Date 2023 04 29
 **/
@RestController
@RequestMapping("/forum")
@Slf4j
public class ForumController {

    @Autowired
    private ForumService forumService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    /**
     * 前台论坛列表
     * @param params
     * @param forum
     * @param
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/flist")
    public R flist(@RequestParam Map<String, Object> params,ForumEntity forum){
        EntityWrapper<ForumEntity> ew = new EntityWrapper<ForumEntity>();
        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端论坛模糊查找
     * @param params
     * @param forum
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/searchList")
    public R searchList(@RequestParam Map<String, Object> params,ForumEntity forum){
        EntityWrapper<ForumEntity> ew = new EntityWrapper<ForumEntity>();
        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 论坛详情
     */
    @IgnoreAuth
    @RequestMapping("/list/{id}")
    public R list(@PathVariable("id") String id){
        ForumEntity forum = forumService.selectById(id);
        getChilds(forum);
        if(forum.getChilds()!=null){
            List<ForumEntity> childs = forum.getChilds();
            for(ForumEntity forumEntity : childs) {
                if(forumEntity.getUserName().contains("老师")){
                    TeacherEntity teacher = teacherService.selectById(forumEntity.getCreatedBy());
                    forumEntity.setAvatar(teacher.getAvatar());
                }else{
                    StudentEntity student = studentService.selectById(forumEntity.getCreatedBy());
                    forumEntity.setAvatar(student.getAvatar());
                }
            }
        }

        return R.ok().put("data", forum);
    }

    /**
     * 获取子评论
     * @param forum
     * @return
     */
    @IgnoreAuth
    private ForumEntity getChilds(ForumEntity forum) {
        List<ForumEntity> childs = new ArrayList<ForumEntity>();
        childs = forumService.selectList(new EntityWrapper<ForumEntity>().eq("parent_id", forum.getId()));
        if(childs == null || childs.size()==0) {
            return null;
        }
        forum.setChilds(childs);
        return forum;
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ForumEntity forum, HttpServletRequest request){
        forum.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        forum.setCreatedBy(((Long)request.getSession().getAttribute("userId")));
        String sessionTable = (String)request.getSession().getAttribute("sessionTable");
        if(sessionTable.equals("student")){
            StudentEntity student = studentService.selectById(forum.getCreatedBy());
            forum.setUserName(student.getUserName());
        }else{
            TeacherEntity teacher = teacherService.selectById(forum.getCreatedBy());
            forum.setUserName(teacher.getUserName());
        }
        if(forum.getParentId()!=null){
            EntityWrapper<ForumEntity> wrapper = new EntityWrapper<>();
            ForumEntity forumEntity = forumService.selectOne(wrapper.eq("id", forum.getParentId()));
            forum.setTitle(forumEntity.getTitle());
        }
        forum.setCreatedTime(new Date());
        forum.setIsDone("开放");
        forumService.insert(forum);
        return R.ok();
    }

    /**
     * 发布
     * @param forum
     * @param request
     * @return
     */
    @RequestMapping("/publish")
    public R publish(@RequestBody ForumEntity forum, HttpServletRequest request){
        forum.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        forum.setCreatedTime(new Date());
        forumService.insert(forum);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ForumEntity forum, HttpServletRequest request){
        forum.setCreatedTime(new Date());
        forumService.updateById(forum);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        forumService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 后台列表
     * @param params
     * @param forum
     * @param request
     * @return
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ForumEntity forum, HttpServletRequest request){
        forum.setCreatedBy((Long)request.getSession().getAttribute("userId"));
        EntityWrapper<ForumEntity> ew = new EntityWrapper<ForumEntity>();
        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ForumEntity forum, HttpServletRequest request){
        if(!request.getSession().getAttribute("sessionTable").equals("admin")){
            forum.setCreatedBy((Long) request.getSession().getAttribute("userId"));
        }
        EntityWrapper<ForumEntity> ew = new EntityWrapper<ForumEntity>();
        PageUtils page = forumService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, forum), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ForumEntity forum = forumService.selectById(id);
        return R.ok().put("data", forum);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ForumEntity forum, HttpServletRequest request){
        forum.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        forum.setCreatedTime(new Date());
        forum.setCreatedBy((Long)request.getSession().getAttribute("userId"));
        forumService.insert(forum);
        return R.ok();
    }

}
