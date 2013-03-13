<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<title>Home</title>
<link href="${pageContext.servletContext.contextPath}/resources/css/standard.css" rel="stylesheet" type="text/css" media="screen" />
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript">
function doAjaxPost(number) {  
	  // get the form values  
	  //var number = $('#thingId').html();
	  $.ajax({  
	    type: "DELETE",  
	    url: "delete/" + number,  
	    data: "",  
	    success: function(response){  
	      // we have the response  
	      $('#thingtr' + number ).html('<td colspan="9" align="center">'+response+' <a href="all"> refresh </a></td>');
	    },  
	    error: function(e){  
	      alert('Errorr: ' + e);  
	    }  
	  });  
	}  
	
function doAjaxPrePost(number) {  
	
	      $('#thingtr' + number ).html('<td colspan="9" align="center"> doyou want to delete #' + number + ' item ? <a href="javascript:doAjaxPost('+ number +')"> yes </a>/<a href="all"> no </a></td>');
	}  
</script>
</head>
<body>
	<h1 >Welcome to 07 Spring Hibernate Annotation example for 'ToDo'</h1>

	<c:if test="${not empty allThings}">
		
		<div style="margin-left: 30px; align: center;">
		
			<div  style="text-align: center;" class="CSSTableGenerator">
			<div style="font-size: medium;"> <a href="${pageContext.servletContext.contextPath}/thing/today"> Today </a> |
			<a href="${pageContext.servletContext.contextPath}/thing/thisweek"> This Week</a> |
			 <a href="${pageContext.servletContext.contextPath}/thing/tomorrow">Tomorrow </a>|
			 </div>
 				<!-- Table code-->
				<table  style="text-align: center;">
					<tbody>
						<tr>
							<td>#</td>
							<td>Title</td>
							<td>Description</td>
							<td> Owner </td>
							<!-- <td>Created On</td>
							<td>Last Updated on</td> -->
							<td>Start Date</td>
							<td>End Date</td>
							<td>Tags</td>
							<td>days</td>
							<td>Status</td>
							<td>Actions</td>
						</tr>

						<c:forEach var="thing" items="${allThings}">
							<tr id="thingtr${thing.id}">
								<td id="thingId">${thing.id}</td>
								<td>${thing.title}</td>
								<td>${thing.description} </td>
								<td><a href="${pageContext.servletContext.contextPath}/persons/${thing.owner.id}">${thing.owner.name}</a></td>
								<%-- <td><fmt:formatDate pattern="dd MMM, yy" type="date" value="${thing.createdOn}" /></td>
								<td><fmt:formatDate pattern="dd MMM, yy" type="date" value="${thing.lastUpdated}" /> </td> --%>
								<td><fmt:formatDate pattern="dd MMM, yy" type="date" value="${thing.startDate}" /> &nbsp;&nbsp;&nbsp;<font color='#E0E0E0' size='1' > ${thing.startDatePositiveDelta} </font></td>
								<td><font color='#E0E0E0' size='1'> ${thing.endDatePositiveDelta} </font> &nbsp; &nbsp; <fmt:formatDate pattern="dd MMM, yy" type="date" value="${thing.endDate}" /> </td>
								<td>
								<c:forEach var="tag" items="${thing.tags}">
								<a href="/taggs/${tag.name}" class="post-tag" title="" rel="tag">
								${tag.name}
								</a>
								</c:forEach>
								
								</td>
								<td><font color='black' size='2'> ${thing.totalPeriod}  </font> <font color='grey' size='1'> (+1 | +5 | +7 ) </font> </td>
								<td>
								<c:if test="${not empty thing.status}">
									<font color='grey' size='1'>started</font>
									&nbsp; &rarr;  &nbsp;
									<c:if test="${thing.status.string eq 'in progress'}">
										<font color='blue' size='3'>${thing.status.string}</font>
										&nbsp; &rarr; &nbsp;
										<font color='grey' size='1'>finished</font>
									</c:if>
									<c:if test="${thing.status.string eq 'finished'}">
										<font color='grey' size='1'>in progress</font>
										&nbsp; &rarr; &nbsp;
										<font color='blue' size='3'>${thing.status.string}</font>
									</c:if>
		
								</c:if>
								</td>
								<td><a href="javascript:doAjaxPrePost('${thing.id}')">delete</a> | 
									<a href="${thing.id}"> show </a> |
									<a href="${thing.id}?form"> edit </a> | +1 +5 +7 more </td>
								<!-- TODO above url should be 1. more restful 2. more readable  -->
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

<%-- <%@include file="../common/footer.jsp" %> static include	--%>		

<table style="border:thin;margin-top:300px">
<tr><td>TODO</td> <td>duration like 5hours 2days together/scatter or multiple days ${principal.name} </td></tr>
<tr><td>TODO</td> <td>location manchester home work gp ..location tags  </td></tr>
<tr><td>TODO</td> <td>add reall data</td></tr>
<tr><td>TODO</td> <td>person.things.tags</td></tr>
<tr><td>TODO</td> <td>CRUD for tags and user</td></tr>
<tr><td>TODO</td> <td>today only then calender </td></tr>
<tr><td>TODO</td> <td>cleaning</td></tr>
<tr><td>TODO</td> <td>testing</td></tr>
<tr><td>TODO</td> <td>security one up</td></tr>
<tr><td>TODO</td> <td>change color for start date between green and red</td></tr>
<tr><td>TODO</td> <td>move today /this week to a separate jsp</td></tr>
<tr><td>TODO</td> <td>more actions duplicate</td></tr>
<tr><td>TODO</td> <td>main table could go inside another jsp; then we cold have a separate jsp for today and this week with differnt footer</td></tr>
<tr><td>TODO</td> <td>tags , categories ( phone call , ), location( manchester, london, gps), person</td></tr>
<tr><td>TODO</td> <td>current selection criteria small tags of rectangle with crosses on right top e.g today , phone calls </td></tr>
<tr><td>TODO</td> <td>repeat events</td></tr>
<tr><td>TODO</td> <td>depends on </td></tr>
<tr><td>TODO</td> <td>add progress 5%</td></tr>
<tr><td>TODO</td> <td>tags to the task </td></tr>
<tr><td>TODO</td> <td>find by gps</td></tr>
<tr><td>TODO</td> <td>delegatedTo</td></tr>
<tr><td>TODO</td> <td>owner</td></tr>
<tr><td>TODO</td> <td> -OR- << < Day today, tomorrow, select day from calendar | week view next week, select week| month</td></tr>


</table>
</body>
</html>
