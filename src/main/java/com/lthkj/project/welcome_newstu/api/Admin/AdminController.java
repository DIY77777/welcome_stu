package com.lthkj.project.welcome_newstu.api.Admin;

import com.lthkj.project.welcome_newstu.core.model.ApiResponse;
import com.lthkj.project.welcome_newstu.core.utils.ConstantUtils;
import com.lthkj.project.welcome_newstu.model.Admin;
import com.lthkj.project.welcome_newstu.service.AdminService;
import com.lthkj.project.welcome_newstu.service.NewStudentService;
import com.lthkj.project.welcome_newstu.vo.NewStudentVO;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/7/27 11:26
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private NewStudentService newStudentService;

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/selectAll")
    @ApiOperation("管理页查看所有的新生信息")
    @ResponseBody
    public ApiResponse<List<NewStudentVO>> getAllNStu(){
        return ApiResponse.success(newStudentService.getNstu());
    }

    @PostMapping(value = "/selectCount")
    @ApiOperation("管理页查看各种分类的新生统计人数")
    @ResponseBody
    public ApiResponse<Integer> getCount(@RequestParam Map<String,Object> obj){
        return ApiResponse.success(newStudentService.getCount(obj));
    }

    //待定使用Token进行禁止多点登录
    //使用httpSession 进行禁止多点登录，待优化，可使用权限框架改写
    @PostMapping(value = "/login")
    @ApiOperation("后台登录页面")
    public String login(@RequestParam(value = "adminname",required = true) String Name,
                                           @RequestParam(value = "adminpwd",required = true) String Password,
                                           @NotNull HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = new Admin();
        admin.setAdminNum(Name);
        admin.setPassword(Password);
        admin = adminService.findOne(admin);
        if(admin==null){
            return "查无此人，请重新登录";
        }
        if(session.getAttribute(admin.getName()) != null){
            return "用户已登录，请注意";
        }
        session.setAttribute(ConstantUtils.USER_SESSION_KEY,admin);
        return "index";
    }

    @GetMapping("/getstuBySeach")
    @ApiOperation("查询指定学号和查询模糊名称的学生")
    @ResponseBody
    public ApiResponse<List<NewStudentVO>> getStuByStuname(@RequestParam(value = "StuName",required = false) String StuName,
                                                           @RequestParam(value = "StuNumber",required = false) String StuNumber,
                                                           @RequestParam(value = "StatusId",required = false) String StatusId,
                                                           @RequestParam(value = "AcademyId",required = false) String AcademyId,
                                                           @RequestParam(value = "SpecialtyId",required = false) String SpecialtyId,
                                                           @RequestParam(value = "DegreeId",required = false) String DegreeId,
                                                           @RequestParam(value = "Gender",required = false) String Gender){
        Map<String,Object> map = new HashMap<String, Object>();
        if(StringUtils.isNoneBlank(StuName)){
            map.put("StuName",StuName);
        }if(StringUtils.isNoneBlank(StuNumber)){
            map.put("StuNumber",StuNumber);
        }if(StringUtils.isNoneBlank(StatusId)){
            map.put("StatusId",StatusId);
        }if(StringUtils.isNoneBlank(AcademyId)){
            map.put("AcademyId",AcademyId);
        }if(StringUtils.isNoneBlank(SpecialtyId)){
            map.put("SpecialtyId",SpecialtyId);
        }if(StringUtils.isNoneBlank(DegreeId)){
            map.put("DegreeId",DegreeId);
        }if(StringUtils.isNoneBlank(Gender)){
            map.put("Gender",Gender);
        }
        System.out.println(map.size());
        return  ApiResponse.success(newStudentService.getOneByName(map));
    }

    @GetMapping(value = "/message.html")
    @ApiOperation("学生信息页跳转")
    public String message(){
        return "message";
    }

    @GetMapping(value = "/index.html")
    @ApiOperation("首页跳转")
    public String index(){
        return "index";
    }
}
