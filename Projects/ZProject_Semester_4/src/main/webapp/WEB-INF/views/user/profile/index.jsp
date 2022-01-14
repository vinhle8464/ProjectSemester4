<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<mt:layout_user title="Profile">
	
	<jsp:attribute name="content">
		
		
	<div class="all-title-box-profile">
		<div class="container text-center">
			<h1>Profile<span class="m_1"></span></h1>
		</div>
	</div>
	
    <div id="contact" class="section wb">
        <div class="container" style="max-width: 1350px;">
            <div class="section-title text-center">
                <h3>User's information</h3>
                <p class="lead">You can edit yourself information</p>
            </div><!-- end title -->
                    <!-- Main content -->
				    <section class="content">
				      <div class="container-fluid">
				        <div class="row">
				          <div class="col-md-3">
				
				            <!-- Profile Image -->
				            <div class="card card-primary card-outline">
				              <div class="card-body box-profile">
				                <div class="text-center">
				                  <img class="profile-user-img img-fluid img-circle"
				                       src="${pageContext.request.contextPath}/assets/uploads/${accountProfile.avatar}"
				                       alt="User profile picture">
				                </div>
				
				                <h3 class="profile-username text-center">${accountProfile.fullname}</h3>
				
				                <p class="text-muted text-center">${accountProfile.addr}</p>
				
				                <ul class="list-group list-group-unbordered mb-3">
				                  <li class="list-group-item">
				                    <b>Followers</b> <a class="float-right">1,322</a>
				                  </li>
				                  <li class="list-group-item">
				                    <b>Following</b> <a class="float-right">543</a>
				                  </li>
				                  <li class="list-group-item">
				                    <b>Friends</b> <a class="float-right">13,287</a>
				                  </li>
				                </ul>
				
				                <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
				              </div>
				              <!-- /.card-body -->
				            </div>
				            <!-- /.card -->
				
				            <!-- About Me Box -->
				            <div class="card card-primary">
				              <div class="card-header">
				                <h3 class="card-title">About Me</h3>
				              </div>
				              <!-- /.card-header -->
				              <div class="card-body">
				                <strong><i class="fas fa-book mr-1"></i> Education</strong>
				
				                <p class="text-muted">
				                  B.S. in Computer Science from the University of Tennessee at Knoxville
				                </p>
				
				                <hr>
				
				                <strong><i class="fas fa-map-marker-alt mr-1"></i> Location</strong>
				
				                <p class="text-muted">Malibu, California</p>
				
				                <hr>
				
				                <strong><i class="fas fa-pencil-alt mr-1"></i> Skills</strong>
				
				                <p class="text-muted">
				                  <span class="tag tag-danger">UI Design</span>
				                  <span class="tag tag-success">Coding</span>
				                  <span class="tag tag-info">Javascript</span>
				                  <span class="tag tag-warning">PHP</span>
				                  <span class="tag tag-primary">Node.js</span>
				                </p>
				
				                <hr>
				
				                <strong><i class="far fa-file-alt mr-1"></i> Notes</strong>
				
				                <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
				              </div>
				              <!-- /.card-body -->
				            </div>
				            <!-- /.card -->
				          </div>
				          <!-- /.col -->
				          <div class="col-md-9">
				            <div class="card">
				              <div class="card-header p-2">
				                <ul class="nav nav-pills">
				                  <li class="nav-item"><a class="nav-link active" href="#activity" data-toggle="tab">Information</a></li>
				                  <li class="nav-item"><a class="nav-link" href="#settings" data-toggle="tab">Settings</a></li>
				                </ul>
				              </div><!-- /.card-header -->
				              <div class="card-body">
				                <div class="tab-content">
				                  <div class="active tab-pane" id="activity" style="font-size: 1.5rem; font-family: cursive; padding-left: 10%;
    color: darkblue;">
				                  	<form class="form-horizontal">
				                      <div class="form-group row">
				                        <label for="inputName" class="col-sm-4 col-form-label">Username:</label>
				                        <div class="col-sm-8">
				                          ${accountProfile.username}
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputEmail" class="col-sm-4 col-form-label">Fullname:</label>
				                        <div class="col-sm-8">
				                          ${accountProfile.fullname}
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputName2" class="col-sm-4 col-form-label">Email:</label>
				                        <div class="col-sm-8">
				                          ${accountProfile.email}
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputExperience" class="col-sm-4 col-form-label">Birthday:</label>
				                        <div class="col-sm-8">
				                          ${accountProfile.dob}
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputSkills" class="col-sm-4 col-form-label">Address:</label>
				                        <div class="col-sm-8">
				                          ${accountProfile.addr}
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputName" class="col-sm-4 col-form-label">Phone:</label>
				                        <div class="col-sm-8">
				                          ${accountProfile.phone}
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputName" class="col-sm-4 col-form-label">Gender:</label>
				                        <div class="col-sm-8">
				                          ${accountProfile.gender? "Male" : "Female"}
				                        </div>
				                      </div>
				                      
				                    </form>
				                  </div>
				                  <!-- /.tab-pane -->
				
				                  <div class="tab-pane" id="settings">
				                    <form class="form-horizontal">
				                      <div class="form-group row">
				                        <label for="inputName" class="col-sm-2 col-form-label">Name</label>
				                        <div class="col-sm-10">
				                          <input type="email" class="form-control" id="inputName" placeholder="Name">
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
				                        <div class="col-sm-10">
				                          <input type="email" class="form-control" id="inputEmail" placeholder="Email">
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputName2" class="col-sm-2 col-form-label">Name</label>
				                        <div class="col-sm-10">
				                          <input type="text" class="form-control" id="inputName2" placeholder="Name">
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputExperience" class="col-sm-2 col-form-label">Experience</label>
				                        <div class="col-sm-10">
				                          <textarea class="form-control" id="inputExperience" placeholder="Experience"></textarea>
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <label for="inputSkills" class="col-sm-2 col-form-label">Skills</label>
				                        <div class="col-sm-10">
				                          <input type="text" class="form-control" id="inputSkills" placeholder="Skills">
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <div class="offset-sm-2 col-sm-10">
				                          <div class="checkbox">
				                            <label>
				                              <input type="checkbox"> I agree to the <a href="#">terms and conditions</a>
				                            </label>
				                          </div>
				                        </div>
				                      </div>
				                      <div class="form-group row">
				                        <div class="offset-sm-2 col-sm-10">
				                          <button type="submit" class="btn btn-danger">Submit</button>
				                        </div>
				                      </div>
				                    </form>
				                  </div>
				                  <!-- /.tab-pane -->
				                </div>
				                <!-- /.tab-content -->
				              </div><!-- /.card-body -->
				            </div>
				            <!-- /.card -->
				          </div>
				          <!-- /.col -->
				        </div>
				        <!-- /.row -->
				      </div><!-- /.container-fluid -->
				    </section>
				    <!-- /.content -->
        </div><!-- end container -->
    </div><!-- end section -->
	
	<div class="parallax section dbcolor">
        <div class="container">
            <div class="row logos">
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img src="${pageContext.request.contextPath }/resources/user/images/logo_01.png" alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img src="${pageContext.request.contextPath }/resources/user/images/logo_02.png" alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img src="${pageContext.request.contextPath }/resources/user/images/logo_03.png" alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img src="${pageContext.request.contextPath }/resources/user/images/logo_04.png" alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img src="${pageContext.request.contextPath }/resources/user/images/logo_05.png" alt="" class="img-repsonsive"></a>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-6 wow fadeInUp">
                    <a href="#"><img src="${pageContext.request.contextPath }/resources/user/images/logo_06.png" alt="" class="img-repsonsive"></a>
                </div>
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end section -->

	</jsp:attribute>
</mt:layout_user>

