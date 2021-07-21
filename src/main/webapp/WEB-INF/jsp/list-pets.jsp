<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<p>
				User:
				<security:authentication property="principal.username" />
				, Role(s):
				<security:authentication property="principal.authorities" />
			</p>


			<!-- put new button: Add Pet -->
			<form:form action="showFormForAddPet" method="POST"
				modelAttribute="customer">

				<input hidden="true" name="id" type="text"
					value=<%=request.getParameter("customerId")%>>

				<input class="add-button" type="submit" value="Add Pet" />

			</form:form>

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Customer</th>
					<th>Pet Name</th>
					<th>Pet Type</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempPet" items="${pets}">


					<!-- construct an "delete" link with pet id -->
					<c:url var="deleteLink" value="/pet/delete">
						<c:param name="pet_id" value="${tempPet.pet_id}" />
						<c:param name="customer_id"
							value="<%=request.getParameter(\"customerId\")%>" />

					</c:url>

					<!-- construct an "visit" link with pet id -->
					<c:url var="checkVisitslink" value="/visit/showListVisits">
						<c:param name="pet_id" value="${tempPet.pet_id}" />
						<c:param name="customer_id"
							value="<%=request.getParameter(\"customerId\")%>" />
					</c:url>


					<tr>
						<td>${tempPet.owner.firstName}</td>
						<td>${tempPet.name}</td>
						<td>${tempPet.pet_type.type}</td>

						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

							<td><security:authorize
									access="hasAnyRole('MANAGER', 'ADMIN')">
								</security:authorize> <security:authorize access="hasAnyRole('ADMIN')">
									<a href="${deleteLink}"
										onclick="if (!(confirm('Are you sure you want to delete this pet?'))) return false">Delete</a>
								</security:authorize> <a href="${checkVisitslink}">Check Visits</a></td>

						</security:authorize>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

	<p></p>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" class="add-button" />

		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</p>
	</form:form>

</body>

</html>









