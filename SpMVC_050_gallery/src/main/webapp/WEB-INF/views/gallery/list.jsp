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
			<img src="${rootPath}/files/${GALLERY.g_image}" width="100px">
		</div>
		<div>
			<h3>
				<a href="${rootPath}/gallery/detail/${GALLERY.g_seq}">
					${GALLERY.g_subject}
				</a>
				${GALLERY.g_subject}</h3>
			<p>${GALLERY.g_content}</p>
		</div>
	</div>

</c:forEach>

