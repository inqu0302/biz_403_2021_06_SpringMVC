<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
	<c:forEach items="${BOOKS}" var="BOOKS">
		<div class="content">
			<img src="${BOOKS.image}">
			<div>
				<p class="title">
					<a href="${BOOKS.link}" target="_NEW">
						${BOOKS.title}
					</a>
				</p>
				<p class="desc">${BOOKS.description}</p>
				<p class="author"><strong>저자</strong>${BOOKS.author}</p>
				<p class="publisher"><strong>출판사 : </strong>${BOOKS.publisher}</p>
				<button class="insert">내 서재등록</button>
			</div>
		</div>
	</c:forEach>
