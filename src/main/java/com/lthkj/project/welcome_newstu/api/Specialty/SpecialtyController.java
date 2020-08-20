package com.lthkj.project.welcome_newstu.api.Specialty;

import com.lthkj.project.welcome_newstu.core.model.ApiResponse;
import com.lthkj.project.welcome_newstu.service.SpecialtyService;
import com.lthkj.project.welcome_newstu.vo.ClassesVo;
import com.lthkj.project.welcome_newstu.vo.SpecialtyDegreeVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/8/19 17:43
 */
@RequestMapping("/Specialty")
@Controller
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @PostMapping(value = "/getSeachInfo")
    @ApiOperation("得到专业学位信息")
    @ResponseBody
    public ApiResponse<SpecialtyDegreeVo> getSpecialDegree(@RequestParam("AcademyId") String AcademyId ){
        return ApiResponse.success(specialtyService.getAllSpecialty(AcademyId));
    }

    @PostMapping(value = "/getSeachClasses")
    @ApiOperation("得到班级信息")
    @ResponseBody
    public ApiResponse<List<ClassesVo>> getClasses(@RequestParam("AcademyId") String AcademyId,
                                                  @RequestParam("SpecialtyId") String SpecialtyId){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNoneBlank(AcademyId)){
            map.put("AcademyId",AcademyId);
        }
        if(StringUtils.isNoneBlank(SpecialtyId)){
            map.put("SpecialtyId",SpecialtyId);
        }
        if(map==null||map.size()==0){
            throw new RuntimeException("为空");
        }
        for(ClassesVo classesVo:specialtyService.getClasses(map)){
            System.out.println(classesVo.getClasses());
        }
        return ApiResponse.success(specialtyService.getClasses(map));
    }


}
