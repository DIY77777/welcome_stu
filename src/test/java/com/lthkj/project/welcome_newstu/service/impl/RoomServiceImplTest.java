package com.lthkj.project.welcome_newstu.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 关 on 2020/7/30 9:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceImplTest {

    @Test
    public void test(){
        String str = "1,2,3,4";
        String str1 = "1";
        System.out.println(Arrays.stream(str1.split(","))
                .map(s -> (s.trim()))
                .collect(Collectors.toList()));
    }

}