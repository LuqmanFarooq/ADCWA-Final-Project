<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
<h1>List of Products</h1>
<table class="pro">
  <tr>
   <th>Product ID</th>
   <th>Description</th>
   <th>Quantity in Stock</th>
  </tr>
  <tr>
    <c:forEach items="${products}" var="product">
      <tr> 
        <td class="pro">${product.pId}</td>
        <td class="pro">${product.pDesc}</td>
        <td class="pro">${product.qtyInStock}</td>
      </tr>
    </c:forEach>
  </tr>
  </table>
  <table>
  <tr>
	    <td><a href="\">Home</a></td>
	    <td><a href="/addProduct.html">Add Products</a></td>
	    <td><a href="/showProducts.html">List Products</a></td>
	    <td><a href="/showOrders.html">List Orders</a></td>
	    <td><a href="\">Logout</a></td>
	  </tr>
</table>
</body>
</html>