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

	<c:if test="${not empty allThings}">

		<div style="margin-left: 30px; align: center;">

			<div style="text-align: center;" class="CSSTableGenerator">
				<div style="font-size: medium;">
					<a href="${pageContext.servletContext.contextPath}/thing/today">
						Today </a> | <a
						href="${pageContext.servletContext.contextPath}/thing/thisweek">
						This Week</a> | <a
						href="${pageContext.servletContext.contextPath}/thing/tomorrow">Tomorrow
					</a>|
				</div>
				<!-- Table code-->
				<table style="text-align: center;">
					<tbody>
						<tr>
							<td>#</td>
						</tr>

						<c:forEach var="thing" items="${allThings}">
							<tr id="thingtr${thing.id}">
								<td id="thingId">${thing.id}</td>
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
