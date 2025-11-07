package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.ForumDao;
import com.qing.entity.ForumEntity;
import com.qing.entity.view.ForumView;
import com.qing.service.ForumService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 29
 **/
@Service
public class ForumServiceImpl extends ServiceImpl<ForumDao, ForumEntity> implements ForumService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ForumEntity> wrapper) {
        Page<ForumView> page =new Query<ForumView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
