package com.qing.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.qing.entity.StudentEntity;
import com.qing.utils.PageUtils;

import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
public interface StudentService extends IService<StudentEntity> {
    PageUtils queryPage(Map<String, Object> params, Wrapper<StudentEntity> wrapper);
}
