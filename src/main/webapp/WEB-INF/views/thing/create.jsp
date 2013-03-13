<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
<link
	href="${pageContext.servletContext.contextPath}/resources/css/standard.css"
	rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/datepicker.js"></script>


</head>
<body>
	<h1>Create a thing</h1>


	<jsp:include page="../common/thing_table.jsp">
		<jsp:param name="button_label" value="Create" />
		<jsp:param name="_method" value="post" />
	</jsp:include>

	<jsp:include page="../common/footer.jsp">
		<jsp:param name="title" value="thing_form" />
	</jsp:include>


			<table style="border:thin;margin-top:300px">
<tr><td>TODO</td> <td> more option for calendar</td></tr>
<tr><td>TODO</td> <td>after selecting start date; end date should start from start+0</td></tr>
<tr><td>TODO</td> <td>datepicker should have a start date as today</td></tr>

</table>

</body>
</html>
