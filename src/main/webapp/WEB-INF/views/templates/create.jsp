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
	
	<div>
		<fieldset>
			<form:form method="POST" modelAttribute="person"
				action="${pageContext.servletContext.contextPath}/persons/">
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
						<td><form:label path="email">Email: </form:label></td>
						<td><form:input path="email" /></td>
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
<tr><td>TODO</td> <td> </td></tr>
<tr><td>TODO</td> <td></td></tr>
<tr><td>TODO</td> <td></td></tr>

</table>

</body>
</html>
