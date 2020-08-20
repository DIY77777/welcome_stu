package com.lthkj.project.welcome_newstu.service.impl;

import com.lthkj.project.welcome_newstu.dao.NewStudentMapper;
import com.lthkj.project.welcome_newstu.model.NewStudent;
import com.lthkj.project.welcome_newstu.service.NewStudentService;
import com.lthkj.project.welcome_newstu.vo.NewStudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 关 on 2020/7/22 16:51
 */
@Service("newStudentService")
public class NewStudentServiceImpl implements NewStudentService {

    @Autowired
    private NewStudentMapper newStudentMapper;

    @Override
    public NewStudentVO findOne(NewStudent newStudent) {
        return newStudentMapper.getOne(newStudent);
    }

    @Override
    public List<NewStudentVO> getNstu() {
        return newStudentMapper.getNstu();
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return newStudentMapper.getCount(map);
    }

    @Override
    public List<NewStudentVO> getOneByName(Map<String, Object> map) {
        return newStudentMapper.getOneByName(map);
    }
}
