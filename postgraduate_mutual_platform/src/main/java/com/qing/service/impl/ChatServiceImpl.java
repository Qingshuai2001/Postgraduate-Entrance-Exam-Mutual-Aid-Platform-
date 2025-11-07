package com.qing.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.ChatDao;
import com.qing.entity.ChatEntity;
import com.qing.entity.view.ChatView;
import com.qing.service.ChatService;
import com.qing.utils.PageUtils;
import com.qing.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl extends ServiceImpl<ChatDao, ChatEntity> implements ChatService {

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChatEntity> wrapper) {
		  Page<ChatView> page =new Query<ChatView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    

}
