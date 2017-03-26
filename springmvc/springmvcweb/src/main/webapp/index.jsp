<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String contextPath = "http://"+request.getRemoteHost()+":"+request.getRemotePort()+request.getContextPath();
	System.out.println(contextPath);
%>
<link style="text/css" charset="utf-8" href="base/css/base.css">
<link rel="stylesheet" id="s_superplus_css_lnk2" type="text/css" href="green/css/index.css">
<!-- <link rel="stylesheet" id="s_superplus_css_lnk" type="text/css" href="blue/css/index.css">  一直访问，不到静态文档。不访问web-inf下的内容 -->
</head>
<body>
	<h2>Hello World!</h2>
</body>
</html>
