package com.lthkj.project.welcome_newstu.model;

import lombok.Data;

/**
 * 新闻类
 * Created by 关 on 2020/7/30 16:01
 */
@Data
public class Announcement {
    private Integer AnnouncementId;
    private Integer AnnouncementTitle;
    private Integer AnnouncementContent;
    private Integer AnnouncementDate;
}
