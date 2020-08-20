package com.lthkj.project.welcome_newstu.service;

import com.lthkj.project.welcome_newstu.model.Announcement;

import java.util.List;

/**
 * 新闻公告操作类
 * Created by 关 on 2020/7/30 17:40
 */
public interface AnnouncementService {

    List<Announcement> getAllAnnouncement();

    Integer addAnnouncement(Announcement announcement);

    Integer delAnnouncement(Integer id);
}
