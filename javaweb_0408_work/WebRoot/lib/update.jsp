<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <jsp:useBean id="good" class="com.zzia.model.Good"></jsp:useBean>
   名称：${param.name }<br/>
   数量：${param.count }<br/>
   价格：${param.price }<br/><hr/>
   <form action="/javaweb_0408_work/updateServlet?updataName=${param.name }" method="post">
   	名称：<input type="text" name="name" value="${param.name }"><br/>
   	数量：<input type="text" name="count" value="${param.count }"><br/>
   	价格：<input type="text" name="price" value="${param.price }"><br/>
   	<input type="submit" value="提交">
   </form>
  </body>
</html>
