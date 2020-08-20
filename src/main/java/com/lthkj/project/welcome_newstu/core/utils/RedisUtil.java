package com.lthkj.project.welcome_newstu.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;

    /**
     * 根据指定key获取String
     *
     * @param key
     * @return
     */
    public String getStr(String key) {
        return valOpsStr.get(key);
    }

    /**
     * 设置Str缓存
     *
     * @param key
     * @param val
     */
    public void setStr(String key, String val) {
        valOpsStr.set(key, val);
    }

    /**
     * 设置Str缓存（带有失效时间的keyvalue）
     *
     * @param key
     * @param val
     */
    public void setStr(String key, String val,long timeout,TimeUnit timeUnit) {
        valOpsStr.set(key, val,timeout,timeUnit);
    }

    /*
     *设置key的失效时间
     * */
    public void expireStr(String o1){
        valOpsObj.getOperations().expire(o1,ConstantKit.TOKEN_EXPIRE_TIME,TimeUnit.SECONDS);
    }

    /**
     * 删除指定key
     *
     * @param key
     */
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据指定o获取Object
     *
     * @param o
     * @return
     */
    public Object getObj(Object o) {
        return valOpsObj.get(o);
    }

    /**
     * 设置obj缓存
     *
     * @param o1
     * @param o2
     */
    public void setObj(Object o1, Object o2) {
        valOpsObj.set(o1, o2);
    }

    /*
    *设置key的失效时间
    * */
    public void expireObj(Object o1){
        valOpsObj.getOperations().expire(o1,ConstantKit.TOKEN_EXPIRE_TIME,TimeUnit.SECONDS);
    }

    /**
     * 删除Obj缓存
     *
     * @param o
     */
    public void delObj(Object o) {
        redisTemplate.delete(o);
    }
}
