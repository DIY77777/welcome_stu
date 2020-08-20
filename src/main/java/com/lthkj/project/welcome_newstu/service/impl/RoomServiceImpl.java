package com.lthkj.project.welcome_newstu.service.impl;

import com.lthkj.project.welcome_newstu.dao.NewStudentMapper;
import com.lthkj.project.welcome_newstu.dao.RoomMapper;
import com.lthkj.project.welcome_newstu.model.Room;
import com.lthkj.project.welcome_newstu.service.RoomService;
import com.lthkj.project.welcome_newstu.vo.NewStudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 关 on 2020/7/28 8:54
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private NewStudentMapper newStudentMapper;

    @Override
    public List<Room> getRoom(Map<String, Object> map) {
        return roomMapper.getRoom(map);
    }

    @Override
    public Integer addRoom(Room room) {
        return roomMapper.addRoom(room);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Integer delRoom(Integer id) {
        Map<String,Object> map = new HashMap<>();
        map.put("RoomId",id);
        List<Room> roomlist = roomMapper.getRoom(map);
        Room room = roomlist.get(0);
        List<String> list = Arrays.stream(room.getCheckPersonId().split(","))
                .map(s -> (s.trim()))
                .collect(Collectors.toList());
        int num = roomMapper.delRoom(id);
        if(num > 0){
            newStudentMapper.updateStuRoomByDelectRoom(list);
        }
        return num;
    }

    @Override
    public List<NewStudentVO> getStuByRoom(String DormId) {
        return newStudentMapper.getStuByRoom(DormId);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void StuUpdateRoom(Integer id, String nowRoom, String futureRoom) {
        Map<String,Object> map = new HashMap<String,Object>();
        //清空map，得到room对象
        map.put("RoomId",nowRoom);
        Room room = roomMapper.getRoom(map).get(0);
        //准备删减
        List<String> list = Arrays.stream(room.getCheckPersonId().split(","))
                .map(s -> (s.trim()))
                .collect(Collectors.toList());
        list.remove(id.toString());
        String CheckPersonId = list.stream().collect(Collectors.joining(","));
        System.out.println(CheckPersonId);
        //移除本人的id,得到新的集合转为String并插入
        map.put("CheckPersonId",CheckPersonId);
        //将宿舍现住人数减一，宿舍状态修改为人数不满，
        int num2 = roomMapper.updateStuNumAndFullDel(map);
        System.out.println(num2);
        //准备增加宿舍人数
        map.clear();
        map.put("RoomId",futureRoom);
        Room room1 = roomMapper.getRoom(map).get(0);
        if((room1.getRoomCount()+1)==room1.getRoomSum()){
            map.put("RoomFull",1);
        }
        List<String> list_add = Arrays.stream(room1.getCheckPersonId().split(","))
                .map(s -> (s.trim()))
                .collect(Collectors.toList());
        list_add.add(id.toString());
        String CheckPersonId_add = list_add.stream().collect(Collectors.joining(","));
        map.put("CheckPersonId",CheckPersonId_add);
        int num3 = roomMapper.updateStuNumAndFullAdd(map);
        System.out.println(num3);

        //修改学生表的数据
        map.clear();
        map.put("id",id);
        map.put("RoomId",futureRoom);
        Integer num = newStudentMapper.updateStuRoom(map);
        System.out.println(num);
    }

}
