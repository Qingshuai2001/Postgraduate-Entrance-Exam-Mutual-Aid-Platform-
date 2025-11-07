package com.qing.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 08
 **/
@Mapper
public interface CommonDao {

    List<String> getOption(Map<String, Object> params);
}
