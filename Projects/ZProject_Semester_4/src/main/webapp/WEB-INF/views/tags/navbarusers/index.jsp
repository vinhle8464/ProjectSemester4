
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.html"> <img
			src="${pageContext.request.contextPath}/resources/user/images/logo.png"
			alt="" />
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbars-host" aria-controls="navbars-rs-food"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbars-host">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/user/home">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/user/about">About Us</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown-a"
					data-toggle="dropdown">Course </a>
					<div class="dropdown-menu" aria-labelledby="dropdown-a">
						<c:forEach var="category" items="${categories }">
							<a class="dropdown-item"
								href="${pageContext.request.contextPath}/user/course/index?categoryId=${category.categoryId }">${category.title }
							</a>
						</c:forEach>

					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown-a"
					data-toggle="dropdown">Blog </a>
					<div class="dropdown-menu" aria-labelledby="dropdown-a">
						<a class="dropdown-item" href="blog.html">Blog </a> <a
							class="dropdown-item" href="blog-single.html">Blog single </a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/user/teacher">Teachers</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/user/pricing">Pricing</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/user/contact">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="hover-btn-new log orange" href="#"
					data-toggle="modal" data-target="#login"><span>Book Now</span></a></li>
			</ul>
		</div>
	</div>
</nav>