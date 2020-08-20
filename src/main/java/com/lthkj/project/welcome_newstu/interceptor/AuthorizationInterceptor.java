package com.lthkj.project.welcome_newstu.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lthkj.project.welcome_newstu.config.AuthMethod;
import com.lthkj.project.welcome_newstu.core.utils.RedisUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 *     Token鉴权拦截器
 * */
public class AuthorizationInterceptor implements HandlerInterceptor {

    //存放鉴权信息的Header名称，默认是token
    private String httpHeaderName = "token";
    //鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";
    //鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;
    //存放登录用户模型Key的Request Key
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        RedisUtil redisUtil = (RedisUtil)applicationContext.getBean("redisUtil");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.getAnnotation(AuthMethod.class) != null || handlerMethod.getBeanType().getAnnotation(AuthMethod.class) != null){
            System.out.println("已经进入到了拦截器");
            String username="";
            String token = request.getHeader(httpHeaderName);
            if (token != null && token.length() != 0) {
                username = redisUtil.getStr(token);
            }
            System.out.println(username);
            if (username != null && username.length() != 0) {
                return true;
            }else{
                System.out.println("没有权限");
                JSONObject jsonObject = new JSONObject();
                PrintWriter out = null;
                try {
                    response.setStatus(unauthorizedErrorCode);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    jsonObject.put("code", ((HttpServletResponse) response).getStatus());
                    jsonObject.put("message", HttpStatus.UNAUTHORIZED);
                    out = response.getWriter();
                    out.println(jsonObject);
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
