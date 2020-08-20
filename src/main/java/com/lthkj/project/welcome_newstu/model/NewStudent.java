package com.lthkj.project.welcome_newstu.model;

import com.lthkj.project.welcome_newstu.vo.UserVO;
import lombok.Data;

/**
 * 新生类
 * Created by 关 on 2020/7/22 16:36
 */
@Data
public class NewStudent extends UserVO {

    private String Id;  //主键ID
    private String StuName;  //学生姓名
    private String StuNumber;   //学号
    private String Telphone;    //录取通知书附带的手机号码
    private String Password;    //登录密码
    private Integer StatusId;     //新生报到的状态 0：未报到 1：网上报道成功 2：现场报道成功
    private Integer AcademyId;  //属于哪个二级学院
    private String IdcardNub;   //身份证号
    private Integer SpecialtyId;     //所报专业
    private Integer DegreeId;       //学位
    private Integer Gender;     //性别
    private String BirthPlace;  //籍贯
    private Integer RoomId;     //宿舍对应的编号
    private String Classes;     //班级
    private String Photonumber;     //照片
    private Integer LoginStatus;    //登录状态
}
