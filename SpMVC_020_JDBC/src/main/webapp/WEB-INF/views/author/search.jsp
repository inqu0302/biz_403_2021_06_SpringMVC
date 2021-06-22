<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<body>
	<section class="search_sec">
		<table>
			<tr>
				<th>CODE</th>
				<th>저자명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>주요장르</th>
			</tr>
			<c:choose>
				<c:when test="${empty AUTHOR}">
					<tr><td colspan="5">데이터가 없습니다</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${AUTHOR}" var="AUTHOR">
						<tr data-acode="${AUTHOR.au_code}" class="search_author">
							<td>${AUTHOR.au_code}</td>
							<td>${AUTHOR.au_name}</td>
							<td>${AUTHOR.au_tel}</td>
							<td>${AUTHOR.au_addr}</td>
							<td>${AUTHOR.au_genre}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</section>
</body>
<script>
	document.querySelector("button.btn_insert.author").addEventListener("click", ()=>{
		location.href = "${rootPath}/author/insert";
	})
</script>
</html>