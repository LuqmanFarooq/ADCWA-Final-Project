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
<h1>Add New Customer</h1>
<form:form modelAttribute="customers">
  <table>
    <tr>
      <td>Cust Name:</td>
      <td><form:input path="cName" required="required"></form:input></td>
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