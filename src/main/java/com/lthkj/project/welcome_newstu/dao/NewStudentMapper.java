package com.lthkj.project.welcome_newstu.dao;


import com.lthkj.project.welcome_newstu.model.NewStudent;
import com.lthkj.project.welcome_newstu.vo.NewStudentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 新生类的操作类
 * NewStudent类的mybatis mapper文件
 * Created by 关 on 2020/7/22 16:36
 */
@Component
public interface NewStudentMapper {

    //得到单个实体的信息
    NewStudentVO getOne(NewStudent newStudent);

    //void updateLoginInfo(Integer id);

    List<NewStudentVO> getNstu();

    Integer getCount(Map<String,Object> map);

    //模糊查询和学号通过名字得到列表
    List<NewStudentVO> getOneByName(Map<String,Object> map);

    Integer updateStuRoomByDelectRoom(List<String> list);

    //单个新生修改宿舍
    Integer updateStuRoom(Map<String,Object> map);

    //通过宿舍号找学生
    List<NewStudentVO> getStuByRoom(@Param("DormId") String DormId);
}
