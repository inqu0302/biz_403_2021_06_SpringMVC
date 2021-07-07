<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<style>
*{
	margin : 0;
	padding: 0;
	box-sizing: border-box;
}

h1{
	text: 70px bold;
	color: white;
	text-shadow: 1px 1px 1px #eee;
	text-align: center;
	background: #4682B4;
	padding: 2rem;
	margin-bottom: 1rem;
}

a#button{
	border: 1px solid #B0E0E6;
	background-color: #B0E0E6;
	padding: 10px;
	color: white;
	border-radius: 10px;
	text-align: right;
	margin-left: 80%;
}

div{
	width: 80%;
	margin: 10px auto;
}

div.ga_box {
	display: flex;
	border: 1px solid #B0E0E6;
	justify-content: center;
}

div.ga_box div:first-of-type {
	flex:1;
}

div.ga_box div:last-of-type {
	flex:3;
}

div#gallery_files{
 	display:flex;
 	flex-wrap: wrap;
}

div#gallery_files img{
 	margin:2px;
}

form {
	background-color: #B0C4DE;
	border-radius: 15px;
	width: 50%;
	margin: 10px auto;
	padding: 3rem;
}
form textarea{
	width: 60%;
	height: 10%;
}

form input{
	width: 50%;
	border: 0;
}



form button{
	background-color: #B0E0E6;
	padding: 10px;
	border-radius: 5px;
	float: right;
	border: 0;
}

div#gallery_files img {
    margin: 2px;
    height: 20%;
   }
   
div#gallery_files{
	display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
   
div#gallery_info{
	background-color: #B0C4DE;
	border-radius: 15px;
	width: 50%;
	margin: 10px auto;
	padding: 3rem;
}
</style>
</head>
<body>
<h1>내 갤러리</h1>

<c:choose>
	<c:when test="${BODY eq 'GA-INPUT'}">
		<%@ include file="/WEB-INF/views/gallery/input.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA-LIST'}">
		<%@ include file="/WEB-INF/views/gallery/list.jsp" %>
		<a id=button href="${rootPath}/gallery/input">이미지 등록</a>
	</c:when>
	<c:when test="${BODY eq 'GA-DETAIL'}">
		<%@ include file="/WEB-INF/views/gallery/detail.jsp" %>
		<a id=button href="${rootPath}/gallery">리스트로</a>
	</c:when>
	<c:otherwise>
		<a href="${rootPath}/gallery/input">이미지 등록</a>
	</c:otherwise>
</c:choose>

<c:forEach items="${FILES}" var="FILE">
	<a href="${rootPath}/files/${FILE}" target="_NEW">
	<img 
		src="${rootPath}/files/${FILE}" 
		width="100px" height="100px"/>
	</a>
</c:forEach>

<img src="${rootPath}/files/title.jpg" width="200px" />


</body>
</html>