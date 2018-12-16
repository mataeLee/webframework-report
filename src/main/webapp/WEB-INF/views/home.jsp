<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Hansung University Homepage</title>
</head>
<body>
	<p>
		<img src="${pageContext.request.contextPath }/resources/img/한성.png">
	</p>
	<h3>한성 학점관리 홈</h3>
	<p>
		<a href=" ${pageContext.request.contextPath }/preview">Look up
			Grade</a>
	</p>
	<p>
		<a href=" ${pageContext.request.contextPath }/createenrolment">Do
			Enroll</a>
	</p>
	<p>
		<a href=" ${pageContext.request.contextPath }/showenroll">Look up
			Enrolment</a>
	</p>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="/helloSpringMVC/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

</body>

</html>