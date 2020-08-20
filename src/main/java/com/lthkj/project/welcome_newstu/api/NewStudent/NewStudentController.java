package com.lthkj.project.welcome_newstu.api.NewStudent;

import com.lthkj.project.welcome_newstu.api.BaseController;
import com.lthkj.project.welcome_newstu.core.model.ApiResponse;
import com.lthkj.project.welcome_newstu.core.utils.ConstantUtils;
import com.lthkj.project.welcome_newstu.model.NewStudent;
import com.lthkj.project.welcome_newstu.service.NewStudentService;
import com.lthkj.project.welcome_newstu.vo.NewStudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * NewStudent类的控制器
 * Created by 关 on 2020/7/22 17:24
 */
@RestController
@RequestMapping("/stu")
@Api(tags = "新生操作接口")
public class NewStudentController extends BaseController {


    @Autowired
    private NewStudentService newStudentService;

    //待定使用Token进行禁止多点登录
    //使用httpSession 进行禁止多点登录，待优化，可使用权限框架改写
    @PostMapping(value = "/login")
    @ApiOperation("新生登录方法")
    public ApiResponse<NewStudentVO> login(@RequestParam(value = "Telphone",required = false) String Telphone,
                                           @RequestParam(value = "StuNumber",required = false) String StuNumber,
                                           @RequestParam(value = "Password",required = true) String Password,
                                           HttpServletRequest request) {
        System.out.println(Telphone);
        System.out.println(StuNumber);
        System.out.println(Password);
        HttpSession session = request.getSession();
        NewStudent newStudent = new NewStudent();
        if(StringUtils.isNoneBlank(Telphone)){
            newStudent.setTelphone(Telphone);
        }else if(StringUtils.isNoneBlank(StuNumber)){
            newStudent.setStuNumber(StuNumber);
        }
        newStudent.setPassword(Password);
        NewStudentVO newStudentVO = newStudentService.findOne(newStudent);
        if(newStudentVO==null){
            return ApiResponse.failed("查无此人，登陆失败");
        }
        if(session.getAttribute(newStudentVO.getStuName()) != null){
            return ApiResponse.failed("用户已登录，请注意");
        }
        session.setAttribute(ConstantUtils.USER_SESSION_KEY,newStudentVO);
        return ApiResponse.success(newStudentVO);
    }

    //计算个数的方法，可添加关于新生的可选条件
    @PostMapping(value = "/getcount")
    @ApiOperation("新生总人数")
    public ApiResponse<Integer> getCount(@RequestParam(required = false) Map<String,Object> map){
        return ApiResponse.success(newStudentService.getCount(map));
    }


}
