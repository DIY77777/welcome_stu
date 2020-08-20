package com.lthkj.project.welcome_newstu.service;

import com.lthkj.project.welcome_newstu.model.Room;
import com.lthkj.project.welcome_newstu.vo.NewStudentVO;

import java.util.List;
import java.util.Map;

/**
 * 宿舍操作类
 * Created by 关 on 2020/7/28 8:53
 */
public interface RoomService {

    List<Room> getRoom(Map<String,Object> map);

    Integer addRoom(Room room);

    Integer delRoom(Integer id);

    List<NewStudentVO> getStuByRoom(String DormId);

    void StuUpdateRoom(Integer id,String nowRoom,String futureRoom);
}
