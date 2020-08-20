package com.lthkj.project.welcome_newstu.service.impl;

import com.lthkj.project.welcome_newstu.dao.AnnouncementMapper;
import com.lthkj.project.welcome_newstu.model.Announcement;
import com.lthkj.project.welcome_newstu.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 关 on 2020/7/30 17:41
 */
@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> getAllAnnouncement() {
        return announcementMapper.getAllAnnouncement();
    }

    @Override
    public Integer addAnnouncement(Announcement announcement) {
        return announcementMapper.addAnnouncement(announcement);
    }

    @Override
    public Integer delAnnouncement(Integer id) {
        return announcementMapper.delAnnouncement(id);
    }
}
