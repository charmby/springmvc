package com.gsafety;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException
    {
    	
    	
    	URL url = new URL("http://www.sojson.com/yasuoyihang.html");
    	String domain = url.getHost();
    	System.out.println("域名：" + domain);
        System.out.println( "Hello World!" );
    }
}
