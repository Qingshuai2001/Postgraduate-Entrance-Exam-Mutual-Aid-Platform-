package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.CommodityEntity;
import com.qing.entity.MaterialEntity;
import com.qing.entity.view.CommodityView;
import com.qing.entity.view.MaterialView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
@Mapper
public interface CommodityDao extends BaseMapper<CommodityEntity> {

    List<CommodityView> selectListView(Pagination page, @Param("ew") Wrapper<CommodityEntity> wrapper);
}
