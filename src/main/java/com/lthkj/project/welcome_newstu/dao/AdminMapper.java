package com.lthkj.project.welcome_newstu.dao;

import com.lthkj.project.welcome_newstu.model.Admin;
import com.lthkj.project.welcome_newstu.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 管理员类的操作文件
 * Admin类的mybatis mapper文件
 * Created by 关 on 2020/7/24 14:19
 */
@Component
public interface AdminMapper {

    Admin getOne(Admin admin);

}
