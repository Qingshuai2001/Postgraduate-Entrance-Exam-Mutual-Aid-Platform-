package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.StudentDao;
import com.qing.dao.TeacherDao;
import com.qing.entity.StudentEntity;
import com.qing.entity.TeacherEntity;
import com.qing.entity.view.StudentView;
import com.qing.entity.view.TeacherView;
import com.qing.service.StudentService;
import com.qing.service.TeacherService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<TeacherEntity> wrapper) {
        Page<TeacherView> page =new Query<TeacherView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
