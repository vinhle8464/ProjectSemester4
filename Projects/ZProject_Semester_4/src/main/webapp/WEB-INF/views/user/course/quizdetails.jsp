<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<mt:layout_user title="Course">

	<jsp:attribute name="content">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <div id="overviews" class="section wb">
        <div class="container">
        		   <div class="row"> 
         	        <div class="col-lg-12 col-md-12 col-12 padding_zero quiz_details"> 
	                	<div class="course-item row"> 
	                		  <div class="col-lg-4 col-md-4 col-4 padding_zero">
	                		   	<div class="image-blog">
							<img src="${pageContext.request.contextPath}/assets/uploads/${quiz.image}" alt="" class="img-fluid">
					</div>
					
					
							
					<div class="course-rating" align="center">
									 <a style="color: black;"
										href="${pageContext.request.contextPath}/user/course/quizdetails?quizId=${quiz.quizId}"
										class="hover-btn-new orange"><span>Start Test</span></a> 						
								</div>
	                		  </div> 
	              <div class="col-lg-8 col-md-8 col-8 padding_zero">
							          
	                	<div class="course-br">
	                	
								<div class="course-title">
									<h2>
												<a
											href="${pageContext.request.contextPath}/user/course/quizdetails?quizId=${quiz.quizId}"
											title="">${quiz.title.length() > 130 ? quiz.title.substring(0, 130) += '...' :  quiz.title}</a>
											</h2>
								</div>
								<div class="course-meta-bot">
								<ul>
									<li><i class="fa fa-calendar" aria-hidden="true"></i> &nbsp; ${quiz.timer}  Minutes &nbsp; |</li>
									<li><i class="fa fa-users" aria-hidden="true"></i> &nbsp; ${quiz.times} Times &nbsp; |</li>
									<li style="${quiz.fee ? 'color:red;' : 'color:green;'}"><i
										class="fa fa-dollar" aria-hidden="true"></i> &nbsp; ${quiz.fee ? "Purchase" : "Free"} &nbsp; |</li>
										<li style="${quiz.fee ? 'color:red;' : 'color:green;'}"><i
										class="fa fa-question-circle" aria-hidden="true"></i> &nbsp; ${quiz.questions.size()} Questions</li>
								</ul>
								
							</div>
								<div class="course-desc">
									<p>${quiz.description.length() > 220 ? quiz.description.substring(0, 220) += '...' :  quiz.description}</p>
								</div>
							
							</div>
							
							</div>
	                		  
	     
							
	                	</div>
                </div>
                 </div>
						<!-- end col -->
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