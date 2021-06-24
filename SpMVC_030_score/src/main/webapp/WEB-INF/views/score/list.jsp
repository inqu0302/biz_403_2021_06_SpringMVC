<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<style>
	button.score.insert{
		background-color: rgba(0,100,200,0.8);
		color:white;
	}
	
	button.score.student{
		background-color: orange;
		color: white;
	}
</style>
<table>
	<tr>
		<th>NO</th>
		<th>학번</th>
		<th>학생이름</th>
		<th>과목코드</th>
		<th>과목</th>
		<th>점수</th>
	</tr>
	<c:choose>
		<c:when test="${empty SCORE}">
		</c:when>
		<c:otherwise>
			<c:forEach items="${SCORE}" var="sc">
				<tr>
					<td>${sc.sc_seq}</td>
					<td>${sc.sc_stnum}</td>
					<td>${sc.sc_stname}</td>
					<td>${sc.sc_sbcode}</td>
					<td>${sc.sc_sbname}</td>
					<td class="number">${sc.sc_score}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<div class="btn_box">
	<button class="score insert">성적등록</button>
	<button class="score student list">학생정보 바로가기</button>
</div>