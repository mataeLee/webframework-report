<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
	<h3>수강 신청</h3>
	<!-- doenroll -->
	<sf:form method="post"
		action="${pageContext.request.contextPath }/doenroll"
		modelAttribute="enrolment">
		<!-- modelAttribute와 각각 input의 path를 설정하여 offer 객체에 필드들(path)을 설정해야함 -->
		<table class="formtable">
			<tr>
				<td>학번</td>
				<td><sf:input type="text" path="username" /> <br /> <sf:errors
						path="username" class="error" /></td>
				<!-- OfferController에서 설정한 message를 띄워줌 -->
			</tr>
			<tr>
				<td>수강년도</td>
				<td><sf:input type="text" path="year" /><br /> <sf:errors
						path="year" class="error" /></td>
			</tr>
			<tr>
				<td>수강학기</td>
				<td><sf:input type="text" path="semester" /> <sf:errors
						path="semester" class="error" /></td>
			</tr>
			<tr>
				<td>과목코드</td>
				<td><sf:input type="text" path="code" /> <sf:errors
						path="code" class="error" /></td>
			</tr>
			<tr>
				<td>과목명</td>
				<td><sf:input type="text" path="cores" /> <sf:errors
						path="cores" class="error" /></td>
			</tr>
			<tr>
				<td>구분</td>
				<td><sf:input type="text" path="division" /> <sf:errors
						path="division" class="error" /></td>
			</tr>
			<tr>
				<td>학점</td>
				<td><sf:input type="number" path="grades" /> <sf:errors
						path="grades" class="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" type="submit" value="수강신청"></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>