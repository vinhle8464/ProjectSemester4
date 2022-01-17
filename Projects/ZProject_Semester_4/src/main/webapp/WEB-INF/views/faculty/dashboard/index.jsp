<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<mt:layout_admin title="Faculty - Dashboard">

	<jsp:attribute name="content">
<%-- 
<script type="text/javascript">
    // when page is ready
    $(document).ready(function() {
         // on form submit
        $("#form").on('submit', function() {
            // to each unchecked checkbox
            $(this + 'input[type=checkbox]:not(:checked)').each(function () {
                // set value 0 and check it
                $(this).attr('checked', true).val(0);
            });
        })
    })
</script> --%>

	<form method="get"
			action="${pageContext.request.contextPath }/faculty/dashboard/test"> 
		<input type="hidden" name="answerStatusSingle" value="0" />	
		<input type="radio" name="answerStatusSingle" value="1">
		
    		<input type="hidden" name="answerStatusSingle" value="0" />   
		<input type="radio" name="answerStatusSingle" value="1">
    		
    		<input type="hidden" name="answerStatusSingle" value="0" />   
		<input type="radio" name="answerStatusSingle" value="1">
    		
    		<input type="hidden" name="answerStatusSingle" value="0" />   
		<input type="radio" name="answerStatusSingle" value="1">	 
		
		<input type="submit" class="btn btn-success" value="save">
	</form>
	</jsp:attribute>
</mt:layout_admin>