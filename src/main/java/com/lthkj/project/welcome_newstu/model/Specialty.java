package com.lthkj.project.welcome_newstu.model;

import lombok.Data;

/**
 * 专业类
 * Created by 关 on 2020/7/22 16:36
 */
@Data
public class Specialty {

    private Integer SpecialtyId;    //学院专业ID
    private String SpecialtyName;   //学院专业名称
    private String SpecialtyCharge;     //专业收费
    private Integer SpecialtyDegree;       //学院专业批次

}
