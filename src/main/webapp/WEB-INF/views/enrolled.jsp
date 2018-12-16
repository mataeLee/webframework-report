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
	<h3>수강신청 목록</h3>

	<table>
		<tr>
			<td>학번</td>
			<td>수강년도</td>
			<td>수강학기</td>
			<td>과목코드</td>
			<td>과목명</td>
			<td>구분</td>
			<td>학점</td>
		</tr>
		<c:forEach var="i" items="${enrolled}">
			<tr>
				<td><c:out value="${i.username}"></c:out></td>
				<td><c:out value="${i.year}"></c:out></td>
				<td><c:out value="${i.semester}"></c:out></td>
				<td><c:out value="${i.code}"></c:out></td>
				<td><c:out value="${i.cores}"></c:out></td>
				<td><c:out value="${i.division}"></c:out></td>
				<td><c:out value="${i.grades}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}/createenrolment">수강신청
		더하기</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath}/">홈으로</a>
</body>
</html>