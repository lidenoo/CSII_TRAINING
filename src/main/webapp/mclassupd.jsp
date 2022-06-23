<%@page import="java.util.ArrayList,jp.csii.zoo.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クラスデータ変更画面</title>
</head>
<body>

	<p>
		<a href="/zoo/mclasslistnasi">戻る</a>
	</p>

	<p>クラスデータ変更画面</p>
	<%
	MclassDto dto = (MclassDto) request.getAttribute("updDto");
	%>

<form action="/zoo/mclassservletnasiupd" method="post">
	<table border="2">
		<tr>
			<td>id</td>
			<td><%=dto.getId()%>
			<input type="hidden" name="id" value="<%=dto.getId()%>">
			</td>
			
		</tr>
		<tr>
			<td>grade_id</td>
			<td><input type="text" name="gradeid" value="<%=dto.getGradeId()%>"></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input type="text" name="name" value="<%=dto.getName()%>"></td>
		</tr>
	</table>
	<input type="submit">
</form>


</body>
</html>