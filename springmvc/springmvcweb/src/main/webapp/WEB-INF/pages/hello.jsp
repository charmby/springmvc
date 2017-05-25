<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String contextPath = "http://"+request.getRemoteHost()+":"+request.getRemotePort()+request.getContextPath();
System.out.println(contextPath);
%>
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript" src="jqueryui/jquery-ui.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" id="s_superplus" type="text/css" href="jqueryui/jquery-ui.css">
<link rel="stylesheet" id="s_superplus" type="text/css" href="bootstrap/css/bootstrap.css">
<link href="font/font-awesome.css" rel="stylesheet" type="text/css">
<link href="font/font-awesome-ie7.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" id="s_superplus_css_lnk2" type="text/css" href="green/css/index.css">
<!-- <link rel="stylesheet" id="s_superplus_css_lnk" type="text/css" href="blue/css/index.css">  一直访问，不到静态文档。不访问web-inf下的内容 -->

<title>hello</title>
</head>
<body>
   <div class="icon-ok">我是测试信息！</div>
	<h1>Message : ${message}</h1>
	<h2>当前时间:${date}</h2>
</body>
</html>