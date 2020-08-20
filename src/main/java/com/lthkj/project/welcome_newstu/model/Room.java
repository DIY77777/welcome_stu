package com.lthkj.project.welcome_newstu.model;

import lombok.Data;

/**
 * 宿舍类
 * Created by 关 on 2020/7/22 16:36
 */
@Data
public class Room {

    private Integer RoomId;  //宿舍ID
    private String DormId;  //宿舍号
    private Integer RoomSum;     //宿舍如今的入住人数
    private Integer AcademyId;   //与学院表关联
    private Integer RoomFull;    //是否住满：0为未住满，1为已住满
    private Integer RoomCount;   //宿舍能住几个人，也就是几人间
    private Integer RoomType;   //宿舍类型，区分男女宿舍
    private Integer RoomBuildingId;   //宿舍能住几个人，也就是几人间
    private String CheckPersonId;  //宿舍入住新生ID集合
    private Integer SpecialtyId;     //所报专业
    private Integer DegreeId;       //学位
    private String Classes;     //班级
}
