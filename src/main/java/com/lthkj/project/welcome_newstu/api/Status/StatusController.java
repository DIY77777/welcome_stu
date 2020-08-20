package com.lthkj.project.welcome_newstu.api.Status;

import com.lthkj.project.welcome_newstu.core.model.ApiResponse;
import com.lthkj.project.welcome_newstu.model.Status;
import com.lthkj.project.welcome_newstu.service.StatusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 关 on 2020/8/20 17:01
 */
@RequestMapping("/Status")
@Controller
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping(value = "/getStatusInfo")
    @ApiOperation("得到状态信息")
    @ResponseBody
    public ApiResponse<Status> getSpecialDegree(){
        return ApiResponse.success(statusService.getAll());
    }
}
