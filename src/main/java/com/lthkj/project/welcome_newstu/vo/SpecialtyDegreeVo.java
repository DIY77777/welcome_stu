package com.lthkj.project.welcome_newstu.vo;

import com.lthkj.project.welcome_newstu.model.Specialty;
import lombok.Data;

/**
 * Created by 关 on 2020/8/19 17:08
 */
@Data
public class SpecialtyDegreeVo extends Specialty {

    private String DegreeName;
    private String SpecialtyNameAndDegree;
}
