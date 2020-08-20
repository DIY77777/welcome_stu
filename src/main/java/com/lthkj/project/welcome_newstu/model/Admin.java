package com.lthkj.project.welcome_newstu.model;

import com.lthkj.project.welcome_newstu.vo.UserVO;
import lombok.Data;

/**
 * 管理员类
 * Created by 关 on 2020/7/22 16:36
 */
@Data
public class Admin extends UserVO {

    private Integer ID;  //管理员Id
    private String Name;    //管理员名称
    private String Password;    //管理员密码
    private String Photonumber;     //照片
    private String AdminNum;   //教职工编号也是账号
}
