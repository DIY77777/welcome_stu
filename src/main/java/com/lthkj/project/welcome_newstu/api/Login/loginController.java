package com.lthkj.project.welcome_newstu.api.Login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lthkj.project.welcome_newstu.core.model.ApiResponse;
import com.lthkj.project.welcome_newstu.core.utils.ConstantUtils;
import com.lthkj.project.welcome_newstu.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 关 on 2020/8/11 15:22
 */
@Controller
public class loginController {

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/loginout")
    @ApiOperation("人员登出方法")
    @ResponseBody
    public ApiResponse<String> loginout(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute(ConstantUtils.USER_SESSION_KEY)!=null){
            session.removeAttribute(ConstantUtils.USER_SESSION_KEY);
        }else {
            return ApiResponse.failed("此用户未登录，无法退出");
        }
        return ApiResponse.success("success");
    }

    @RequestMapping(value = "/getusername",method = RequestMethod.POST)
    public void getUsername(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //先从session中获取到之前存在session中的用户信息，然后通过ObjectMapper输出返回一个json数据给html页面，由页面去解析这个json数据
        UserVO user=(UserVO)request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if(user!=null){
            ObjectMapper objectMapper=new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(),user);
        }
    }
}
