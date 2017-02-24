package com.yyq.holiday.common.component;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;

/**
 * Created by echo on 15-8-27.
 */
@Component
public class JedisComponent {

    private static final Logger log = LoggerFactory.getLogger(JedisComponent.class);

    public static final Integer SECONDS = 60;

    @Value("${yyq.session.redis.config}")
    private String redisConfig;

    public Jedis getJedis() {
        if (StringUtils.isBlank(redisConfig))
            throw new RuntimeException("redis config can not be  null.");
//        String[] tempArray = redisConfig.split("\\:");
//            for (String str : tempArray) {
//            if (StringUtils.isBlank(str))
//                throw new RuntimeException("redis config format error. ");
//            if (tempArray.length < 3)
//                throw new RuntimeException("redis config format error. ");
//        }
        Jedis jedis = new Jedis(redisConfig);//redis服务器的ip和端口
//        jedis.auth(tempArray[2]);//连接redis的密码
        if(!jedis.isConnected()){
            throw new RuntimeException("redis connected error. ");
        }
        return jedis;
    }

    public Boolean delKey(String key){
        Jedis jedis = getJedis();
        return jedis.del(key) == 1L ? Boolean.TRUE : Boolean.FALSE;//删除key
    }

    public Boolean isExist(String key){
        Jedis jedis = getJedis();
        return jedis.exists(key);
    }


    //多个key 逗号连接
    public Boolean addKeys(String keys,String model,Integer userId){
        Jedis jedis = getJedis();
        List<String> keyList = Arrays.asList(keys.split(","));
        for(String key : keyList){
            if(jedis.exists(model+"_"+key)){
                return Boolean.FALSE;
            }
        }
        for(String key : keyList){
            jedis.set(model+"_"+key,userId.toString());
        }
        for(String key : keyList){
            if(jedis.exists(model+"_"+key)){
                System.out.println(model+"_"+key+"的Value："+jedis.get(model+"_"+key));
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public Boolean add(String key,String model,String value){
        Jedis jedis = getJedis();
        if(jedis.setnx(model+"_"+key,value) == 1){
            jedis.expire(model+"_"+key,SECONDS);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean add(String key,String model,String value,int seconds){
        Jedis jedis = getJedis();
        if(jedis.setnx(model+"_"+key,value) == 1){
            jedis.expire(model+"_"+key,seconds);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public String get(String key){
        Jedis jedis = getJedis();
        return jedis.get(key);
    }





}
