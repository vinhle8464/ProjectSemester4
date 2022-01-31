<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<mt:layout_admin title="Rating">

	<jsp:attribute name="content">

<link rel="stylesheet"
			href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	<script type="text/javascript">
		
		/* function getSwitch(roleId){
			
			$.ajax({
					type : 'GET',
					url : '${pageContext.request.contextPath }/admin/ajax/checkStatusRole',
					data : {
						roleId: roleId
					},
					success: function(role) {
						
					}
			 });
		} */
	</script>
		 <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Rating Page</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Rating Page</li>
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
	          <h3 class="card-title">Manage List Rating</h3>
	
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
				<form method="get" action="${pageContext.request.contextPath}/admin/rating/search">
					<div class="row">
						<div class="col-sm-2">
							<h2>Manage <b>Ratings</b></h2>
						</div>
						<div class="col-sm-7">
							<input type="text" class="form-control" placeholder="Title or Username..." name="keyword">
							
						</div>
						<div class="col-sm-1">
							<input type="submit" value="Search" class="btn btn-primary">
						</div>
						<div class="col-sm-2">
							<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Role</span></a>
													
						</div>
					</div>
				</form>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th> <a href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=ratingId">Rating ID</a></th>
							<th><a href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=account.fullname">Account's fullname</a></th>
							<th><a href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=quiz.title">Quiz's title</a></th>
							<th><a href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=star">Star</a></th>
							<th><a href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=createDate">Date Create</a></th>
						</tr>
					</thead>
					<tbody>
	
	      
	    			  <c:choose>
	        <c:when test="${ratings.size() > 0 }">
					<c:forEach var="rating" items="${ratings}" varStatus="i">
						<tr>
							<td width="150px">${rating.ratingId }</td>
							<td>${rating.account.fullname }</td>
							<td>${rating.quiz.title }</td>
							<td width="200px">${rating.star }</td>
							<td width="330px"><fmt:formatDate var="createDate" value="${rating.createDate}"
														pattern="dd/MM/yyyy HH:mm:ss" />
									${createDate }</td>
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
	
	    <c:if test="${ratings.size() > 0 }">
	        <div class="panel-footer">
	 
			<select style="color: #566787;" name="pageSize"
													onchange="location = this.value;">
			 <option value="">PageSize</option>
			 <option
														value="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=1&pageSize=5&sort=${sort}">5</option>
			 <option
														value="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=1&pageSize=10&sort=${sort}">10</option>
			 <option
														value="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=1&pageSize=25&sort=${sort}">25</option>
			  <option
														value="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=1&pageSize=50&sort=${sort}">50</option>
			</select>
	
		&nbsp;&nbsp;
		<span>Showing <strong>${currentPage > 1 ? currentPage * pageSize - pageSize : 1}</strong> to <strong>${pageSize * currentPage}</strong> out of <b>${totalElements}</b> entries</span>
	         
	            <ul class="pagination">
	            			<li
														class="${currentPage > 1 ? 'page-item' : 'page-item disabled'}">
	                        <a
														href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=1&pageSize=${pageSize}&sort=${sort}"
														class="page-link">First</a>
	                    </li>
	                    
	                     <li
														class="${currentPage > 1 ? 'page-item' : 'page-item disabled'}">
	                        <a
														href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${currentPage - 1}&pageSize=${pageSize}&sort=${sort}"
														class="page-link">Previous</a>
	                    </li>
	                    
	                    
	                 <!--  // start number of page -->
	                 
	                    <!--   //  totalpage <= 5 -->
	          
	             
	                 <c:if test="${totalPages <= 5 && currentPage <= 5 }">
		                <c:forEach begin="0" end="${totalPages - 1}" var="page">
		                    <li
																class="${currentPage == page + 1 ? 'page-item active' : 'page-item' }">
		                        <a
																href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${page + 1}&pageSize=${pageSize}&sort=${sort}"
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
																href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${page + 1}&pageSize=${pageSize}&sort=${sort}"
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
																href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${page1}&pageSize=${pageSize}&sort=${sort}"
																class="page-link">${page1}</a>
			                    </li>
			                </c:forEach>
		                   
		                 <li class="page-item active">
		                        <a
															href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${currentPage}&pageSize=${pageSize}&sort=${sort}"
															class="page-link">${currentPage}</a>
		                    </li>
		               	  <c:forEach begin="${currentPage}"
															end="${currentPage <= totalPages - 2 ? currentPage + 1 : currentPage}"
															var="page2">
		                    <li
																class="${currentPage == page2 + 1 ? 'page-item active' : 'page-item' }">
		                        <a
																href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${page2 + 1}&pageSize=${pageSize}&sort=${sort}"
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
																href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${page + 1}&pageSize=${pageSize}&sort=${sort}"
																class="page-link">${page+1}</a>
			                    </li>
			                </c:forEach>
	               		</c:if>
	                 
	                  <!--  // end number of page -->
	              
	                     <li
														class="${currentPage < totalPages ? 'page-item' : 'page-item disabled'}">
	                        <a
														href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${currentPage + 1}&pageSize=${pageSize}&sort=${sort}"
														class="page-link">Next</a>
	                    </li>
	                      <li
														class="${currentPage < totalPages ? 'page-item' : 'page-item disabled'}">
	                        <a
														href="${pageContext.request.contextPath}/admin/rating/pagination?currentPage=${totalPages }&pageSize=${pageSize}&sort=${sort}"
														class="page-link">Last</a>
	                    </li>
	            </ul>
	        </div>
	    </c:if>
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