<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="text-align: center;">
<c:out value="${param.title}"></c:out>
	<c:if test="${param.title != 'home'}"> 
		<a href="${pageContext.servletContext.contextPath}"> Home </a> |
	</c:if>
	<c:if test="${param.title != 'thing_all'}">
	<a href="${pageContext.servletContext.contextPath}/thing/all"> view
		all things </a> |
		<a href="${pageContext.servletContext.contextPath}/persons/all"> view
		all users </a> | 
		</c:if>
		
		<c:if test="${param.title != 'thing_form'}"> 
	<a href="${pageContext.servletContext.contextPath}/thing?form">create
		a new thing</a>|
		<a href="${pageContext.servletContext.contextPath}/persons?form">create
		a new user</a>
		</c:if>
		| <a href="${pageContext.servletContext.contextPath}/tags/all"> all tags
		</a>|
		<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
</div>