package com.yyq.holiday.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ArmsLogUtil {

    private static final Logger armslogger = LoggerFactory.getLogger("arms_log");

    public void track(String eventName, Map<String, Object> properties) {
        try {
            if (null == properties) {
                properties = new HashMap<String, Object>();
            }
            Map<String, Object> propertiesMap = new HashMap<String, Object>();
//            propertiesMap.put("createtime", DateUtil.getDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            propertiesMap.put("eventName", eventName);
            propertiesMap.put("capital", properties.containsKey("capital") ? properties.get("capital") : "0");
            propertiesMap.put("message", properties.containsKey("message") ? properties.get("message") : "");

//            armslogger.info(JSON.toJSONString(propertiesMap));
        } catch (Exception e) {

        }
    }
}