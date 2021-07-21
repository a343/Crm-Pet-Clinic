<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Save Pet</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add Visit</h3>

		<form:form action="saveVisit" modelAttribute="visit" method="POST">

			<!-- need to associate this data with customer id -->
			<form:input hidden="true" path="pet.pet_id" type="text"
				value="${pet_id}"/>
			<table>
				<tbody>
					<tr>
						<td><label>Issue:</label></td>
						<td><form:input path="issue" /></td>
					</tr>

					<tr>
						<td><label>Date:</label></td>
						<td><form:input type="date" path="date" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/visit/showListVisits?pet_id=${pet_id}">Back
				to List</a>
		</p>

	</div>

</body>

</html>










