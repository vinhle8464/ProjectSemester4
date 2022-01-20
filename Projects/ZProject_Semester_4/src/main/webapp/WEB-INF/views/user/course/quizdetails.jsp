<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<mt:layout_user title="Course">

	<jsp:attribute name="content">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <div id="overviews" class="section wb">
        <div class="container">
        		 	    <div class="row"> 
         	
                <div class="col-lg-3 col-md-3 col-3 padding_zero">
                    <div class="course-item course_item_details">
						<div class="image-blog">
							<img
									src="${pageContext.request.contextPath}/assets/uploads/${quiz.image}"
									alt="" class="img-fluid">
						</div>
						<div>
						<ul>
						<li><i class="fa fa-question-circle" aria-hidden="true"></i> &nbsp;&nbsp;&nbsp; ${quiz.questions.size()} Questions</li>
								<li><i class="fa fa-clock-o" aria-hidden="true"></i> &nbsp;&nbsp;&nbsp; ${quiz.timer}  Minutes &nbsp;</li>
								<li><i class="fa fa-users" aria-hidden="true"></i> &nbsp;&nbsp; ${quiz.times} Times &nbsp;</li>
								<li style="${quiz.fee ? 'color:red;' : 'color:green;'} font-size: 20px;"><i
										class="fa fa-dollar" aria-hidden="true"></i> &nbsp;&nbsp; ${quiz.fee ? "Purchase" : "Free"} </li>
							</ul>
						</div>
						<div class="course-rating">
								 <a style="color: black;" href="${sessionScope.account == null  ?  '#' : pageContext.request.contextPath}/user/course/starttest?quizId=${quiz.quizId}"
										class="hover-btn-new orange" ${sessionScope.account == null ? 'data-toggle="modal" data-target="#login"' : '' }><span> Start Test</span></a> 						
							</div>
					</div>
                </div>
                <div class="col-lg-9 col-md-9 col-9 padding_zero">
                	<div class="course-item course_item_details_right"> 
                	
                	<div class="course-br">
							<div class="course-title">
								<h2>
											<a
											href="#"
											title="">${quiz.title.length() > 130 ? quiz.title.substring(0, 130) += '...' :  quiz.title}</a>
										</h2>
										<fmt:formatDate var="dateCreated" value="${quiz.dateCreated}" pattern="dd/MM/yyyy" />
				
						<li><i class="fa fa-calendar" aria-hidden="true"></i> &nbsp;&nbsp; ${dateCreated} &nbsp;</li></ul>
							</div>
							<div class="course-desc">
								<p>${quiz.description.length() > 500 ? quiz.description.substring(0, 500) += '...' :  quiz.description}</p>
							</div>
							
						</div>
						<div class="course_note">
							
							<div>
								<h4> Task time:</h4>
								<ul>
								 <li>Time will be counted when you select the "Start" button</li>
								</ul>
							</div>
							<div>
								<h4> While doing homework:</h4>
								<ul>
								 <li>If the picture and formula are not displayed, students can reload the worksheet</li>
								 <li>When the time is up to do the test, the system will automatically submit the work and calculate the score for the student</li>
								</ul>
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
	
		<!-- DIRECT CHAT -->
            <div class="card direct-chat direct-chat-primary container">
            	<c:if test="${sessionScope.account != null }">
            	<div class="stars">
            		<input type="radio" class="star star-5" id="star-5" name="star"/>
            		<label class="star star-5" for="star-5"></label>
            		<input type="radio" class="star star-4" id="star-4" name="star"/>
            		<label class="star star-5" for="star-4"></label>
            		<input type="radio" class="star star-3" id="star-3" name="star"/>
            		<label class="star star-5" for="star-3"></label>
            		<input type="radio" class="star star-2" id="star-2" name="star"/>
            		<label class="star star-5" for="star-2"></label>
            		<input type="radio" class="star star-1" id="star-1" name="star"/>
            		<label class="star star-5" for="star-1"></label>
            	</div>
            	</c:if>
              <div class="card-header">
                <h3 class="card-title">Comment</h3>
              </div>
              <c:if test="${sessionScope.account != null }">
              <div class="card-footer">
                <form method="post" action="${pageContext.request.contextPath}/user/ratingcomment/sendComment" >
                  <div class="input-group">
                    <input type="text" name="message" placeholder="Type Message ..." class="form-control"/>
                    <input type="hidden" value="${quiz.quizId}" name="quizIdComment">
                    <span class="input-group-append">
                      <button type="submit" class="btn btn-primary">Send</button>
                    </span>
                  </div>
                </form>
              </div>
              </c:if>
              <div class="card-body">
                <c:forEach var="comment" items="${comments }">
                	<div class="direct-chat-messages">
	                  <div class="direct-chat-msg">
	                    <div class="direct-chat-infos clearfix">
	                      <span class="direct-chat-name float-left">${comment.account.fullname }</span>
	                      <span class="direct-chat-timestamp float-right">${comment.createDate }</span>
	                    </div>
	                    <img class="direct-chat-img" src="${pageContext.request.contextPath}/assets/uploads/${comment.account.avatar }" alt="message user image">
	                    
	                    <div class="direct-chat-text">
	                      ${comment.comment }
	                    </div>
	                  </div>
                </div>
                </c:forEach>

              </div>
              <!-- /.card-body -->
              
              <!-- /.card-footer-->
            </div>
            <!--/.direct-chat -->
	
	
	</jsp:attribute>
</mt:layout_user>