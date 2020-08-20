package com.lthkj.project.welcome_newstu.service;

import com.lthkj.project.welcome_newstu.model.Academy;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/8/19 15:36
 */
public interface AcademyService {
    List<Academy> getAllAcademy(Map<String,Object> map);
}
