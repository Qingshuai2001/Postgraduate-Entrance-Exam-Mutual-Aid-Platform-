package com.qing.controller;

import com.qing.common.IgnoreAuth;
import com.qing.common.R;
import com.qing.service.CommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工具接口，获取某个表某个字段的所有值
 * @Author QingShuai
 * @Date 2023 05 08
 **/
@RestController
public class CommonController {


    @Autowired
    private CommonService commonService;

    /**
     * 获取table表中的column列表(联动接口)
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/option/{tableName}/{columnName}")
    public R getOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName, String level, String parent) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table", tableName);
        params.put("column", columnName);
        if(StringUtils.isNotBlank(level)) {
            params.put("level", level);
        }
        if(StringUtils.isNotBlank(parent)) {
            params.put("parent", parent);
        }
        List<String> data = commonService.getOption(params);
        return R.ok().put("data", data);
    }
}
