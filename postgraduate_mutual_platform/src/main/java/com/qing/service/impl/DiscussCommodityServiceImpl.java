package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.DiscussCommodityDao;
import com.qing.entity.DiscussCommodityEntity;
import com.qing.entity.StudentEntity;
import com.qing.entity.view.DiscussCommodityView;
import com.qing.entity.view.DiscussExperienceView;
import com.qing.entity.view.DiscussMaterialView;
import com.qing.service.DiscussCommodityService;
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
public class DiscussCommodityServiceImpl extends ServiceImpl<DiscussCommodityDao, DiscussCommodityEntity> implements DiscussCommodityService {

    @Autowired
    private StudentService studentService;

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussCommodityEntity> wrapper) {
        Page<DiscussCommodityView> page =new Query<DiscussCommodityView>(params).getPage();
        List<DiscussCommodityView> discussCommodityViews = baseMapper.selectListView(page, wrapper);
        for (DiscussCommodityView discussCommodityView : discussCommodityViews) {
            StudentEntity student = studentService.selectById(discussCommodityView.getUserId());
            if(student!=null){
                discussCommodityView.setAvatar(student.getAvatar());
                discussCommodityView.setUserName(student.getUserName());
            }
        }
        page.setRecords(discussCommodityViews);
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
