<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<mt:layout_user title="Course">

	<jsp:attribute name="content">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


<script>
	function startTimer(duration, display) {
		var timer = duration, minutes, seconds;
		setInterval(function() {
			minutes = parseInt(timer / 60, 10);
			seconds = parseInt(timer % 60, 10);

			minutes = minutes < 10 ? "0" + minutes : minutes;
			seconds = seconds < 10 ? "0" + seconds : seconds;

			display.textContent = minutes + ":" + seconds;

			if (--timer < 0) {
				timer = duration;
				document.getElementById('formquiz').submit();
			}
		}, 1000);
	}

	window.onload = function() {
		var timer = document.getElementById('timer').value;
		var fiveMinutes = 60 * timer, display = document.querySelector('#time');
		var fiveMinutes = 60 * timer, display = document.querySelector('#timersubmit');
		startTimer(fiveMinutes, display);
	};
	
	/* $('#formquiz').submit(function() {
	    alert('con khi');
	    var $time = $('#time').val();
		$('#timersubmit').val($time);
	    
	});
	
	$(document).on('submit','formquiz',function(){
		alert('con khi');
		}); */
</script>

	<div
			style="position: fixed; top: 6em; right: 1em; color: white; z-index: 9999999;">
	
<div
				style="background-color: #eea412; padding: 5px; border-radius: 5px;">
				<i class="fa fa-clock-o" aria-hidden="true"></i>  <span id="time">${quiz.timer }:00</span> minutes!</div>
	</div>
    <div id="overviews" class="section wb">
        <div class="container">
        	<div class="test_body">
	        	<div class="row"> 
	         		<div class="quiz_title">
	         			<h2>${quiz.title}</h2>
	         		</div>             
	            </div>
	            <input type="hidden" id="timer"
											value="${quiz.timer }">
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
		         				<div>
		         					<input type="radio" name="answer${i.index }"
													value="${t.index + 1}"> ${answer.title }
		         				</div>
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