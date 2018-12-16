<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/grade.css">
</head>
<body>
	<p>
		<img src="${pageContext.request.contextPath }/resources/img/한성.png">
	</p>
	<h3>성적 조회 서비스</h3>
	<table>
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>이수학점</td>
			<td>상세보기</td>
		</tr>
		<c:forEach var="i" items="${previews}">
			<tr>
				<td>${i.year}</td>
				<td>${i.semester}</td>
				<td>${i.grades}</td>
				<td><a href="${pageContext.request.contextPath }/grades?year=${i.year}&semester=${i.semester}">링크</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>