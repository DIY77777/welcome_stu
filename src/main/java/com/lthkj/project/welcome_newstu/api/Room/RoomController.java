package com.lthkj.project.welcome_newstu.api.Room;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lthkj.project.welcome_newstu.core.model.ApiResponse;
import com.lthkj.project.welcome_newstu.model.Room;
import com.lthkj.project.welcome_newstu.service.RoomService;
import com.lthkj.project.welcome_newstu.vo.NewStudentVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/7/28 9:27
 */
@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/getroom")
    @ApiOperation("查询宿舍接口并接收参数进行带有条件的查询")
    @ResponseBody
    public ApiResponse<List<Room>> getAll(@RequestParam(required = false) Map<String,Object> obj){
        return ApiResponse.success(roomService.getRoom(obj));
    }

    @PostMapping("/addroom")
    @ApiOperation("增加宿舍接口")
    @ResponseBody
    public ApiResponse<Integer> add(@RequestBody String str) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Room room = mapper.readValue(str,Room.class);
        return ApiResponse.success(roomService.addRoom(room));
    }

    @PostMapping("/del")
    @ApiOperation("删除宿舍接口，并清空宿舍人数")
    @ResponseBody
    public ApiResponse<String> delRoom(@RequestParam("id") String id){
        int num = roomService.delRoom(Integer.parseInt(id));
        if(num > 0){
            return ApiResponse.success("删除宿舍并清空宿舍人数成功！");
        }
        return ApiResponse.failed("出错了，稍等");
    }

    @PostMapping("/getStuByDorm")
    @ApiOperation("查询宿舍返回宿舍的学生信息")
    @ResponseBody
    public ApiResponse<NewStudentVO> getStuByDorm(@RequestParam("DormId") String DormId){
        return ApiResponse.success(roomService.getStuByRoom(DormId));
    }


    @PostMapping("/updateRoom")
    @ApiOperation("删除宿舍接口，并清空宿舍人数")
    @ResponseBody
    public ApiResponse<String> updateroom(@RequestParam("id") String id,
                                          @RequestParam("nowRoom") String nowRoom,
                                          @RequestParam("futureRoom") String futureRoom){
        roomService.StuUpdateRoom(Integer.parseInt(id),nowRoom,futureRoom);
        return ApiResponse.success("success");
    }

}
