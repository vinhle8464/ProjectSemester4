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
	         			<h2>Review ${quiz.title}</h2>
	         		</div>             
	            </div>
	            <input type="hidden" id="timer" value="${quiz.timer }">
	            <form id="formquiz" method="post"
						action="${pageContext.request.contextPath }/user/course/endtest?quizId=${quiz.quizId}">
					
			<c:forEach var="questionId" items="${listQuestionId}" varStatus="i">	 
	            <c:forEach var="question" items="${quiz.questions}">
	            		<c:choose>
		         				<c:when test="${question.questionId == questionId }">
		         				
		         		
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
		         			 
		         			<c:forEach var="answer" items="${question.answers}" varStatus="a">
		         				<c:choose>
	     															
						 			<c:when test="${answer.answerId == listAnswerId[a.index] }">
	     						
	             				<div>
	             				<input type="checkbox" name="answer${a.index }"
														value="${answer.answerId}" checked> <span
														class="${answer.answerStatus == true ? 'text-primary' : ''}">${answer.title }</span> &nbsp; ${answer.answerStatus == true ? '<i class="text-primary fa fa-check" aria-hidden="true"></i>' : ''}</div> 
									</c:when>
									 <c:otherwise>
       <div>
	             				<input type="checkbox" name="answer${a.index }"
														value="${answer.answerId}"> <span
														class="${answer.answerStatus == true ? 'text-primary' : ''}">${answer.title }</span> &nbsp; ${answer.answerStatus == true ? '<i class="text-primary fa fa-check" aria-hidden="true"></i>' : ''}</div> 
    									</c:otherwise>
								</c:choose>
														
														<%-- ${answer.answerId = answerId ? '<i class="fa fa-times" aria-hidden="true"></i>' : ''}  --%>
							</c:forEach>	
		         			</div>
		         			<hr> 
		         		</div>
		         			
		         			
		         			
		         		      
		          
		            </div>
		            </c:when>
		     </c:choose>
		            </c:forEach>
		           </c:forEach>
		         				  <%-- <c:forEach var="answer" items="${question.answers}"
											varStatus="t">  
											 
											<c:choose>
									<c:when test="${question.typeAnswerChoice == 'checkbox' }">
	     							<c:forEach var="answeIdd" items="${listAnswerId}"
														varStatus="i">
														${answeIdd }
							<c:choose>
	     															
						 			<c:when test="${answer.answerId == answeIdd }">
	     							
		         				<div>
		         					<input type="checkbox" name="answer${i.index }"
																		value="${answer.answerId}" checked> <span
																		class="${answer.answerStatus == true ? 'text-primary' : ''}" >${answer.title }</span>
																		${answer.answerStatus == true ? '<i class="text-primary fa fa-check" aria-hidden="true"></i>' : ''} ${answer.answerId = answerId ? '<i class="fa fa-times" aria-hidden="true"></i>' : ''} 
									
		         				</div>
		         					</c:when>
		         					
		         						</c:choose> 
						</c:forEach>
	     							
		         				
		         				 	 	</c:when>
		         				 	 	
		        					
		         				 	</c:choose>  
        
		         				 
						</c:forEach> --%>
		         			
				
		           
		          
		           
	            </form>
						<!-- end col -->
			</div>	
        </div>
			<!-- end container -->
    </div>
		<!-- end section -->

   

	</jsp:attribute>
</mt:layout_user>