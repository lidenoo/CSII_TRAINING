<%@page import="java.util.ArrayList,jp.csii.zoo.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規追加</title>
</head>
<body>

	<p>
		<a href="/zoo/mclasslistnasi">戻る</a>
	</p>




<form action="/zoo/mclassservletnasiins" method="post">
	<table border="2">
	
		<tr>
			<td>grade_id</td>
			<td><input type="text" name="gradeid" value=""></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input type="text" name="name" value=""></td>
		</tr>
	</table>
	<input type="submit">
</form>


</body>
</html>