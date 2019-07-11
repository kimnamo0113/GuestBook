<%@page import="gb.model.Message"%>
<%@page import="java.util.List"%>
<%@page import="gb.service.MessageListService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tabel{
		border-collapse: collapse;
	}
	th,td{
		border: 1px solid black;
		padding: 5px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("table a:even").click(function() {
			var index=$("a").index(this)/2;
			
			var check=confirm("증말 삭제 하시겟어요?");
			if(check==true){
				var id=$("tr").eq(index+1).find("td").eq(0).text();
				location.href="delete.do?id="+id;
			}
			else{
				alert("취소됨");
			}
		})
		$("table a:odd").click(function() {
			var index=Math.floor($("a").index(this)/2);
			var check=confirm("증말 수정 하시겟어요?");
			if(check==true){
				var id=$("tr").eq(index+1).find("td").eq(0).text();
				location.href="delete.do?id="+id;
			}
			else{
				alert("취소됨");
			}
			  
		})
	})
</script>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>이 름</th>
			<th>내 용</th>
			<th></th>
		</tr>
	
	<c:forEach var="message" items="${list }">
		<tr>
			<td>${message.message_id }</td>
			<td>${message.guest_name }</td>
			<td>${message.message }</td>
			<td>
			
				
				<a href="#">삭제하기</a>
			
				<a href="modify.do?id=${message.message_id }">수정하기</a>
			</td>
		</tr>	
	</c:forEach>
	
</table>

	<a href="write.do">방명록 등록</a>
</body>
</html>