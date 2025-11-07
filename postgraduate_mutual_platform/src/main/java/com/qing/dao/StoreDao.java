package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.StoreEntity;
import com.qing.entity.view.StoreView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 收藏表
 * 
 * @author 
 * @email 
 * @date
 */
@Mapper
public interface StoreDao extends BaseMapper<StoreEntity> {

	List<StoreView> selectListView(Pagination page, @Param("ew") Wrapper<StoreEntity> wrapper);
	

}
