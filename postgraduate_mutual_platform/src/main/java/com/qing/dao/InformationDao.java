package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.InformationEntity;
import com.qing.entity.view.InformationView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考研资讯
 * @Author QingShuai
 * @Date 2023 04 28
 **/
@Mapper
public interface InformationDao extends BaseMapper<InformationEntity> {


    List<InformationView> selectListView(Pagination page, @Param("ew") Wrapper<InformationEntity> wrapper);


}
