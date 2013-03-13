<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Home</title>
<link
	href="${pageContext.servletContext.contextPath}/resources/css/standard.css"
	rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<h1>Create Tag</h1>
	
	<div>
		<fieldset>
			<form:form method="POST" modelAttribute="tag"
				action="${pageContext.servletContext.contextPath}/tags/">
				<form:hidden path="id" />
				<table>
					<tr>
						<td colspan="2"><form:errors path="*" cssStyle="color : red;" /></td>
					</tr>

					<tr>
						<td><form:label path="name">Name: </form:label></td>
						<td><form:input path="name" /></td>
					</tr>

					<tr>
						<td colspan="1"></td>
						<td colspan="1"><input type="submit" value="create" /></td>
					</tr>
				</table>

			</form:form>
		</fieldset>
	</div>


	<jsp:include page="../common/footer.jsp">
		<jsp:param name="title" value="thing_form" />
	</jsp:include>


			<table style="border:thin;margin-top:300px">
<tr><td>TODO</td> <td>add logic for multiple tags in a text area </td></tr>
<tr><td>TODO</td> <td>display existing popular tag on the rhs</td></tr>
<tr><td>TODO</td> <td>ajax or multiple create</td></tr>

</table>

</body>
</html>
