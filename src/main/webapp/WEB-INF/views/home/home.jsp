<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link
	href="${pageContext.servletContext.contextPath}/resources/css/standard.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- TODO move it to include file or may be taglib to pass title as param -->
</head>
<body>
	<h1>Welcome to 07 Spring Hibernate Annotation example for 'ToDo'</h1>


	<img src="${pageContext.servletContext.contextPath}/resources/images/todo.png" alt="some_text">
	<P>The time on the server is ${serverTime}.</P>

	<jsp:include page="../common/footer.jsp">
		<jsp:param 	name="title" value="home" />
			</jsp:include>

</body>
</html>
