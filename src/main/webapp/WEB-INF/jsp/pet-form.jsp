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
		<h3>Save Pet</h3>

		<form:form action="savePets"
			modelAttribute="pet" method="POST">

			<!-- need to associate this data with customer id -->
			<form:input hidden="true" path="owner.id" type="text"
				value="${customer_id}"/>
			<form:input hidden="true" path="owner.id" type="text"
				value="${customer_id}"/>
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>

					<tr>
						<td><label>Type:</label></td>
						<td><form:select path="pet_type.pet_id"  items="${petTypes}"
								class="form-control" /></td>
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
			<a href="${pageContext.request.contextPath}/pet/showListPets?customerId=${customer_id}">Back
				to List</a>
		</p>

	</div>

</body>

</html>










