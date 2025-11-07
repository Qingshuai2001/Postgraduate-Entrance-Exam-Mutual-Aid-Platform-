package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.AddressEntity;
import com.qing.entity.view.AddressView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 地址
 */
@Mapper
public interface AddressDao extends BaseMapper<AddressEntity> {

    List<AddressView> selectListView(Page<AddressView> page,@Param("ew") Wrapper<AddressEntity> wrapper);
}
