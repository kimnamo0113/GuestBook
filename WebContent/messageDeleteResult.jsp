<%@page import="gb.service.MessageDeleteService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:if test="${res<0}">
	입력한 암호가 올바르지 않습니다.암호를 확인해 주세요.<br>
	<a href="delete.do?id=${id }">다시</a>
</c:if>
<c:if test="${res>0}">
	메시지를 삭제하였습니다.<br>
	<a href="list.do">목록보기</a>
</c:if>
</body>
</html>