<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Home</title>
<link
	href="${pageContext.servletContext.contextPath}/resources/css/standard.css"
	rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<h1>All Tags</h1>

	<c:if test="${not empty allTags}">

		<div style="margin-left: 30px; align: center;">

			<div style="text-align: center;" class="CSSTableGenerator">
				<div style="font-size: medium;">
					<a href="${pageContext.servletContext.contextPath}/tags?form">
						create a new Tag </a>|
				</div>
				<!-- Table code-->
				<table style="text-align: center;">
					<tbody>
						<tr>
							<td>#</td>
							<td>name</td>
							<td>version</td>
							<td>popularity</td>
							<td>Actions</td>
						</tr>

						<c:forEach var="tag" items="${allTags}">
							<tr >
								<td>${tag.id}</td>
								<td>${tag.name}</td>
								<td>${tag.version}</td>
								<td>${tag.popularity}</td>
								<td> 
								<a href="delete/${tag.id}">delete</a> | 
									<a href="${tag.id}"> show </a> |
									<a href="${tag.id}?form"> edit </a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- End Table code-->
			</div>
		</div>
	</c:if>

	<jsp:include page="../common/footer.jsp">
		<jsp:param name="title" value="thing_all" />
	</jsp:include>

	<%-- <%@include file="../common/footer.jsp" %> static include	--%>

	<table style="border: thin; margin-top: 300px">
		<tr>
			<td>TODO</td>
			<td></td>
		</tr>
		<tr>
			<td>TODO</td>
			<td></td>
		</tr>
		<tr>
			<td>TODO</td>
			<td></td>
		</tr>
	</table>
</body>
</html>
