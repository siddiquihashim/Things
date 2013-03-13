<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<title>Home</title>
<link href="${pageContext.servletContext.contextPath}/resources/css/standard.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<h1 >Welcome to 07 Spring Hibernate Annotation example for 'ToDo'|Person|all</h1>

	<c:if test="${not empty allPersons}">
		
		<div style="margin-left: 30px; align: center;">
		
			<div  style="text-align: center;" class="CSSTableGenerator">
			
 				<!-- Table code-->
				<table  style="text-align: center;">
					<tbody>
						<tr>
							<td>#</td>
							<td>name</td>
							<td>email</td>
						</tr>

						<c:forEach var="person" items="${allPersons}">
						<tr>
								<td>${person.id}</td>
								<td>${person.name}</td>
								<td>${person.email}</td>  
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- End Table code-->
			</div>
		</div>
	</c:if>
	
	<jsp:include page="../common/footer.jsp">
		<jsp:param 	name="title" value="thing_all" />
			</jsp:include>

<table style="border:thin;margin-top:300px">
<tr><td>TODO</td> <td></td></tr>
<tr><td>TODO</td> <td></td></tr>
<tr><td>TODO</td> <td></td></tr>
<tr><td>TODO</td> <td></td></tr>
<tr><td>TODO</td> <td></td></tr>


</table>
</body>
</html>
