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
<link rel="stylesheet" id="s_superplus_css_lnk" type="text/css" href="blue/css/index.css">
</head>
<body>
	<h2>Hello World!</h2>
</body>
</html>
