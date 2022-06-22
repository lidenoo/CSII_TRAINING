<%@page import="java.util.ArrayList,jp.csii.zoo.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クラスデータ一覧（ページング無）</title>
</head>
<body>

<p><a href="/zoo/index.jsp">戻る</a></p>

	<p>クラスデータ一覧（ページング無）</p>
	<table border="1">
		<tr>
			<td>id</td>
			<td>grade_id</td>
			<td>name</td>
		</tr>
		<%	
		
		
		
		ArrayList<MclassDto> al = (ArrayList<MclassDto>)request.getAttribute("cls");
		
		if (al!=null){ 
		
		
		for (MclassDto dto: al) {
		
		%>
		
		<tr>
			<td><%=dto.getId() %></td>
			<td><%=dto.getGradeId() %></td>
			<td><%=dto.getName() %></td>
		</tr>
		
		<% 
		}
		}
		%>

	</table>
	
	
	
</body>
</html>