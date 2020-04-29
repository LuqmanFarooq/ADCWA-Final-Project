<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADCWA Final Project</title>
</head>
<body>
<h1>Add New Product</h1>
<form:form modelAttribute="products">
  <table>
    <tr>
      <td>Product Description:</td>
      <td><form:input path="pDesc" required="required"></form:input></td>
    </tr>
     <tr>
      <td>Quantity in Stock:</td>
      <td><form:input path="qtyInStock" type="number" min="1"></form:input></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Add"/>
      </td>
    </tr>
  </table>
  <table>
    <tr>
    	<td><a href="\">Home</a></td>
	    <td><a href="/showOrders.html">List Orders</a></td>
	    <td><a href="/showProducts.html">List Products</a></td>
	  </tr>
  </table>
</form:form>
</body>
</html>