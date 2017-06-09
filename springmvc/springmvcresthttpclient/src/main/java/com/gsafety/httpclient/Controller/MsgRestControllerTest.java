package com.gsafety.httpclient.Controller;

import io.swagger.annotations.Api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.gsafety.httpclient.po.RealTimeMsg;
import com.gsafety.httpclient.utils.HttpRestUtils;
 @RestController
 @RequestMapping("/user")
 @Api(value = "使用httpclient进行调用", description = "有关于用户管理的操作", position = 1)  
public class MsgRestControllerTest {
 
    @Test
    public void testPushRealTimeMsg(){
        RealTimeMsg msg = new RealTimeMsg();
        msg.setFrom("001");
        Map map = new HashMap<String,String>();
        map.put("client_id", "test");
        map.put("client_secret", "test");
        map.put("grant_type", "password");
        map.put("scope", "read");
        map.put("username", "test");
        map.put("password", "test");
        
     /*   ?client_id=test&client_secret=test&grant_type=password&scope=read write&username=test&password=test*/
        String resp = HttpRestUtils.post("http://localhost:8080/authz/oauth/token", JSON.toJSONString(map));
        System.out.println(resp);
    }
     
    @Test
    public void testPushScheduledMsg(){
      
 /*       String resp = HttpRestUtils.post("http://localhost:6080/cloud-push-server/realTimeMessage", JSONUtil.toJSONString(msg));
        System.out.println(resp);*/
    }
     
    @Test
    public void testCancelMsg(){
        String resp = HttpRestUtils.get("http://localhost:6080/cloud-push-server/cancelMsg/09876000");
        System.out.println(resp);
    }
     
     
    @Test
    public void test() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.parse("2099-12-31").getTime());
    }
}