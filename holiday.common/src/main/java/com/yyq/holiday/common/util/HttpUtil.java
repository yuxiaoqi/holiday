package com.yyq.holiday.common.util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName:
 * @Description:
 * @Author yuyanqi
 * @Create 2017/6/29 0029 下午 5:46
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static HttpUtil instance;

    public static HttpUtil getInstance() {
        if (null == instance) return new HttpUtil();
        return instance;
    }

    public String doRequestPostString(String reqStr, String uri) {
        HttpClient httpClient = HttpClientFactory.getThreadSafeHttpClient();
        HttpPost httpPost = new HttpPost(StringUtils.trim(uri));
        httpPost.setHeader(HTTP.USER_AGENT, "httpcomponents");
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        HttpResponse response = null;
        HttpEntity entity = null;
        StringEntity stringEntiry = null;
        try {
            stringEntiry = new StringEntity(reqStr, "utf-8");
            httpPost.setEntity(stringEntiry);
            response = httpClient.execute(httpPost);
            int status = response.getStatusLine().getStatusCode();
            // 获取响应内容
            String retData = null;
            if (null != response) {
                entity = response.getEntity();
                retData = StringEscapeUtils.unescapeJava(StringUtils.trim(EntityUtils.toString(entity, "utf-8")));
            }
            if (HttpStatus.SC_OK == status) { // 请求成功
                return retData;
            }
        } catch (Exception e) { // 读取响应错误
            logger.error("读取响应错误！",e);
        } finally {
            try {
                if (null != stringEntiry)
                    EntityUtils.consume(stringEntiry);
                httpPost.abort(); // 释放连接资源
            } catch (Exception e) {
                logger.error("释放连接资源！",e);
            }
        }
        return "error";
    }
}
