<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PayPal</title>
</head>
<body>
	<h1>Paypal</h1>
	<form method="post" action="${posturl }">

		<input type="hidden" name="item_number_1" value="1">
		<input type="hidden" name="item_name_1" value="fee">
		<input type="hidden" name="amount_1" value="1">
		<input type="hidden" name="quantity_1" value="1">
		<br><br>
		<input type="submit" value="Submit">
		<input type="hidden" name="upload" value="1" /> 
		<input type="hidden" name="return" value="${returnurl }" /> 
		<input type="hidden" name="cmd" value="_cart" /> 
		<input type="hidden" name="business" value="${business }" />
	</form>
</body>
</html>