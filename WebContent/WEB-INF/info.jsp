<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结果展示</title>
</head>
<body>
 ${info }
 
 <table align='center' border='1'>
 <tr>
 		<td>姓名</td>
 		<td>学号</td>
 		<td>宿舍号</td>
 	</tr>
 	<tr>
 		<td>${student.name }</td>
 		<td>${student.student_number }</td>
 		<td>${student.dormitory_number }</td>
 	</tr>
 </table>
</body>
</html>