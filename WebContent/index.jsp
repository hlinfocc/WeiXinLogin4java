<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();int port = request.getServerPort();
String basePath = (port==80 || port==443)?request.getScheme()+"://"+request.getServerName()+path+"/":request.getScheme()+"://"+request.getServerName()+":"+port+path+"/";
%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Author" content="呐喊">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
 </head>
 <body>
  
 </body>
</html>
