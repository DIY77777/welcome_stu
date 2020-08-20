package com.lthkj.project.welcome_newstu.model;


import lombok.Data;

import java.util.Date;

/**
 * Created by 关 on 2020/7/27 15:40
 */
@Data
public class Payrecord {

    private String StuId;    //缴费的学生ID
    private String payCount;  //缴的总费用
    private String comment;     //备注说明费用细节
    private Date payTime;       //缴费时间

}
