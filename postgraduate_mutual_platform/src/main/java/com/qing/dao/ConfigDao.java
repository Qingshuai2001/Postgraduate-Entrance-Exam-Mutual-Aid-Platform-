package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.CommodityEntity;
import com.qing.entity.ConfigEntity;
import com.qing.entity.view.CommodityView;
import com.qing.utils.PageUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 04 28
 **/
@Mapper
public interface ConfigDao extends BaseMapper<ConfigEntity> {


    List<ConfigEntity> selectListView(Pagination page, @Param("ew") Wrapper<ConfigEntity> wrapper);
}
