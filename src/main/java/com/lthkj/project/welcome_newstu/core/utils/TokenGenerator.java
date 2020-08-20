package com.lthkj.project.welcome_newstu.core.utils;

import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {

    public String generate(String... strings);

}
