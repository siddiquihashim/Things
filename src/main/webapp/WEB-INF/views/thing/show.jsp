<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
<title>Home</title>
<link
	href="${pageContext.servletContext.contextPath}/resources/css/standard.css"
	rel="stylesheet" type="text/css" media="screen" />

</head>
<body>
	<h1>Welcome to 07 Spring Hibernate Annotation example for 'ToDo'
		show a thing</h1>

<c:if test="${not empty thing}">
	<div>
		<fieldset >
		
				<table>

					<tr><td>Id </td><td>${itemId}</td></tr>
					<tr><td>Title</td><td>${thing.title}</td></tr>
					<tr><td>Description</td><td>${thing.description}</td></tr>
						
					<tr>
					<td>Start Date</td><td><fmt:formatDate pattern="dd MMM, yy" type="date" value="${thing.startDate}" /></td>
					</tr>
					
					
					<tr>
						<td>End Date</td><td><fmt:formatDate pattern="dd MMM, yy" type="date" value="${thing.endDate}" /></td>
					</tr>
					<tr><td>Created On</td><td><fmt:formatDate pattern="dd MMM, yy" type="date" value="${thing.createdOn}"/></td></tr>
					<tr><td>Status</td><td>${thing.status}</td></tr>


				</table>

		</fieldset>
	</div>
	</c:if>

	<jsp:include page="../common/footer.jsp">
		<jsp:param 	name="title" value="thing_show" />
			</jsp:include>

</body>
</html>
