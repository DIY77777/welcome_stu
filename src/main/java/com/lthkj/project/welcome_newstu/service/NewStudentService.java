package com.lthkj.project.welcome_newstu.service;

import com.lthkj.project.welcome_newstu.model.NewStudent;
import com.lthkj.project.welcome_newstu.vo.NewStudentVO;

import java.util.List;
import java.util.Map;

/**
 * 新生操作类
 * Created by 关 on 2020/7/22 16:47
 */
public interface NewStudentService {

    NewStudentVO findOne(NewStudent newStudent);

    List<NewStudentVO> getNstu();

    Integer getCount(Map<String,Object> map);

    //模糊查询和学号通过名字得到列表
    List<NewStudentVO> getOneByName(Map<String,Object> map);
}
