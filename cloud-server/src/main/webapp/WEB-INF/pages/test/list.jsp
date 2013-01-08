<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../share/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<style type="text/css">
 table{
   width: 80%;
 }
 
 table tr{
  background-color: #ccc;
 }
</style>
</head>
<body>
 <table border='1' cellspacing="0" bordercolorlight="#333" bordercolordark="#efefef">
  <thead>
   <tr>
    <td>ID</td>
    <td>project name</td>
    <td>project version</td>
   </tr>
  </thead>
  <tbody>
   <c:if test='${not empty list}'>
    <c:forEach items='${list}' var='item'>
     <tr>
      <td>${item.id}</td>
      <td>${item.projectName}</td>
      <td>${item.projectVersion}</td>
     </tr>
    </c:forEach>
   </c:if>
   <tr>
    <td>project name: <input type="text" name='projectName' /></td>
    <td>project version: <input type="text" name='projectVersion' /></td>
    <td><input type="button" value='Add' /></td>
  </tbody>
 </table>
 <script type="text/javascript">
 $(function(){
	   $('table tbody input[type=button]').bind('click',function(){
		   var projectName = $('input[name=projectName]').val();
		   var projectVersion = $('input[name=projectVersion]').val();
		   var url = 'add?projectName='+projectName+"&projectVersion="+projectVersion;
		   location.href=url;
	   });
   });
 </script>
</body>
</html>