<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<mt:layout_user title="Home">
	
	<jsp:attribute name="content">
	<div id="carouselExampleControls" class="carousel slide bs-slider box-slider" data-ride="carousel" data-pause="hover" data-interval="false" >
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleControls" data-slide-to="1"></li>
			<li data-target="#carouselExampleControls" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="carousel-item active">
				<div id="home" class="first-section" style="background-image:url('${pageContext.request.contextPath}/resources/user/images/slider-01.jpg');">
					<div class="dtab">
						<div class="container">
							<div class="row">
								<div class="col-md-12 col-sm-12 text-right">
									<div class="big-tagline">
										<h2><strong>Login MEMORY </strong>Online Quiz</h2>
										<h3 class="lead">DIVERSE - SMART - ACCURATE</h3>
											<a href="${pageContext.request.contextPath}/user/contact/index" class="hover-btn-new"><span>Contact Us</span></a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="#" class="hover-btn-new"><span>Read More</span></a>
									</div>
								</div>
							</div><!-- end row -->            
						</div><!-- end container -->
					</div>
				</div><!-- end section -->
			</div>
			<div class="carousel-item">
				<div id="home" class="first-section" style="background-image:url('${pageContext.request.contextPath}/resources/user/images/slider-02.jpg');">
					<div class="dtab">
						<div class="container">
							<div class="row">
								<div class="col-md-12 col-sm-12 text-left">
									<div class="big-tagline">
										<h2 data-animation="animated zoomInRight">Login MEMORY <strong>education school</strong></h2>
										<p class="lead" data-animation="animated fadeInLeft">With many quiz exercises will help you review and test in the most effective way. </p>
											<a href="${pageContext.request.contextPath}/user/contact/index" class="hover-btn-new"><span>Contact Us</span></a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="#" class="hover-btn-new"><span>Read More</span></a>
									</div>
								</div>
							</div><!-- end row -->            
						</div><!-- end container -->
					</div>
				</div><!-- end section -->
			</div>
			<div class="carousel-item">
				<div id="home" class="first-section" style="background-image:url('${pageContext.request.contextPath}/resources/user/images/slider-03.jpg');">
					<div class="dtab">
						<div class="container">
							<div class="row">
								<div class="col-md-12 col-sm-12 text-center">
									<div class="big-tagline">
										<h2 data-animation="animated zoomInRight"><strong>Login MEMORY</strong> Company</h2>
										<p class="lead" data-animation="animated fadeInLeft">1 IP included with each server 
											Your Choice of any OS (CentOS, Windows, Debian, Fedora)
											FREE Reboots</p>
											<a href="${pageContext.request.contextPath}/user/contact/index" class="hover-btn-new"><span>Contact Us</span></a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="#" class="hover-btn-new"><span>Read More</span></a>
									</div>
								</div>
							</div><!-- end row -->            
						</div><!-- end container -->
					</div>
				</div><!-- end section -->
			</div>
			<!-- Left Control -->
			<a class="new-effect carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
				<span class="fa fa-angle-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>

			<!-- Right Control -->
			<a class="new-effect carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
				<span class="fa fa-angle-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	
    <div id="overviews" class="section wb">
        <div class="container">
            <div class="section-title row text-center">
                <div class="col-md-8 offset-md-2">
                    <h3>WELCOME</h3>
                    <p class="lead">DIVERSE - SMART - ACCURATE</p>
                    <p>With many quiz exercises will help you review and test in the most effective way.</p>
                </div>
            </div><!-- end title -->
        
            <div class="row align-items-center">
                <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                    <div class="message-box">
                        <h4>2018 BEST SmartEDU education school</h4>
                        <h2>Welcome to MEMORY Online Quiz</h2>
                        <h3>Content diversity</h3>
                        <p>Provide a variety of multiple choice questions in a variety of fields.</p>
						<h3>Question matrix</h3>
						<p>The system will rely on a rich question matrix to synthesize itself into a multiple choice test.</p>
						<h3>Detailed answers</h3>
						<p>After completing the multiple choice test, the system will announce the score achieved with a detailed solution.</p>
                        <a href="#" class="hover-btn-new orange"><span>Learn More</span></a>
                    </div><!-- end messagebox -->
                </div><!-- end col -->
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                    <div class="post-media wow fadeIn">
                        <img src="${pageContext.request.contextPath}/resources/user/images/about_02.jpg" alt="" class="img-fluid img-rounded">
                    </div><!-- end media -->
                </div><!-- end col -->
			</div>
			<div class="row align-items-center">
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                    <div class="post-media wow fadeIn">
                        <img src="${pageContext.request.contextPath}/resources/user/images/dinhhuong2.jpg" alt="" class="img-fluid img-rounded">
                    </div><!-- end media -->
                </div><!-- end col -->
				
				<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                    <div class="message-box">
                        <h2>FUTURE  DIRECTION</h2>
                        <h3>University</h3>
                        <p>The online multiple choice question bank is full of university subjects, specialized subjects to help students review the exam to finish the course / credit at the university to achieve good results.</p>
						<h3>Career direction</h3>
                        <p>Question banking system and career multiple choice tests such as driver's license review, park officer test, personality test, MBTI Test, IQ/EQ Test.</p>

                        <a href="#" class="hover-btn-new orange"><span>Learn More</span></a>
                    </div><!-- end messagebox -->
                </div><!-- end col -->
				
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end section -->

    <section class="section lb page-section">
		<div class="container">
			 <div class="section-title row text-center">
                <div class="col-md-8 offset-md-2">
                    <h3>Our history</h3>
                    <p class="lead">Lorem Ipsum dolroin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem!</p>
                </div>
            </div><!-- end title -->
			<div class="timeline">
				<div class="timeline__wrap">
					<div class="timeline__items">
						<div class="timeline__item">
							<div class="timeline__content img-bg-01">
								<h2>2018</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-02">
								<h2>2015</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-03">
								<h2>2014</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-04">
								<h2>2012</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-01">
								<h2>2010</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-02">
								<h2>2007</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-03">
								<h2>2004</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
						<div class="timeline__item">
							<div class="timeline__content img-bg-04">
								<h2>2002</h2>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer dignissim neque condimentum lacus dapibus. Lorem
									ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="section cl">
		<div class="container">
			<div class="row text-left stat-wrap">
				<div class="col-md-4 col-sm-4 col-xs-12">
					<span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-study"></i></span>
					<!-- <p class="stat_count">1000</p> -->
					<p class="stat_count">${sessionScope.counta }</p>
					<h3>Students</h3>
				</div><!-- end col -->

				<div class="col-md-4 col-sm-4 col-xs-12">
					<span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-online"></i></span>
					<p class="stat_count">240</p>
					<h3>Courses</h3>
				</div><!-- end col -->

				<div class="col-md-4 col-sm-4 col-xs-12">
					<span data-scroll class="global-radius icon_wrap effect-1 alignleft"><i class="flaticon-years"></i></span>
					<p class="stat_count">55</p>
					<h3>Years Completed</h3>
				</div><!-- end col -->
			</div><!-- end row -->
		</div><!-- end container -->
	</div><!-- end section -->

    <div id="plan" class="section lb">
        <div class="container">
            <div class="section-title text-center">
                <h3>Choose Your Plan</h3>
                <p>Lorem ipsum dolor sit aet, consectetur adipisicing lit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
            </div><!-- end title -->

            <div class="row">
	                <div class="col-md-6 offset-md-3">
	                    <div class="message-box">
	                        <ul class="nav nav-pills nav-stacked"
									id="myTabs">
	                            <li><a class="active" href="#tab1"
										data-toggle="pill">Monthly Subscription</a></li>
	                            <li><a href="#tab2" data-toggle="pill">Yearly Subscription</a></li>
	                        </ul>
	                    </div>
	                </div>
						<!-- end col -->
	            </div>
	
	            <hr class="invis">
	
	            <div class="row">
	                <div class="col-md-12">
	                    <div class="tab-content">
	                        <div class="tab-pane active fade show"
									id="tab1">
	                            <div class="row text-center">
	                            <c:forEach var="pack" items="${packs }"
											varStatus="i">
	                                <c:if test="${pack.expiry < 365 }">
	                                	<div class="col-md-4">
	                                    <div
														class="pricing-table pricing-table-highlighted">
	                                        <div
															class="pricing-table-header grd1">
	                                            <h2>${pack.fee }</h2>
	                                            <h3>${pack.title }</h3>
	                                            <h4 style="color: white;">${pack.description }</h4>
	                                        </div>
	                                        <div
															class="pricing-table-space"></div>
	                                        <div
															class="pricing-table-features">
	                                            <p>
																<i class="fa fa-envelope-o"></i> <strong>250</strong> Email Addresses</p>
	                                            <p>
																<i class="fa fa-rocket"></i> <strong>125GB</strong> of Storage</p>
	                                            <p>
																<i class="fa fa-database"></i> <strong>140</strong> Databases</p>
	                                            <p>
																<i class="fa fa-link"></i> <strong>60</strong> Domains</p>
	                                            <p>
																<i class="fa fa-life-ring"></i> <strong>24/7 Unlimited</strong> Support</p>
	                                        </div>
	                                        <div
															class="pricing-table-sign-up">
	                                            <%-- <a href="#" class="hover-btn-new orange"><span>Order Now</span></a> --%>
	                                        </div>
	                                    </div>
	                                </div>
	                                </c:if>
	                               </c:forEach>
	                            </div>
									<!-- end row -->
	                        </div>
								<!-- end pane -->
	
	                        <div class="tab-pane fade" id="tab2">
	                            <div class="row text-center">
	                                <c:forEach var="pack" items="${packs }"
											varStatus="i">
	                                <c:if test="${pack.expiry >= 365 }">
	                                	<div class="col-md-4">
	                                    <div
														class="pricing-table pricing-table-highlighted">
	                                        <div
															class="pricing-table-header grd1">
	                                            <h2>${pack.fee }</h2>
	                                            <h3>${pack.title }</h3>
	                                            <h4 style="color: white;">${pack.description }</h4>
	                                        </div>
	                                        <div
															class="pricing-table-space"></div>
	                                        <div
															class="pricing-table-features">
	                                            <p>
																<i class="fa fa-envelope-o"></i> <strong>250</strong> Email Addresses</p>
	                                            <p>
																<i class="fa fa-rocket"></i> <strong>125GB</strong> of Storage</p>
	                                            <p>
																<i class="fa fa-database"></i> <strong>140</strong> Databases</p>
	                                            <p>
																<i class="fa fa-link"></i> <strong>60</strong> Domains</p>
	                                            <p>
																<i class="fa fa-life-ring"></i> <strong>24/7 Unlimited</strong> Support</p>
	                                        </div>
	                                        <div
															class="pricing-table-sign-up">
	                                            <%-- <a href="#" class="hover-btn-new orange"><span>Order Now</span></a> --%>
	                                        </div>
	                                    </div>
	                                </div>
	                                </c:if>
	                               </c:forEach>
	                            </div>
									<!-- end row -->
	                        </div>
								<!-- end pane -->
	                    </div>
							<!-- end content -->
	                </div>
						<!-- end col -->
	            </div>
        </div><!-- end container -->
    </div><!-- end section -->

    <div id="testimonials" class="parallax section db parallax-off" style="background-image:url('${pageContext.request.contextPath}/resources/user/images/parallax_04.jpg');">
        <div class="container">
            <div class="section-title text-center">
                <h3>Testimonials</h3>
                <p>Lorem ipsum dolor sit aet, consectetur adipisicing lit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
            </div><!-- end title -->

            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <div class="testi-carousel owl-carousel owl-theme">
                        <div class="testimonial clearfix">
							<div class="testi-meta">
                                <img src="${pageContext.request.contextPath}/resources/user/images/testi_01.png" alt="" class="img-fluid">
                                <h4>James Fernando </h4>
                            </div>
                            <div class="desc">
                                <h3><i class="fa fa-quote-left"></i> Wonderful Support!</h3>
                                <p class="lead">They have got my project on time with the competition with a sed highly skilled, and experienced & professional team.</p>
                            </div>
                            <!-- end testi-meta -->
                        </div>
                        <!-- end testimonial -->

                        <div class="testimonial clearfix">
							<div class="testi-meta">
                                <img src="${pageContext.request.contextPath}/resources/user/images/testi_02.png" alt="" class="img-fluid">
                                <h4>Jacques Philips </h4>
                            </div>
                            <div class="desc">
                                <h3><i class="fa fa-quote-left"></i> Awesome Services!</h3>
                                <p class="lead">Explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you completed.</p>
                            </div>
                            <!-- end testi-meta -->
                        </div>
                        <!-- end testimonial -->

                        <div class="testimonial clearfix">
							<div class="testi-meta">
                                <img src="${pageContext.request.contextPath}/resources/user/images/testi_03.png" alt="" class="img-fluid ">
                                <h4>Venanda Mercy </h4>
                            </div>
                            <div class="desc">
                                <h3><i class="fa fa-quote-left"></i> Great & Talented Team!</h3>
                                <p class="lead">The master-builder of human happines no one rejects, dislikes avoids pleasure itself, because it is very pursue pleasure. </p>
                            </div>
                            <!-- end testi-meta -->
                        </div>
                        <!-- end testimonial -->
                        <div class="testimonial clearfix">
							<div class="testi-meta">
                                <img src="${pageContext.request.contextPath}/resources/user/images/testi_01.png" alt="" class="img-fluid">
                                <h4>James Fernando </h4>
                            </div>
                            <div class="desc">
                                <h3><i class="fa fa-quote-left"></i> Wonderful Support!</h3>
                                <p class="lead">They have got my project on time with the competition with a sed highly skilled, and experienced & professional team.</p>
                            </div>
                            <!-- end testi-meta -->
                        </div>
                        <!-- end testimonial -->

                        <div class="testimonial clearfix">
							<div class="testi-meta">
                                <img src="${pageContext.request.contextPath}/resources/user/images/testi_02.png" alt="" class="img-fluid">
                                <h4>Jacques Philips </h4>
                            </div>
                            <div class="desc">
                                <h3><i class="fa fa-quote-left"></i> Awesome Services!</h3>
                                <p class="lead">Explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you completed.</p>
                            </div>
                            <!-- end testi-meta -->
                        </div>
                        <!-- end testimonial -->

                        <div class="testimonial clearfix">
							<div class="testi-meta">
                                <img src="${pageContext.request.contextPath}/resources/user/images/testi_03.png" alt="" class="img-fluid">
                                <h4>Venanda Mercy </h4>
                            </div>
                            <div class="desc">
                                <h3><i class="fa fa-quote-left"></i> Great & Talented Team!</h3>
                                <p class="lead">The master-builder of human happines no one rejects, dislikes avoids pleasure itself, because it is very pursue pleasure. </p>
                            </div>
                            <!-- end testi-meta -->
                        </div><!-- end testimonial -->
                    </div><!-- end carousel -->
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end section -->

   
	</jsp:attribute>
</mt:layout_user>