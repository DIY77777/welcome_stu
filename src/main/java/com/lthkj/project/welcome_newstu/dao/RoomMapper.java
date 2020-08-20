package com.lthkj.project.welcome_newstu.dao;

import com.lthkj.project.welcome_newstu.model.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/7/28 8:52
 */
@Component
public interface RoomMapper {

    List<Room> getRoom(Map<String,Object> map);

    Integer addRoom(Room room);

    Integer delRoom(@Param("RoomId") Integer id);

    //通过宿舍ID将宿舍人数减一，并修改宿舍满员状态
    Integer updateStuNumAndFullDel(Map<String,Object> map);

    //通过宿舍ID将宿舍人数加一，并修改宿舍欠员状态
    Integer updateStuNumAndFullAdd(Map<String,Object> map);

}
