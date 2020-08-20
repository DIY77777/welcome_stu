package com.lthkj.project.welcome_newstu.service.impl;

import com.lthkj.project.welcome_newstu.dao.AcademyMapper;
import com.lthkj.project.welcome_newstu.model.Academy;
import com.lthkj.project.welcome_newstu.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/8/19 15:36
 */
@Service("academyService")
public class AcademyServiceImpl implements AcademyService {

    @Autowired
    private AcademyMapper academyMapper;

    @Override
    public List<Academy> getAllAcademy(Map<String,Object> map) {
        return academyMapper.getAllAcademy(map);
    }
}
