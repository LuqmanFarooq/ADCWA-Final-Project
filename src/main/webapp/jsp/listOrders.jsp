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

	<h1>List of Orders</h1>
	<c:forEach items="${orders}" var="order">
		<h2>${order.oId}</h2>
		
		<table class="pro">
			<tr>
				<th>Quantity</th>
				<th>Order Date</th>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Product ID</th>
				<th>Description</th>
			</tr>
			<tr>

						<td class="pro">${order.qty }</td>
						<td class="pro">${order.orderDate }</td>
						<td class="pro">${order.cust.cId }</td>
						<td class="pro">${order.cust.cName }</td>
						<td class="pro">${order.prod.pId }</td>
						<td class="pro">${order.prod.pDesc }</td>
					
			</tr>
		</table>
	</c:forEach>
	<table>
		<tr>
			<td><a href="\">Home</a></td>
			<td><a href="/addOrder.html">Add Order</a></td>
			<td><a href="/showProducts.html">List Products</a></td>
			<td><a href="/showCustomers.html">List Customers</a></td>
			<td><a href="\">Logout</a></td>
		</tr>
	</table>
</body>
</html>