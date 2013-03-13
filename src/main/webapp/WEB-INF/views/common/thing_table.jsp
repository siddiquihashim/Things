<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div>
	<fieldset>
		<form:form method="${param._method}" modelAttribute="thing"
			action="${pageContext.servletContext.contextPath}/thing/">
			<%-- <form:form method="post" modelAttribute="registrationForm">  if action attribute is missing it will submit to the same path which displayed the form but we wanted to remove url params--%>
			<form:hidden path="id" />
			<table>
				<tr>
					<td colspan="2"><form:errors path="*" cssStyle="color : red;" /></td>
				</tr>

				<tr>
					<td><form:label path="title">Title</form:label></td>
					<td><form:input path="title" /></td>
				</tr>

				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input path="description" /></td>
				</tr>


				<tr>
					<td><form:label path="startDate"> Start Date</form:label></td>
					<td><form:input id="datepicker1" path="startDate" /></td>
				</tr>


				<tr>
					<td><form:label path="endDate"> End date</form:label></td>
					<td><form:input id="datepicker2" path="endDate" /></td>
				</tr>
				
				<tr>
					<td><form:label path="owner"> Owner</form:label></td>
					<td>
						<form:select path="owner.id">
							<form:option value="" label="--Please Select" />
						<c:forEach var="oo" items="${owners}">
							<form:option value="${oo.id}" label="${oo.name}" />
						
						</c:forEach>
						</form:select> 
					</td>
				</tr>

				<tr>
					<td><form:label path="status">Status </form:label></td>
					<td><form:select path="status">
							<form:options />
						</form:select> 
						<%-- <form:select path="status">
							<form:option value="" />
							<form:option value="in progress" />
							<form:option value="finished" />
						</form:select> --%>
						</td>
				</tr>

				<tr>
					<td colspan="1"></td>
					<td colspan="1"><input type="submit"
						value="${param.button_label}" /></td>
				</tr>
			</table>

		</form:form>
	</fieldset>
</div>