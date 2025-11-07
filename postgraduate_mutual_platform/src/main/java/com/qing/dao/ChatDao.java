package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.ChatEntity;
import com.qing.entity.view.ChatView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ChatDao extends BaseMapper<ChatEntity> {
	
	List<ChatView> selectListView(Pagination page, @Param("ew") Wrapper<ChatEntity> wrapper);

}
