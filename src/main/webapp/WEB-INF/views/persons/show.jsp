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
		show the person</h1>

<c:if test="${not empty person}">
	<div>
		<fieldset >
		
				<table>

					<tr><td>Id </td><td>${personId}</td></tr>
					<tr><td>Name</td><td>${person.name}</td></tr>
					<tr><td>Email</td><td>${person.email}</td></tr>
						
				</table>

		</fieldset>
	</div>
	</c:if>

	<jsp:include page="../common/footer.jsp">
		<jsp:param 	name="title" value="person_show" />
			</jsp:include>

</body>
</html>
