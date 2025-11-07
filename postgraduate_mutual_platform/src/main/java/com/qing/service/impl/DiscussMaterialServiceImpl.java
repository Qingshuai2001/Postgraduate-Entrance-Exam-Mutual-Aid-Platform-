package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.DiscussMaterialDao;
import com.qing.entity.DiscussMaterialEntity;
import com.qing.entity.StudentEntity;
import com.qing.entity.view.DiscussMaterialView;
import com.qing.entity.view.DiscussMaterialView;
import com.qing.service.DiscussMaterialService;
import com.qing.service.StudentService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 03
 **/
@Service
public class DiscussMaterialServiceImpl extends ServiceImpl<DiscussMaterialDao, DiscussMaterialEntity> implements DiscussMaterialService {

    @Autowired
    private StudentService studentService;

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussMaterialEntity> wrapper) {
        Page<DiscussMaterialView> page =new Query<DiscussMaterialView>(params).getPage();
        List<DiscussMaterialView> discussMaterialViews = baseMapper.selectListView(page, wrapper);
        for (DiscussMaterialView discussMaterialView : discussMaterialViews) {
            StudentEntity student = studentService.selectById(discussMaterialView.getUserId());
            if(student!=null){
                discussMaterialView.setAvatar(student.getAvatar());
                discussMaterialView.setUserName(student.getUserName());
            }
        }
        page.setRecords(discussMaterialViews);
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
