<%@page import="gb.service.MessageWriteService"%>
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
		방명록에 메시지를 남겼습니다.
		<a href="list.do">목록 보기</a>
	</c:if>
	<c:if test="${res<=0}">
		방명록에 메시지남기기를 실패하였습니다.
		<a href="write.do">재 입력</a>
	</c:if>
	
</body>
</html>