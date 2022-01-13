<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<mt:layout_user title="Course">

	<jsp:attribute name="content">
		
	
	<div class="all-title-box">
		<div class="container text-center">
			<h1>Course Grid 4<span class="m_1">Lorem Ipsum dolroin gravida nibh vel velit.</span>
				</h1>
		</div>
	</div>
	
    <div id="overviews" class="section wb">
        <div class="container">
            <div class="section-title row text-center">
                <div class="col-md-8 offset-md-2">
                    <p class="lead">Lorem Ipsum dolroin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem!</p>
                </div>
            </div>
				<!-- end title -->

            <hr class="invis"> 

            <div class="row"> 
            <c:forEach var="quiz" items="${quizs}" varStatus="i">
					
                <div class="col-lg-3 col-md-6 col-12">
                    <div class="course-item">
						<div class="image-blog">
							<img
										src="${pageContext.request.contextPath}/assets/uploads/${quiz.image}"
										alt="" class="img-fluid">
						</div>
						<div class="course-br">
							<div class="course-title">
								<h2>
											<a href="#" title="">${quiz.title}</a>
										</h2>
							</div>
							<div class="course-desc">
								<p>${quiz.description} </p>
							</div>
							<div class="course-rating">
								 <a style="color:black;" href="#" class="hover-btn-new orange"><span>Take Test</span></a> 						
							</div>
						</div>
						<div class="course-meta-bot">
							<ul>
								<li><i class="fa fa-calendar" aria-hidden="true"></i>${quiz.timer} minutes</li>
								<li><i class="fa fa-users" aria-hidden="true"></i>${quiz.times} Times</li>
								<li><i class="fa fa-book" aria-hidden="true"></i>${quiz.fee ? "Purchase" : "Free"} </li>
							</ul>
						</div>
					</div>
                </div>
						<!-- end col -->
</c:forEach>
             
            </div>
				<!-- end row -->
        </div>
			<!-- end container -->
    </div>
		<!-- end section -->

    <div class="parallax section dbcolor">
        <div class="container">
            <div class="row logos">
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img
							src="${pageContext.request.contextPath}/resources/user/images/logo_01.png"
							alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img
							src="${pageContext.request.contextPath}/resources/user/images/logo_02.png"
							alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img
							src="${pageContext.request.contextPath}/resources/user/images/logo_03.png"
							alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img
							src="${pageContext.request.contextPath}/resources/user/images/logo_04.png"
							alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img
							src="${pageContext.request.contextPath}/resources/user/images/logo_05.png"
							alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img
							src="${pageContext.request.contextPath}/resources/user/images/logo_06.png"
							alt="" class="img-repsonsive"></a>
                </div>
            </div>
				<!-- end row -->
        </div>
			<!-- end container -->
    </div>
		<!-- end section -->

	</jsp:attribute>
</mt:layout_user>