<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hansung University Login Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/login.css">
</head>
<body onload='document.f.username.focus();'>
	<p><img src="${pageContext.request.contextPath }/resources/img/한성.png"></p>
	<h3>Hansung University Login Form</h3>
	
	<c:if test="${not empty logoutMsg }">
			<div style="color:#00ff00"> <h3> ${ logoutMsg } </h3></div>
	</c:if>
		
	<form name='f' action="<c:url value="/login"/>" method='POST'> <!-- c태그 원래 부분(하드코딩) action="/helloSpring/login" -->
		<c:if test="${not empty errorMsg }">
			<div style="color:#ff0000"> <h3> ${ errorMsg } </h3></div>
		</c:if>
		
		<table>
			<tr>
				<td>StudentId:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input class="control" name="submit" type="submit"
					value="Login" /></td>
			</tr>
			<input name="${ _csrf.parameterName}" type="hidden" value="${_csrf.token }" /> <!-- 공격방어 토큰방식 -->
		</table>
	</form>
</body>
</html>