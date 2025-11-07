package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.DiscussCommodityEntity;
import com.qing.entity.view.DiscussCommodityView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DiscussCommodityDao extends BaseMapper<DiscussCommodityEntity> {
	

	List<DiscussCommodityView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussCommodityEntity> wrapper);
	

}
