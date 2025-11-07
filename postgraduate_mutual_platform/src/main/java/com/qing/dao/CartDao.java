package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.CartEntity;
import com.qing.entity.view.CartView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CartDao extends BaseMapper<CartEntity> {

	List<CartView> selectListView(Pagination page, @Param("ew") Wrapper<CartEntity> wrapper);

}
