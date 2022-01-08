<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<mt:layout_user title="About">
	
	<jsp:attribute name="content">
		
		
	<div class="all-title-box">
		<div class="container text-center">
			<h1>Contact<span class="m_1">Lorem Ipsum dolroin gravida nibh vel velit.</span></h1>
		</div>
	</div>
	
    <div id="contact" class="section wb">
        <div class="container">
            <div class="section-title text-center">
                <h3>Need Help? Sure we are Online!</h3>
                <p class="lead">Let us give you more details about the special offer website you want us. Please fill out the form below. <br>We have million of website owners who happy to work with us!</p>
            </div><!-- end title -->
			<div>
				<h3>${msg }</h3>
			</div>
            <div class="row">
                <div class="col-xl-6 col-md-12 col-sm-12">
                    <div class="contact_form">
                        <div id="message"></div>
                        <p style="color: red">* Please enter your correct email, if it is wrong, you will not receive a feedback letter, thank you !!!</p>
                        <s:form method="post" modelAttribute="email" action="${pageContext.request.contextPath }/user/contact/sendContact">
                            <div class="row row-fluid">
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <s:input path="fullname" class="form-control" placeholder="Fullname"/>
                                </div>
                               <div class="col-lg-12 col-md-12 col-sm-12">
                                    <s:input path="emailUser" name="email" class="form-control" placeholder="Your Email"/>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <s:input path="phoneNumber" name="phone" class="form-control" placeholder="Your Phone"/>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <s:input path="title" name="title" class="form-control" placeholder="Title"/>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12">
                                	<s:textarea path="content" name="content" class="form-control" rows="6" placeholder="Give us more details.."/>
                                </div>
                                <div class="text-center pd">
                                    <input type="submit" value="SEND" class="btn btn-light btn-radius btn-brd grd1 btn-block">Get a Quote</button>
                                </div>
                            </div>
                        </s:form>
                    </div>
                </div><!-- end col -->
				<div class="col-xl-6 col-md-12 col-sm-12">
					<div class="map-box">
						<div id="custom-places" class="small-map"></div>
					</div>
				</div>
            </div><!-- end row -->
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

