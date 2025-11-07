package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.DiscussExperienceDao;
import com.qing.entity.DiscussExperienceEntity;
import com.qing.entity.StudentEntity;
import com.qing.entity.view.DiscussExperienceView;
import com.qing.entity.view.DiscussInformationView;
import com.qing.service.DiscussExperienceService;
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
public class DiscussExperienceServiceImpl extends ServiceImpl<DiscussExperienceDao, DiscussExperienceEntity> implements DiscussExperienceService {

    @Autowired
    private StudentService studentService;

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussExperienceEntity> wrapper) {
        Page<DiscussExperienceView> page =new Query<DiscussExperienceView>(params).getPage();
        List<DiscussExperienceView> discussExperienceViews = baseMapper.selectListView(page, wrapper);
        for (DiscussExperienceView discussExperienceView : discussExperienceViews) {
            StudentEntity student = studentService.selectById(discussExperienceView.getUserId());
            if(student!=null){
                discussExperienceView.setAvatar(student.getAvatar());
                discussExperienceView.setUserName(student.getUserName());
            }
        }
        page.setRecords(discussExperienceViews);
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
