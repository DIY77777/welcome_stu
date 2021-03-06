package com.lthkj.project.welcome_newstu.dao;

import com.lthkj.project.welcome_newstu.vo.ClassesVo;
import com.lthkj.project.welcome_newstu.vo.SpecialtyDegreeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/8/19 17:05
 */
@Component
public interface SpecialtyMapper {
    List<SpecialtyDegreeVo> getAllSpecialty(@Param("AcademyId") String AcademyId);

    List<ClassesVo> getClasses(Map<String,Object> map);
}
