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
        	<div class="test_body">
	        	<div class="row"> 
	         		<div class="quiz_title">
	         			<h2>${quiz.title}</h2>
	         		</div>             
	            </div>
	            <input type="hidden" id="timer" value="${quiz.timer }">
	            <form id="formquiz" method="post"
						action="${pageContext.request.contextPath }/user/course/endtest?quizId=${quiz.quizId}">
	            <c:forEach var="question" items="${quiz.questions}"
							varStatus="i">
		            <div class="row"> 
		           <input type="hidden" id="timersubmit" name="timersubmit">
		         		<div class="quiz_content">
		         			<div>
		         				<h3>Question ${i.index + 1 }:</h3>
		         				<p>${question.title}</p>
		         				<input type="hidden" name="questionId"
											value="${question.questionId }">
								
		         			</div>
		         			<div>
		         				  <c:forEach var="answer" items="${question.answers}"
											varStatus="t">   
											<c:choose>
									<c:when test="${question.typeAnswerChoice == 'checkbox' }">
	     							<c:choose>	<c:when test="${answer.answerStatus == true }">
	     
		         				<div>
		         					<input type="checkbox" name="answer${i.index }"
															value="${answer.answerId}"> <span class="text-primary">${answer.title }</span>  <i class="text-primary fa fa-check-square-o " aria-hidden="true"></i>
									
		         				</div>
		         				</c:when></c:choose> 
		         				 	 	</c:when>
		         				 	 	<c:when test="${question.typeAnswerChoice == 'radio' }">
	   <c:choose>
		         				 	   <c:when test="${answer.answerStatus == true }">
	     
		         				<div>
		         					<input type=radio name="answer${i.index }"
															value="${answer.answerId}"> <span class="text-primary">${answer.title }</span> <i class="text-primary fa fa-check-square-o " aria-hidden="true"></i>
									
		         				</div>
		         				</c:when>
		         				</c:choose> 
		         				 	 	</c:when>
		        					
		         				 	</c:choose>  
        
		         				 
						</c:forEach>
		         			
				</div>
		         			<hr> 
		         		</div> 
		         		           
		            </div>
		            </c:forEach>
		           
		            <div class="btn_submit">
		             <input class="hover-btn-new orange" type="submit"
				value="submit">
		            </div>
		           
	            </form>
						<!-- end col -->
			</div>	
        </div>
			<!-- end container -->
    </div>
		<!-- end section -->

   

	</jsp:attribute>
</mt:layout_user>