package com.qing.dao;



import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qing.entity.TeacherEntity;
import com.qing.entity.view.TeacherView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
@Mapper
public interface TeacherDao extends BaseMapper<TeacherEntity> {
    List<TeacherView> selectListView(Page<TeacherView> page,  @Param("ew") Wrapper<TeacherEntity> wrapper);
}
