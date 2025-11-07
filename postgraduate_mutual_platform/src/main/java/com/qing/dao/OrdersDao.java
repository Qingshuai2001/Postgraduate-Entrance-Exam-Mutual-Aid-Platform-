package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.OrdersEntity;
import com.qing.entity.view.OrdersView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OrdersDao extends BaseMapper<OrdersEntity> {

	List<OrdersView> selectListView(Pagination page, @Param("ew") Wrapper<OrdersEntity> wrapper);
	

}
