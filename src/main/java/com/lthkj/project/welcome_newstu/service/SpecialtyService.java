package com.lthkj.project.welcome_newstu.service;

import com.lthkj.project.welcome_newstu.vo.ClassesVo;
import com.lthkj.project.welcome_newstu.vo.SpecialtyDegreeVo;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/8/19 17:40
 */
public interface SpecialtyService {

    List<SpecialtyDegreeVo> getAllSpecialty(String AcademyId);

    List<ClassesVo> getClasses(Map<String,Object> map);
}
