package com.qing.service.impl;

import com.qing.dao.CommonDao;
import com.qing.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author QingShuai
 * @Date 2023 05 08
 **/
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private CommonDao commonDao;
    @Override
    public List<String> getOption(Map<String, Object> params) {
        return commonDao.getOption(params);
    }
}
