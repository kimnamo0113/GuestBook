<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
		Connection conn = null;
	
		try{
			String jdbcDriver="jdbc:apache:commons:dbcp:guestbook";
			conn = DriverManager.getConnection(jdbcDriver); // connection pool에서 connection 한개 받음
			if(conn !=null){
				out.println("커넥션 풀에 연결하였습니다.");
			}else{
				out.println("커넥션 풀에 실패하였습니다..");
			}
		}finally{
			if(conn!=null)
				conn.close();   
		}
	%>
</body>
</html>