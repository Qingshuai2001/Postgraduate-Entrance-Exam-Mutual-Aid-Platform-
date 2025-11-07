package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.StudentDao;
import com.qing.entity.StudentEntity;
import com.qing.entity.view.StudentView;
import com.qing.service.StudentService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<StudentEntity> wrapper) {
        Page<StudentView> page =new Query<StudentView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
