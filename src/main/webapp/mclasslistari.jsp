<%@page import="java.util.ArrayList,jp.csii.zoo.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クラスデータ一覧(ページングあり)</title>
</head>
<body>

	<p>
		<a href="/zoo/index.jsp">戻る</a>
	</p>

	<p>クラスデータ一覧(ページングあり)</p>
	<table border="1">
		<tr>
			<td>id</td>
			<td>grade_id</td>
			<td>name</td>
			<td>操作1</td>
			<td>操作2</td>
		</tr>
		<%
		ArrayList<MclassDto> al = (ArrayList<MclassDto>) request.getAttribute("mclassDtoListKey");

		if (al != null) {

			for (MclassDto dto : al) {
		%>

		<tr>
			<td><%=dto.getId()%></td>
			<td><%=dto.getGradeId()%></td>
			<td><%=dto.getName()%></td>
			<td><a href="">削除</a></td>
			<td><a href="">変更</a></td>
		</tr>

		<%
		}
		}
		%>

	</table>

	<%
	MclassDtoPaging pagDtoPing = (MclassDtoPaging) request.getAttribute("paging");
	%>

	<p>
		<a href="mclasslistari?page=${paging.indexpage-1}">最初頁</a>

		<%
		if (pagDtoPing.getPage() - 1 < 0) {
		%>
		前頁
		<%
		} else {
		%>
		<a href="mclasslistari?page=${paging.page-1 }"> 前頁</a>
		<%
		}
		%>

		<strong>第${paging.page+1}頁/全${paging.pagenumber}頁</strong>

		<%
		if (pagDtoPing.getPage() + 1 >= pagDtoPing.getPagenumber()) {
		%>
		後頁
		<%
		} else {
		%>
		<a href="mclasslistari?page=${paging.page+1}">後頁</a>
		<%
		}
		%>

		<a href="mclasslistari?page=${paging.pagenumber-1}">最後頁</a>

	</p>







</body>
</html>