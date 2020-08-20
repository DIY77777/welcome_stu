package com.lthkj.project.welcome_newstu.dao;

import com.lthkj.project.welcome_newstu.model.Status;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 关 on 2020/8/20 16:32
 */
@Component
public interface StatusMapper {

    List<Status> getAll();

}
