<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<mt:layout_admin title="Faculty - Dashboard">

	<jsp:attribute name="content">

	
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	$(document).on('keydown', function (e) {
		  if (e.keyCode == 8 && $('input.question').is(":focus") && $('input.question').val().length < 10) {
		      e.preventDefault();
		  }
		  
		  if (e.keyCode == 8 && $('input.answer').is(":focus") && $('input.answer').val().length < 8) {
		      e.preventDefault();
		  }
		});

	</script>
	<div>
	 <form method="post" action="${pageContext.request.contextPath }/faculty/dashboard/testt">
	 	
	 	 question: <input name="questions" value="Question " class="question"/>
		  Explain: <textarea name="questions" value="Explain " class="question"></textarea> 
		
	  	 answer: <input name="questions" value="Answer " class="answer"/>
		 answer: <input name="questions" value="Answer " class="answer"/>
		 answer: <input name="questions" value="Answer " class="answer"/>
		 answer: <input name="questions" value="Answer " class="answer"/> 
		 <hr>
		 question: <input name="questions" value="Question " class="question"/>
		  Explain: <textarea name="questions" value="Explain " class="question"></textarea> 
		
	  	 answer: <input name="questions" value="Answer " class="answer"/>
		 answer: <input name="questions" value="Answer " class="answer"/>
		 answer: <input name="questions" value="Answer " class="answer"/>
		 answer: <input name="questions" value="Answer " class="answer"/> 
		
		 <hr> 
		 
		    <input type="hidden" name="quizId" value="1">	
		   <input type="submit" value="submit">	
		 </form> 		
	</div>
	</jsp:attribute>
</mt:layout_admin>