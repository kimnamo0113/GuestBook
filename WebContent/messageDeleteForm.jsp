<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		if(${res}==-2){
			alert("비밀번호 실패");
		}else{
			alert("삭제되었슴돠");
			location.href="list.do";
		}
	})
</script>

</head>
<body>
	메시지를 삭제하시려면 암호를 입력하세요
	<br>
	<form action="delete.do" method="post">
	<input type="hidden" name="id" value='${param.id }'>
	암호 : <input type="password" name="password">
	<input type="submit" value="메시지 삭제하기">
	</form>
</body>
</html>