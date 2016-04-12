<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'index.jsp' starting page</title>
    
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
   <h3>显示商品信息</h3>
  <!-- items属性是即将遍历的值，可以是集合，数组等；var属性是当前遍历对象的保存结果 -->
  <table border="1" cellspacing="0px">
  <tr>
  	<th>名称</th>
  	<th>数量</th>
  	<th>价格</th>
  	<th></th>
  	<th></th>
  </tr>
  <c:forEach items="${requestScope.good }" var="good">
  	<tr>
  		<td>${good.name }</td>
  		<td>${good.count }</td>
  		<td>${good.price }</td>
  		<td><a href="lib/update.jsp?name=${good.name }&&count=${good.count }&&price=${good.price }">修改</a></td>
  		<td><a href="deleteServlet?name=${good.name }">删除</a></td>
  	</tr>	
  </c:forEach>
  </table>
   
</html>
