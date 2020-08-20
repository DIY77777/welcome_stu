package com.lthkj.project.welcome_newstu.service.impl;

import com.lthkj.project.welcome_newstu.dao.AdminMapper;
import com.lthkj.project.welcome_newstu.model.Admin;
import com.lthkj.project.welcome_newstu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 关 on 2020/7/24 14:55
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findOne(Admin admin) {
        return adminMapper.getOne(admin);
    }
}
