<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="write.do" method="post">
		이름 : <input type="text" name="guest_name"><br>
		암호 : <input type="password" name="password"><br>
		메시지 : <textarea rows="5" cols="50" name="message"></textarea><br>
		<input type="submit" value="메시지 남기기">
	</form>
</body>
</html>