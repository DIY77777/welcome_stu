package com.lthkj.project.welcome_newstu.service.impl;

import com.lthkj.project.welcome_newstu.dao.SpecialtyMapper;
import com.lthkj.project.welcome_newstu.service.SpecialtyService;
import com.lthkj.project.welcome_newstu.vo.ClassesVo;
import com.lthkj.project.welcome_newstu.vo.SpecialtyDegreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/8/19 17:41
 */
@Service("specialtyService")
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyMapper specialtyMapper;

    @Override
    public List<SpecialtyDegreeVo> getAllSpecialty(String AcademyId) {
        return specialtyMapper.getAllSpecialty(AcademyId);
    }

    @Override
    public List<ClassesVo> getClasses(Map<String, Object> map) {
        return specialtyMapper.getClasses(map);
    }
}
