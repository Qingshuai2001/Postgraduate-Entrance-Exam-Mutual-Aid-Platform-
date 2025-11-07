package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.ExperienceEntity;
import com.qing.entity.view.ExperienceView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author QingShuai
 * @Date 2023 04 30
 **/
@Mapper
public interface ExperienceDao extends BaseMapper<ExperienceEntity> {

    List<ExperienceView> selectListView(Pagination page, @Param("ew") Wrapper<ExperienceEntity> wrapper);

}
