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
	<h1>Tag</h1>

<c:if test="${not empty tag}">
	<div>
		<fieldset >
		
				<table>

					<tr><td>Id </td><td>${itemId}</td></tr>
					<tr><td>Name</td><td>${tag.name}</td></tr>
					<tr><td>popularity</td><td>${tag.popularity}</td></tr>
				</table>

		</fieldset>
	</div>
	</c:if>

	<jsp:include page="../common/footer.jsp">
		<jsp:param 	name="title" value="thing_show" />
			</jsp:include>

</body>
</html>
