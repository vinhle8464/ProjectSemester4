<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<mt:layout_admin title="Faculty - Dashboard">

	<jsp:attribute name="content">

	
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	$(document).on('click','.addAnswer',function() {
		
	 	var $div = ' <div><br><input name="answerTitle">	True: <input type="checkbox" name="answerStatus" value="1"> &nbsp; False: <input type="checkbox" name="answerStatus" value="0"> &nbsp;	&nbsp;	&nbsp;<input type="button" value="Remove Answer" class="removeAnswer"></div></div>';
	 	$("#answers").append($div);
	});

	$(document).on('click','.removeAnswer',function() {
	 	$(this).parent('div').remove();
	});

	</script>
	

	<div>
		<button class="addAnswer">add new answer</button>
		  
	<s:form
				action="${pageContext.request.contextPath }/faculty/dashboard/test2"
				method="POST" modelAttribute="questionAnswer">
Question
			<s:input path="question.title" />
			<s:input path="question.explainDetail" />
 			
 		 	<input type="hidden" name="quizId" value="1">	
		  	<hr>
		  	<div id="answers">
		  	ANswers: 
		  		<div>
		  		<br>
		  		<input name="answerTitle">	
		  		
 		   		True: <input type="checkbox" name="answerStatus" value="1"> &nbsp;	
 		   		False: <input type="checkbox" name="answerStatus" value="0"> &nbsp;	&nbsp;	&nbsp;	
 		   		<input type="button"
					value="Remove Answer" class="removeAnswer">
 		   		</div>
		  	
		  	<div>
		  	<br>
		  		<input name="answerTitle">	
		  		
 		   		True: <input type="checkbox" name="answerStatus" value="1"> &nbsp;	
 		   		False: <input type="checkbox" name="answerStatus" value="0"> &nbsp;	&nbsp;	&nbsp;	
 		   		<input type="button"
					value="Remove Answer" class="removeAnswer">
 		   		</div>
		  
		  		<div>
		  			<br>
		  		<input name="answerTitle">	
		  		
 		   		True: <input type="checkbox" name="answerStatus" value="1"> &nbsp;	
 		   		False: <input type="checkbox" name="answerStatus" value="0"> &nbsp;	&nbsp;	&nbsp;	
 		   	<input type="button"
					value="Remove Answer" class="removeAnswer">
 		   		</div>
		  
		  </div>
	
		  	<input type="submit" value="Submit" />
	
			
			</s:form>
	
	</div>
	
	
	<div>
	
	
	</div>
	</jsp:attribute>
</mt:layout_admin>