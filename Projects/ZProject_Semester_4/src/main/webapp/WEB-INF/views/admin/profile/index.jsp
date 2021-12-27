<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>



<mt:layout_admin title="Profile">
	<jsp:attribute name="content">
		 <link
			href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
			rel="stylesheet" id="bootstrap-css">
		 <link
			href="${pageContext.request.contextPath}/resources/admin/css/styleProfile.css"
			rel="stylesheet">
		<script
			src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script
			src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-12 cover">
		                <div class="media align-items-end profile-head">
		                    <div class="profile mr-5">
								<img src="${pageContext.request.contextPath}/assets/uploads/${account.avatar}"
									alt="..." width="200" class="rounded mb-1 img-thumbnail"><a
									href="#" class="btn btn-outline-dark btn-sm btn-block">Edit profile</a>
							</div>
		                    <div class="media-body mb-5 text-white">
		                        <h1 class="mt-0 mb-0">${account.fullname }</h1>
		                        <h4 class="mb-4"> <i
										class="fas fa-map-marker-alt mr-2"></i>${account.addr }</h4>
		                    </div>
		                </div>
		            </div>
                </div>
                <div class="row" style="margin-top: 10%">
                    <div class="col-md-4">
                        <div class="profile-work">
                            <p>WORK LINK</p>
                            <a href="">Website Link</a><br />
                            <a href="">Bootsnipp Profile</a><br />
                            <a href="">Bootply Profile</a>
                            <p>SKILLS</p>
                            <a href="">Web Designer</a><br />
                            <a href="">Web Developer</a><br />
                            <a href="">WordPress</a><br />
                            <a href="">WooCommerce</a><br />
                            <a href="">PHP, .Net</a><br />
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab"
							id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                 <div class="row">
                                      <div class="col-md-4">
                                      		<label>Username</label>
                                      </div>
                                      <div class="col-md-8">
                                      		<p>${account.username }</p>
                                      </div>
                                 </div>
                                 <div class="row">
                                      <div class="col-md-4">
                                      		<label>Fullname</label>
                                      </div>
                                      <div class="col-md-8">
                                      		<p>${account.fullname }</p>
                                      </div>
                                 </div>
                                 <div class="row">
                                      <div class="col-md-4">
                                      		<label>Email</label>
                                      </div>
                                      <div class="col-md-8">
                                      		<p>${account.email }</p>
                                      </div>
                                 </div>
                                 <div class="row">
                                      <div class="col-md-4">
                                      		<label>Phone</label>
                                      </div>
                                      <div class="col-md-8">
                                      		<p>${account.phone }</p>
                                      </div>
                                 </div>   
                                 <div class="row">
                                      <div class="col-md-4">
                                      		<label>Birthday</label>
                                      </div>
                                      <div class="col-md-8">
                                      		<p>${account.dob }</p>
                                      </div>
                                 </div>
                                 <div class="row">
                                      <div class="col-md-4">
                                      		<label>Address</label>
                                      </div>
                                      <div class="col-md-8">
                                      		<p>${account.addr }</p>
                                      </div>
                                 </div>      
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
	</jsp:attribute>
</mt:layout_admin>