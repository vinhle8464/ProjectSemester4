<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<mt:layout_admin title="Quiz">

	<jsp:attribute name="content">

<link rel="stylesheet"
			href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<script type="text/javascript">
		
		function openDeleteModal(quizId) {
			$('#quizID').val(quizId);
		}
		/* function openEditModal(quizId) {
			$
					.ajax({
						type : 'GET',
						url : '${pageContext.request.contextPath }/faculty/ajax/findquizbyid',
						data : {
							quizId : quizId
						},
						success : function(quiz) {
							$('#quizId').val(quiz.quizId);
							$('#accountIdd').val(quiz.accountId);						
							$('#usernamee').val(quiz.username);		
							$('#quizmentt').val(quiz.quizment);
							$('#titlee').val(quiz.title);						
							$('#feee').val(quiz.fee);			
							$('#datePaidd').val(quiz.datePaid);
							$('#quizStatuss').val(quiz.quizStatus);							
						}
					});
		} */
	</script>
		 <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Quiz Page</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Quiz Page</li>
            </ol>
          </div>
        </div>
      </div>
			<!-- /.container-fluid -->
    </section>
		  <!-- Main content -->
    <section class="content">

      <!-- Default box -->
		<div class="card">
	        <div class="card-header">
	          <h3 class="card-title">Manage List Quizzes</h3>
	
	          <div class="card-tools">
	            <button type="button" class="btn btn-tool"
								data-card-widget="collapse" title="Collapse">
	              <i class="fas fa-minus"></i>
	            </button>
	           <!--  <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
	              <i class="fas fa-times"></i>
	            </button> -->
	          </div>
	        </div>
	    <div class="card-body">          
		<div class="">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>Manage <b>Quizzes</b></h2>
						</div>
						<div class="col-sm-6">
							<a href="#addEmployeeModal" class="btn btn-success"
													data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New quiz</span></a>
							<a href="#deleteEmployeeModal" class="btn btn-danger"
													data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>
								<span class="custom-checkbox">
									<input type="checkbox" id="selectAll">
									<label for="selectAll"></label>
								</span>
							</th>
							<th> <a
													href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=quizId">quizID</a></th>
							<th><a
													href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=account.username">Username</a></th>
							<th> <a
													href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=quizment">quizment</a></th>
													<th> <a
													href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=title">Title</a></th>
													<th> <a
													href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=fee">Fee</a></th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
	
	      
	    			  <c:choose>
	        <c:when test="${quizs.size() > 0 }">
					<c:forEach var="quiz" items="${quizs}">
						<tr>
							<td>
								<span class="custom-checkbox">
									<input type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
								</span>
							</td>
							<td>${quiz.quizId }</td>
							<td>${quiz.account.username }</td>
							<td>${quiz.quizment }</td>
							<td>${quiz.title }</td>
							<td>${quiz.fee }</td>
							
							<td>
								<a href="#editEmployeeModal" id="${quiz.quizId }"
																onclick="openEditModal(id);" class="edit"
																data-toggle="modal"><i class="material-icons"
																	data-toggle="tooltip" title="Edit">&#xE254;</i></a>
								<a href="#deleteEmployeeModal" id="${quiz.quizId }"
																onclick="openDeleteModal(id);" class="delete"
																data-toggle="modal"><i class="material-icons"
																	data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							</td>
						</tr>
						</c:forEach>
						  </c:when>
	        <c:otherwise>
	            <tr align="center">
	                <td colspan="5">No Users available</td>
	            </tr>
	        </c:otherwise>
	    </c:choose>
					</tbody>
				</table>
				
				
	<div>
	
	    <c:if test="${quizs.size() > 0 }">
	        <div class="panel-footer">
	 
			<select style="color: #566787;" name="pageSize"
													onchange="location = this.value;">
			 <option value="">PageSize</option>
			 <option
														value="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=1&pageSize=5&sort=${sort}">5</option>
			 <option
														value="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=1&pageSize=10&sort=${sort}">10</option>
			 <option
														value="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=1&pageSize=25&sort=${sort}">25</option>
			  <option
														value="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=1&pageSize=50&sort=${sort}">50</option>
			</select>
	
		&nbsp;&nbsp;
		<span>Showing <strong>${currentPage > 1 ? currentPage * pageSize - pageSize : 1}</strong> to <strong>${pageSize * currentPage}</strong> out of <b>${totalElements}</b> entries</span>
	         
	            <ul class="pagination">
	            			<li
														class="${currentPage > 1 ? 'page-item' : 'page-item disabled'}">
	                        <a
														href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=1&pageSize=${pageSize}&sort=${sort}"
														class="page-link">First</a>
	                    </li>
	                    
	                     <li
														class="${currentPage > 1 ? 'page-item' : 'page-item disabled'}">
	                        <a
														href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${currentPage - 1}&pageSize=${pageSize}&sort=${sort}"
														class="page-link">Previous</a>
	                    </li>
	                    
	                    
	                 <!--  // start number of page -->
	                 
	                    <!--   //  totalpage <= 5 -->
	          
	             
	                 <c:if test="${totalPages <= 5 && currentPage <= 5 }">
		                <c:forEach begin="0" end="${totalPages - 1}" var="page">
		                    <li
																class="${currentPage == page + 1 ? 'page-item active' : 'page-item' }">
		                        <a
																href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${page + 1}&pageSize=${pageSize}&sort=${sort}"
																class="page-link">${page+1}</a>
		                    </li>
		                </c:forEach>
		               
	                </c:if>
	              <!--   //  totalpage > 5 -->
	          
	                 <c:if test="${totalPages > 5 && currentPage <= 2 }">
		                <c:forEach begin="0" end="4" var="page">
		                    <li
																class="${currentPage == page + 1 ? 'page-item active' : 'page-item' }">
		                        <a
																href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${page + 1}&pageSize=${pageSize}&sort=${sort}"
																class="page-link">${page+1}</a>
		                    </li>
		                </c:forEach>
	                </c:if>
	              
	                   <c:if
														test="${totalPages > 5 && currentPage >= 3 && currentPage != totalPages}">
	                  	                
			              	<c:forEach
															begin="${currentPage <= totalPages - 2 ? currentPage - 2 : currentPage - 3}"
															end="${currentPage - 1}" var="page1">
			                    <li class="page-item">
			                        <a
																href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${page1}&pageSize=${pageSize}&sort=${sort}"
																class="page-link">${page1}</a>
			                    </li>
			                </c:forEach>
		                   
		                 <li class="page-item active">
		                        <a
															href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=${sort}"
															class="page-link">${currentPage}</a>
		                    </li>
		               	  <c:forEach begin="${currentPage}"
															end="${currentPage <= totalPages - 2 ? currentPage + 1 : currentPage}"
															var="page2">
		                    <li
																class="${currentPage == page2 + 1 ? 'page-item active' : 'page-item' }">
		                        <a
																href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${page2 + 1}&pageSize=${pageSize}&sort=${sort}"
																class="page-link">${page2 + 1}</a>
		                    </li>
		                </c:forEach> 
	                </c:if>
	                
	                   <!--   //  the last page -->
	          
	             
	            		    <c:if
														test="${currentPage == totalPages && totalPages > 5}">
			                <c:forEach begin="${totalPages - 5 }"
															end="${totalPages - 1}" var="page">
			                    <li
																class="${currentPage == page + 1 ? 'page-item active' : 'page-item' }">
			                        <a
																href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${page + 1}&pageSize=${pageSize}&sort=${sort}"
																class="page-link">${page+1}</a>
			                    </li>
			                </c:forEach>
	               		</c:if>
	                 
	                  <!--  // end number of page -->
	              
	                     <li
														class="${currentPage < totalPages ? 'page-item' : 'page-item disabled'}">
	                        <a
														href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${currentPage + 1}&pageSize=${pageSize}&sort=${sort}"
														class="page-link">Next</a>
	                    </li>
	                      <li
														class="${currentPage < totalPages ? 'page-item' : 'page-item disabled'}">
	                        <a
														href="${pageContext.request.contextPath}/faculty/quiz/pagination?currentPage=${totalPages }&pageSize=${pageSize}&sort=${sort}"
														class="page-link">Last</a>
	                    </li>
	            </ul>
	        </div>
	    </c:if>
	    </div>
		</div>        
	</div>


