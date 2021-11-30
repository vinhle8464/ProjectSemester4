<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>List Product Info</h3>
	<br>
<a
				href="${pageContext.request.contextPath }/product/create">Add</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Status</th>
			<th>Created</th>
			<th>Description</th>
			<th>CategoryId</th>
			<th>CategoryName</th>
			<th>Action</th>

		</tr>
		<c:forEach var="product" items="${products }">
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.quantity }</td>
				<td>${product.status }</td>
				<td><fmt:formatDate var="created" value="${product.created }"
						pattern="dd/MM/yyyy" /> ${created }</td>
				<td>${product.description }</td>
				<td>${product.categoryId }</td>
				<td>${product.categoryName }</td>
					<td><a
				href="${pageContext.request.contextPath }/product/update?id=${product.id }">Update</a> |
				<a
				href="${pageContext.request.contextPath }/product/delete?id=${product.id }">Delete</a>
			</td>
			</tr>
		
		</c:forEach>
	</table>
</body>
</html>