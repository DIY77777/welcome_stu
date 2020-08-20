package com.lthkj.project.welcome_newstu.api.Academy;

import com.lthkj.project.welcome_newstu.core.model.ApiResponse;
import com.lthkj.project.welcome_newstu.service.AcademyService;
import com.lthkj.project.welcome_newstu.vo.AcademyVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 关 on 2020/8/19 15:48
 */
@RequestMapping("/Academy")
@Controller
public class AcademyController {

    @Autowired
    private AcademyService academyService;

    @PostMapping(value = "/getSeachInfo")
    @ApiOperation("得到院系信息")
    @ResponseBody
    public ApiResponse<AcademyVo> getSeachInfo(Map<String,Object> map){
        return ApiResponse.success(academyService.getAllAcademy(map));
    }
}
