package com.gsafety.httpclient.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
 

/**
 * @author huangll
 *
 */
public class HttpRestUtils {
	 private static final Logger LOG = LoggerFactory.getLogger(HttpRestUtils.class);
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

	 /**
     * Rest的Post请求处理。
     * 注意：
     * 1、rest的method必须是post类型的请求
     * 2、 请求连接的超时时间为15000毫秒，超时后报错
     * 3、url中必须是请求的全部路径：
     *   例如：http://localhost:8080/cloudframework/sys/usermanager/usermnt/greeting.mvc
     * 4、post的传递参数，必须在nameValuePairList中构造
     *   例如：List <NameValuePair> nvps = new ArrayList <NameValuePair>();
     *      nvps.add(new BasicNameValuePair("client_id", "mobile"));
     *      nvps.add(new BasicNameValuePair("client_secret", "mobile"));
     *      nvps.add(new BasicNameValuePair("grant_type", "password"));
     *      nvps.add(new BasicNameValuePair("scope", "read"));
     *      nvps.add(new BasicNameValuePair("username", "test"));
     *      nvps.add(new BasicNameValuePair("password", "test"));
     * @param url rest请求地址
     * @param nvps  post请求参数
     */
    public static   JsonObject getResMsgPostMethod(String url,List <NameValuePair> nameValuePairList ){
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
        HttpConnectionParams.setSoTimeout(httpParams, 15000);
        CloseableHttpClient httpclient =    new DefaultHttpClient(httpParams);
        JsonObject object = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                LOG.debug(response.getStatusLine().toString());
                HttpEntity entity2 = response.getEntity();
                if (entity2 != null) { 
                    LOG.debug("Response content length(响应内容长度  ): " + entity2.getContentLength());
                    ContentType contentType = ContentType.get(entity2);
                    LOG.debug("Mime Type: " + contentType.getMimeType());
                    if(contentType.toString().equalsIgnoreCase(ContentType.APPLICATION_JSON.toString())){
                        String content = EntityUtils.toString(entity2);
                        LOG.debug("Response content(返回内容): " + content);
                        /*JsonParser*/
                        JsonParser parser=new JsonParser();  //创建JSON解析器
                         object=(JsonObject) parser.parse(content);  //创建JsonObject对象
                        return object;
                    }
                } 
 
            } finally {
                response.close();
 
            }
        } catch (UnsupportedEncodingException e) {
            object.addProperty("msg", e.getMessage());
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            object.addProperty("msg", e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            object.addProperty("msg", e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return object;
    }
 
    /**
     * Get方法调用
     * 注意：
     * 1、 调用的方法必须是Get请求
     * 2、 注意调用的url的返回值必须是json类型数据。
     * 3、 请求连接的超时时间为15000毫秒，超时后报错
     * @param url rest请求的url。url中必须携带参数
     * @return  JsonObject
     */
    public static   JsonObject getResMsgByGetMethod(String url){
         
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
        HttpConnectionParams.setSoTimeout(httpParams, 15000);
        DefaultHttpClient client = new DefaultHttpClient(httpParams);
        JsonObject object = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = client.execute(httpGet);
            try {
                HttpEntity entity2 = response.getEntity();
                if (entity2 != null) { 
                    LOG.debug("Response content length（打印响应内容长度    ）: " + entity2.getContentLength());
                    ContentType contentType = ContentType.get(entity2);
                    LOG.debug("Mime Type: " + contentType.getMimeType());
                    if(contentType.toString().equalsIgnoreCase(ContentType.APPLICATION_JSON.toString())){
                        String content = EntityUtils.toString(entity2);
                        LOG.debug("Response content: " + content);
                        JsonParser parser=new JsonParser();  //创建JSON解析器
                         object=(JsonObject) parser.parse(content);  //创建JsonObject对象
                        return object;
                    }
                } 
 
            }
            finally {
                response.close();
 
            }
        } catch (UnsupportedEncodingException e) {
            object.addProperty("msg", e.getMessage());
            e.printStackTrace();
             
        } catch (ClientProtocolException e) {
            object.addProperty("msg", e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            object.addProperty("msg", e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
             
        }
        return object;
    }
 
	


}
