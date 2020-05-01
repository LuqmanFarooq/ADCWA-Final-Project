<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
th, .pro {
	border: 1px solid black;
}
</style>
<title>ADCWA Final Project</title>
</head>
<body>

	<h1>List of Customers</h1>
	<c:forEach items="${customers}" var="customer">
		<h2>${customer.cId} ${customer.cName}</h2>
		<h3>${customer.cName}'sOrder</h3>
		<table class="pro">
			<tr>
				<th>Order ID</th>
				<th>Quantity</th>
				<th>Product Id</th>
				<th>Description</th>
			</tr>
			<tr>

				<c:forEach items="${customer.orders}" var="cust">
					<tr>
						<td class="pro">${cust.oId }</td>
						<td class="pro">${cust.qty }</td>
						<td class="pro">${cust.prod.pId }</td>
						<td class="pro">${cust.prod.pDesc }</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</c:forEach>
	<table>
		<tr>
			<td><a href="\">Home</a></td>
			<td><a href="/addCustomer.html">Add Customers</a></td>
			<td><a href="/showProducts.html">List Products</a></td>
			<td><a href="/showOrders.html">List Orders</a></td>
			<td><a href="/logout">Logout</a></td>
		</tr>
	</table>
</body>
</html>