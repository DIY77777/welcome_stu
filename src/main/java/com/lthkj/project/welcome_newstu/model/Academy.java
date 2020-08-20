package com.lthkj.project.welcome_newstu.model;

import lombok.Data;

/**
 * 学院类
 * Created by 关 on 2020/7/22 16:36
 */
@Data
public class Academy {

    private Integer AcademyId;  //学院ID
    private String AcademyName;     //学院名称
    private String AcademySpecialty;       //二级学院的专业集合
}
