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

			<!-- put new button: Add Visit -->
			<form:form
				action="${pageContext.request.contextPath}/visit/showFormForAddVisit"
				method="POST" modelAttribute="pet">

				<input hidden="true" name="pet_id" type="text"
					value=<%=request.getParameter("pet_id")%>>

				<input class="add-button" type="submit" value="Add Visit" />

			</form:form>


			<!--  add our html table here -->

			<table>
				<tr>
					<th>Customer</th>
					<th>Pet Name</th>
					<th>Date</th>
					<th>Issue</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempVisits" items="${visits}">

					<tr>
						<td>${tempVisits.pet.owner.firstName}</td>
						<td>${tempVisits.pet.name}</td>
						<td>${tempVisits.date}</td>
						<td>${tempVisits.issue}</td>
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

	</form:form>
	<!-- Add a logout button -->

	<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back to
			List</a>
	</p>
</body>

</html>









