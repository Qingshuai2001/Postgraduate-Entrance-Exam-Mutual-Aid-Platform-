package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.DiscussInformationDao;
import com.qing.entity.DiscussInformationEntity;
import com.qing.entity.StudentEntity;
import com.qing.entity.view.DiscussInformationView;
import com.qing.service.DiscussInformationService;
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
public class DiscussInformationServiceImpl extends ServiceImpl<DiscussInformationDao, DiscussInformationEntity> implements DiscussInformationService {

    @Autowired
    private StudentService studentService;

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussInformationEntity> wrapper) {
        Page<DiscussInformationView> page =new Query<DiscussInformationView>(params).getPage();
        List<DiscussInformationView> discussInformationViews = baseMapper.selectListView(page, wrapper);
        for (DiscussInformationView discussInformationView : discussInformationViews) {
            StudentEntity student = studentService.selectById(discussInformationView.getUserId());
            if(student!=null){
                discussInformationView.setAvatar(student.getAvatar());
                discussInformationView.setUserName(student.getUserName());
            }
        }
        page.setRecords(discussInformationViews);
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
