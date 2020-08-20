package com.lthkj.project.welcome_newstu.dao;

import com.lthkj.project.welcome_newstu.model.Academy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/8/19 15:01
 */
@Component
public interface AcademyMapper {
    List<Academy> getAllAcademy(Map<String,Object> map);

    List<Academy> getAll();
}
