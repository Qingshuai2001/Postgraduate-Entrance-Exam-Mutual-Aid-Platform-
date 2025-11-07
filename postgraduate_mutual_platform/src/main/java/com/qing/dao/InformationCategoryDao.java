package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.CategoryEntity;
import com.qing.entity.InformationCategoryEntity;
import com.qing.entity.view.CategoryView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface InformationCategoryDao extends BaseMapper<InformationCategoryEntity> {

	List<InformationCategoryEntity> selectListView(Pagination page, @Param("ew") Wrapper<InformationCategoryEntity> wrapper);

}
