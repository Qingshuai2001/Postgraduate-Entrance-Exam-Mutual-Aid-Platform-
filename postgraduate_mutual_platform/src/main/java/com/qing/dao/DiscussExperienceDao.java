package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.DiscussExperienceEntity;
import com.qing.entity.view.DiscussExperienceView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DiscussExperienceDao extends BaseMapper<DiscussExperienceEntity> {
	

	List<DiscussExperienceView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussExperienceEntity> wrapper);
	

}
