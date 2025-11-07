package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.DiscussMaterialEntity;
import com.qing.entity.view.DiscussMaterialView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussMaterialDao extends BaseMapper<DiscussMaterialEntity> {

	List<DiscussMaterialView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussMaterialEntity> wrapper);

}
