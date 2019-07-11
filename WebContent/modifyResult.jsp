<%@page import="gb.service.MessageUpdateService"%>
<%@page import="gb.model.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<c:if test="${res>0}">
		<h1>수정됨</h1>
		<a href='list.do'>목록보기</a>
	</c:if>
	<c:if test="${res<0}">
		<h1>비밀번호 일치 x</h1>
		<a href='modify.do?id=${id }'>다시</a>
	</c:if>

</body>
</html>