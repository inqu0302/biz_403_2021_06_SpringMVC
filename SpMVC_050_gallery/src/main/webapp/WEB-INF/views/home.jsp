<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<script src="https://kit.fontawesome.com/702bdebe0d.js" crossorigin="anonymous"></script>
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

nav#main_nav{
	background : #20B2AA;
}

nav#main_nav ul{
	display: flex;
	list-style: none;
}

nav#main_nav ul li{
	margin-left: 10px;
	padding : 1rem;
	position: relative;
}

nav#main_nav ul li:nth-child(3) {
	margin-left: auto;
}

nav#main_nav ul li:hover{
	background: #00FFFF;
	cursor: pointer;
	font-weight: bold;
}

nav#main_nav ul li:after{
	content: "";
	position: absolute;
	left:0;
	bottom: 0;
	
	heigth:0;
	width:0;
	
	transition: all 0.7s;
}

nav#main_nav ul li:hover:after{
	border-bottom: 5px solid yellow;
	
	heigth: 100%;
	width:100%;
}
</style>
</head>
<body>
<h1>내 갤러리</h1>
<%@ include file="/WEB-INF/views/include/include_nav.jspf" %>
<c:choose>
	<c:when test="${BODY eq 'GA-INPUT'}">
		<%@ include file="/WEB-INF/views/gallery/input.jsp" %>
	</c:when>
	<c:when test="${BODY eq 'GA-LIST'}">
		<%@ include file="/WEB-INF/views/gallery/list.jsp" %>
		<a href="${rootPath}/gallery/input">이미지 등록</a>
	</c:when>
	<c:when test="${BODY eq 'GA-DETAIL'}">
		<%@ include file="/WEB-INF/views/gallery/detail.jsp" %>
	</c:when>
	
	<c:when test="${BODY eq 'GA-DETAIL-V2'}">
		<%@ include file="/WEB-INF/views/gallery/detail2.jsp" %>
	</c:when>

	<c:when test="${BODY eq 'JOIN'}">
		<%@ include file="/WEB-INF/views/member/join.jsp" %>
	</c:when>

	<c:when test="${BODY eq 'LOGIN'}">
		<%@ include file="/WEB-INF/views/member/login.jsp" %>
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

</body>
<script>
let main_nav = document.querySelector("nav#main_nav")

if(main_nav){
	
	main_nav.addEventListener("click",(e)=>{
		let menu = e.target
		
		if(menu.tagName === "LI"){
			if(menu.id === "join"){
				location.href = "${rootPath}/member/join"
			} else if(menu.id === "login"){
				location.href = "${rootPath}/member/login/nav"
			} else if(menu.id === "logout"){
				location.href = "${rootPath}/member/logout"
			} else if(menu.id === "image_create"){
				location.href = "${rootPath}/gallery/input"
			} else if(menu.id === "home"){
				location.href = "${rootPath}/"
			}
				
		}
	})
}

</script>
</html>