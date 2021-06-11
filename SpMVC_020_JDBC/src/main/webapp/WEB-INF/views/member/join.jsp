<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<style>
	form#join_form{
		width: 350px;
		padding: 40px;
		margin: 50px auto;
		
		background-color:#D8BFD8;
		text-align: center;
		border-radius: 30px;
	}
	
	form#join_form h2{
		color: white;
		font-weight: 500;
	}
	
	form#join_form input{
		outline: 0;
		display: block;
		
		width: 200px;
		margin: 20px auto;
		padding: 14px 10px;		

		border: 1px solid rgb(60,150,200);
		border-radius:5px;
		
		background-color:#D8BFD8;
		color: white;
		transition: 0.3s;
	}
	
	form#join_form input:focus{
		whidth: 300px;
		border-color: #2ecc71;
	}
	
	form#join_form button{
		display: block;
		
		outline:none;
		background: none;
		
		width: 100px;
		margin:20px auto;
		text-align: center;
		
		border:1px solid rgb(60,150,200);
		border-radius: 5px;
		color: white;
		cursor: pointer;
	}
	
	form#join_form button:hover{
		background-color: #2ecc71;
	}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
	
	<form id="join_form" method="POST">
		<h2>회원가입</h2>
		<input name="m_username" placeholder="사용자 ID">
		<input type="password" name="m_password" placeholder="비밀번호">
		<input type="password" name="m_re_password" placeholder="비밀번호 확인">
		<button>가입하기</button>
	</form>
	
	<%@ include file="/WEB-INF/views/include/include_footer.jspf" %>
	
</body>
<script>
	document.querySelector("button.btn_book_insert").addEventListener("click", ()=>{
		location.href = "${rootPath}/books/insert";
	})
</script>
</html>