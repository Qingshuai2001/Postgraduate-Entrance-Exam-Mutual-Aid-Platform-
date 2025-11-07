package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.CategoryEntity;
import com.qing.entity.CommodityCategoryEntity;
import com.qing.entity.MaterialCategoryEntity;
import com.qing.entity.view.CategoryView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CommodityCategoryDao extends BaseMapper<CommodityCategoryEntity> {

	List<CommodityCategoryEntity> selectListView(Pagination page, @Param("ew") Wrapper<CommodityCategoryEntity> wrapper);

}
