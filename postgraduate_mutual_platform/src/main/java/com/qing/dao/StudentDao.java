package com.qing.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qing.entity.StudentEntity;
import com.qing.entity.view.StudentView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

    List<StudentView> selectListView(Pagination page, @Param("ew") Wrapper<StudentEntity> wrapper);

}
