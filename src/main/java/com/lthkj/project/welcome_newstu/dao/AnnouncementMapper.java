package com.lthkj.project.welcome_newstu.dao;

import com.lthkj.project.welcome_newstu.model.Announcement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 关 on 2020/7/30 16:32
 */
@Component
public interface AnnouncementMapper {

    List<Announcement> getAllAnnouncement();

    Integer addAnnouncement(Announcement announcement);

    Integer delAnnouncement(@Param("id") Integer id);

}
