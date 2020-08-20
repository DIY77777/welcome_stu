package com.lthkj.project.welcome_newstu.core.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


@Component
public class Md5TokenGenerator implements TokenGenerator {

    //利用多个字符串生成token并进行md5加密（时间戳）
    @Override
    public String generate(String... strings) {
        long timestamp = System.currentTimeMillis();
        String tokenMeta = "";
        for (String s : strings) {
            tokenMeta = tokenMeta + s;
        }
        tokenMeta = tokenMeta + timestamp;
        String token = DigestUtils.md5DigestAsHex(tokenMeta.getBytes());
        return token;
    }
}
