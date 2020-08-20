package com.lthkj.project.welcome_newstu.model;

import lombok.Data;
/**
 * 学位类
 * Created by 关 on 2020/7/22 16:36
 */
@Data
public class Degree {
    private Integer DegreeId;
    private String DegreeName;  //学位的对应字段 0为专科，1为本科，2为研究生
}
