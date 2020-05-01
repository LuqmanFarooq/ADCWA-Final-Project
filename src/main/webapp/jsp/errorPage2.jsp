<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADCWA Final Project</title>
</head>
<body>
	<h1>Error Creating the following order</h1>
	<h2>Error: Customer: 4${orders.cust.cId} and/or Product: ${orders.prod.pId} does not exist
	</h2>
	<form:form modelAttribute="orders">
		<table>
			<tr>
				<td>Product ID</td>
				<td>Customer ID</td>
				<td>Quantity</td>
			</tr>
			<tr>
				<td>${orders.prod.pId}</td>
				<td>${orders.cust.cId}</td>
				<td>${orders.qty}</td>
			</tr>
			
		</table>
		<table>
			<tr>
				<td><a href="\">Home</a></td>
				<td><a href="/newOrder.html">New Order</a></td>
				<td><a href="/showOrders.html">List Orders</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>