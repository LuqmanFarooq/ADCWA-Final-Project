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
<h1>Add New Order</h1>
<form:form modelAttribute="orders">
  <table>
    <tr>
      <td>Customer:</td>
      <td><form:select path="cust" items="${customersList}"></form:select></td>
    </tr>
     <tr>
      <td>Product:</td>
      <td><form:select path="prod" items="${productList}"></form:select></td>
    </tr>
    <tr>
      <td>Quantity:</td>
      <td><form:input path="qty" ></form:input></td>
      <td><form:errors path="qty"></form:errors></td>
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
	    <td><a href="/showCustomers.html">List Customers</a></td>
	    <td><a href="/showProducts.html">List Products</a></td>
	  </tr>
  </table>
</form:form>
</body>
</html>