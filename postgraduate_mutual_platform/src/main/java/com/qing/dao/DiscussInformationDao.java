package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.DiscussInformationEntity;
import com.qing.entity.view.DiscussInformationView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DiscussInformationDao extends BaseMapper<DiscussInformationEntity> {
	

	List<DiscussInformationView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussInformationEntity> wrapper);
	

}
