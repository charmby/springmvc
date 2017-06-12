package com.gsafety.httpclient.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import com.gsafety.httpclient.utils.HttpRestUtils;
@RestController
@RequestMapping("/httpclient")
@Api(value = "使用httpclient进行调用", description = "有关于httpclient管理的操作", position = 1)  
public class MsgRestControllerTest {

	@ApiOperation(value = "获得所有用户信息", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/testPostMethod", method = RequestMethod.POST, produces = "application/json")
	public String testPostMethod(){
		/*        RealTimeMsg msg = new RealTimeMsg();
        msg.setFrom("001");*/
		Map<String,String> map = new HashMap<String,String>();
		map.put("client_id", "mobile");
		map.put("client_secret", "mobile");
		map.put("grant_type", "password");
		map.put("scope", "read");
		map.put("username", "test");
		map.put("password", "test");

		/*   ?client_id=test&client_secret=test&grant_type=password&scope=read write&username=test&password=test*/
		String resp = HttpRestUtils.post("http://localhost:8080/authz/oauth/token", JSON.toJSONString(map));
		return resp;
	}

	@ApiOperation(value = "使用其他方式连接zzl", httpMethod = "post", produces = "application/json")
	@ApiResponse(code = 200, message = "success")
	@ResponseBody
	@RequestMapping(value = "/testzzlPost", method = RequestMethod.POST, produces = "application/json")
	public void testzzlPost(){

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