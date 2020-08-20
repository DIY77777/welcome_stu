package com.lthkj.project.welcome_newstu.vo;

import com.lthkj.project.welcome_newstu.model.Room;
import lombok.Data;

/**
 * 与控制器返回有关的具体数据，将数值类型转变为文字
 *  继承实体类，不去修改与数据库打交道的本类，
 *   使用本类进行页面的传值
 * Created by 关 on 2020/8/1 11:20
 */
@Data
public class RoomVO extends Room {
    private String AcademyName;
    private String SpecialtyName;
    private String DegreeName;
}
