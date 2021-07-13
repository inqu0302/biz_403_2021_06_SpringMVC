<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />


<c:forEach
	items="${GALLERYS}"
	var="GALLERY">
	
	<div class="ga_box">
		<div>
			<c:if test="${empty GALLERY.g_image}">
				<img src="${rootPath}/files/noImage.png" width="100px">
			</c:if>
			<c:if test="${not empty GALLERY.g_image}">
				<img src="${rootPath}/files/${GALLERY.g_image}" width="100px">
			</c:if>
		</div>
		<div>
			<h3>
				<a href="${rootPath}/gallery/detail2/${GALLERY.g_seq}">
					${GALLERY.g_subject}
				</a>
			</h3>
			<p>${GALLERY.g_content}</p>
		</div>
	</div>

</c:forEach>
