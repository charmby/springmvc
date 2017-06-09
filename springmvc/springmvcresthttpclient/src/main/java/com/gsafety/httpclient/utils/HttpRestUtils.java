package com.gsafety.httpclient.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
/**
 * @author huangll
 *
 */
public class HttpRestUtils {
	public static String post(String uri,String jsonMessage){
		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod(uri);
		try {
			StringRequestEntity entity = new StringRequestEntity(jsonMessage, "application/json", "UTF-8");
			postMethod.setRequestEntity(entity);
			httpClient.executeMethod(postMethod);
			return postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String get(String uri){
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(uri);
		try {
			httpClient.executeMethod(getMethod);
			return getMethod.getResponseBodyAsString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
