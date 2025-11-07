package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.ForumEntity;
import com.qing.entity.view.ForumView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author QingShuai
 * @Date 2023 04 29
 **/
@Mapper
public interface ForumDao extends BaseMapper<ForumEntity> {


    List<ForumView> selectListView(Pagination page, @Param("ew") Wrapper<ForumEntity> wrapper);
}
