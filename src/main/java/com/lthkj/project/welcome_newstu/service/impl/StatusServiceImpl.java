package com.lthkj.project.welcome_newstu.service.impl;

import com.lthkj.project.welcome_newstu.dao.StatusMapper;
import com.lthkj.project.welcome_newstu.model.Status;
import com.lthkj.project.welcome_newstu.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 关 on 2020/8/20 16:58
 */
@Service("statusService")
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public List<Status> getAll() {
        return statusMapper.getAll();
    }
}