<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
		
			<s:form method="post" modelAttribute="quiz"
										action="${pageContext.request.contextPath }/faculty/quiz/create"
										enctype="multipart/form-data">
				
				<div class="modal-header">	
									
					<h4 class="modal-title">Add quiz</h4>
					<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											
				</div>
				<div class="modal-body">					
					<%-- <div class="form-group">
					<span style="color: red;">${msg==""?"": msg }</span> <br />
						<label>quiz-Name</label>
						<s:input path="quizName" type="text" class="form-control"
													required="required" />
				
					</div>
					<div class="form-group">
						<label>Description</label>
						<s:input path="description" type="text" class="form-control"
													required="required" />
					
					</div> --%>
					
									
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
												value="Cancel">
					<s:input type="submit" class="btn btn-success" value="save" path="" />
				</div>
			</s:form>
		</div>
	</div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
		<%-- <s:form method="post" modelAttribute="quiz"
										action="${pageContext.request.contextPath }/faculty/quiz/update"
										enctype="multipart/form-data">
				
				<div class="modal-header">	
									
					<h4 class="modal-title">quiz's Details </h4>
					<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											
				</div>
				<div class="modal-body">		
				<div class="form-group">
						<label>quizID</label>
						<s:input path="quizId" type="text" id="quizId"
													class="form-control" disabled="true" />
				
					</div>	
					<div class="form-group">
						<label>accountID</label>
						<s:input path="account.accountId" type="text" id="accountIdd"
													class="form-control" disabled="true" />
				
					</div>		
					<div class="form-group">
						<label>Username</label>
						<s:input path="account.username" type="text" id="usernamee"
													class="form-control" disabled="true" required="required" />
				
					</div>
				
					<div class="form-group">
						<label>quizment</label>
						<s:input path="quizment" type="text" id="quizmentt"
													class="form-control" required="required" />
					
					</div>	
						<div class="form-group">
						<label>Title</label>
						<s:input path="title" type="text" id="titlee"
													class="form-control" required="required" />
					
					</div>		<div class="form-group">
						<label>Fee</label>
						<s:input path="fee" type="text" id="feee"
													class="form-control" required="required" />
					
					</div>		<div class="form-group">
						<label>DatePaid</label>
						<s:input path="datePaid" type="text" id="datePaidd"
													class="form-control" required="required" />
					
					</div>	
							<div class="form-group">
						<label>quizStatus</label>
						<s:input path="quizStatus" type="text" id="quizStatuss"
													class="form-control" required="required" />
					
					</div>		
									
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
												value="Cancel">
					<s:input type="submit" class="btn btn-success" value="save" path="" />
				</div>
			</s:form> --%>
		</div>
	</div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form method="get"
										action="${pageContext.request.contextPath }/faculty/quiz/delete">
				<div class="modal-header">				
					<h4 class="modal-title">Delete quiz</h4>
					<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">					
					<p>Are you sure you want to delete these Records?</p>
					<p class="text-warning">
											<small>This action cannot be undone.</small>
										</p>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
												value="Cancel">
											<input type="hidden" name="quizID" id="quizID">
					<input type="submit" class="btn btn-danger" value="Delete">
				</div>
			</form>
		</div>
	</div>
</div>
        </div>
        <!-- /.card-body -->
        <div class="card-footer">
          Footer
        </div>
        <!-- /.card-footer-->
      	</div>

		</div>
	</section>

	</jsp:attribute>
</mt:layout_admin>