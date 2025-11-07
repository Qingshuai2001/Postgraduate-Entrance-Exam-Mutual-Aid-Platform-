package com.qing.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.dao.AdminDao;
import com.qing.dao.StudentDao;
import com.qing.entity.AdminEntity;
import com.qing.entity.StudentEntity;
import com.qing.service.AdminService;
import com.qing.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Author QingShuai
 * @Date 2023 05 02
 **/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {
}
