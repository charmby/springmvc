package com.gsafety.httpclient.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;










import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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


	public static   void zzlPost(){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost("http://localhost:8080/authz/oauth/token");
			List <NameValuePair> nvps = new ArrayList <NameValuePair>();
			nvps.add(new BasicNameValuePair("client_id", "mobile"));
			nvps.add(new BasicNameValuePair("client_secret", "mobile"));

			nvps.add(new BasicNameValuePair("grant_type", "password"));

			nvps.add(new BasicNameValuePair("scope", "read"));
			nvps.add(new BasicNameValuePair("username", "test"));
			nvps.add(new BasicNameValuePair("password", "test"));

			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			CloseableHttpResponse response2 = httpclient.execute(httpPost);


			try {
				System.out.println(response2.getStatusLine());
				HttpEntity entity2 = response2.getEntity();
				// do something useful with the response body
				// and ensure it is fully consumed
				//EntityUtils.consume(entity2);

				if (entity2 != null) {  
					// 打印响应内容长度    
					System.out.println("Response content length: " + entity2.getContentLength());  
					// 打印响应内容    
					//System.out.println("Response content: " + EntityUtils.toString(entity2));  


					ContentType contentType = ContentType.get(entity2);
					System.out.println("Mime Type: " + contentType.getMimeType());

					if(contentType.toString().equalsIgnoreCase(ContentType.APPLICATION_JSON.toString())){
						//HttpClientTest test = new HttpClientTest();
						String content = EntityUtils.toString(entity2);
						//test.toString(entity2,contentType);
						System.out.println("Response content: " + content);

						Object obp =   JSON.parse(content);
						Object object2 =   JSON.toJSON(content);
						/*JsonParser*/
						JsonParser parser=new JsonParser();  //创建JSON解析器
						JsonObject object=(JsonObject) parser.parse(content);  //创建JsonObject对象

						System.out.println("-------------------------------------------------------"); //将json数据转为为String型的数据

						System.out.println("access_token="+object.get("access_token").getAsString()); //将json数据转为为String型的数据
						System.out.println("refresh_token="+object.get("refresh_token").getAsString()); //将json数据转为为String型的数据
						System.out.println("token_type="+object.get("token_type").getAsString()); //将json数据转为为String型的数据
						System.out.println("expires_in="+object.get("expires_in").getAsLong()); //将json数据转为为String型的数据                      
					}

				}  

			} finally {
				response2.close();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}}
