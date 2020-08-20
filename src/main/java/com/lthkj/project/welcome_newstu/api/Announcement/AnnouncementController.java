package com.lthkj.project.welcome_newstu.api.Announcement;

import com.lthkj.project.welcome_newstu.core.model.ApiResponse;
import com.lthkj.project.welcome_newstu.model.Announcement;
import com.lthkj.project.welcome_newstu.service.AnnouncementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 关 on 2020/7/30 17:42
 */
@RequestMapping("/announcement")
@Controller
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("/getroom")
    @ApiOperation("查询所有的新闻")
    @ResponseBody
    public ApiResponse<List<Announcement>> getAll(){
        return ApiResponse.success(announcementService.getAllAnnouncement());
    }

    @GetMapping("/add")
    @ApiOperation("增加新闻")
    @ResponseBody
    public ApiResponse<String> add(@RequestBody Announcement announcement){
        return ApiResponse.success(announcementService.addAnnouncement(announcement));
    }

    @GetMapping("/del")
    @ApiOperation("删除新闻")
    @ResponseBody
    public ApiResponse<String> del(@RequestParam("id") String id){
        return ApiResponse.success(announcementService.delAnnouncement(Integer.parseInt(id)));
    }


}
