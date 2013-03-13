<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<script>
$(function() {
	$("#datepicker1").datepicker({
	      showButtonPanel: true,
	      changeMonth: true,
	      changeYear: true,
	      dateFormat: "d M, y"
    });
	
	$("#datepicker2").datepicker({
	      showButtonPanel: true,
	      numberOfMonths: 3,
	      changeMonth: true,
	      changeYear: true,
	      dateFormat: "d M, y"
    });
});
</script>
</head>
<body>
	<h1>Welcome to 07 Spring Hibernate Annotation example for 'ToDo'
		Create a thing</h1>


	<jsp:include page="../common/thing_table.jsp">
		<jsp:param name="button_label" value="Update"/>
		<jsp:param name="_method" value="PUT" />
	</jsp:include>

	<jsp:include page="../common/footer.jsp">
		<jsp:param 	name="title" value="thing_form" />
			</jsp:include>
			
			
			<table style="border:thin;margin-top:300px">
<tr><td>TODO</td> <td> end date should be after start date</td></tr>
<tr><td>TODO</td> <td>description should be a text field</td></tr>
</table>

</body>
</html>
