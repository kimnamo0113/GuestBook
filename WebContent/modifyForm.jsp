<%@page import="gb.model.Message"%>
<%@page import="gb.service.MessageUpdateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		if(${res}==-2){
			alert("비밀번호 실패");
		}
	})
</script>
</head>
<body>
<form action="modify.do" method="post">
	이름 : <input type="text" disabled="disabled" name="message_id" value="${msg.guest_name }"><br>
	비밀번호 : <input type="password" name="newPassword"><br>
	메시지 : <textarea rows="5" cols="40" name="message">${msg.message }</textarea>
	<input type="hidden" name="message_id" value="${msg.message_id }">
	<input type="hidden" name="originPassword" value="${msg.password }">
	<input type="submit">
</form>
</body>
</html>