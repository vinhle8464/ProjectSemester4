<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<mt:layout_user title="Teacher">
	
	<jsp:attribute name="content">
	
	<div class="all-title-box">
		<div class="container text-center">
			<h1>Pricing<span class="m_1">Lorem Ipsum dolroin gravida nibh vel velit.</span></h1>
		</div>
	</div>
	
    <div id="pricing-box" class="section wb">
        <div class="container">
			<div class="row">
				<c:forEach var="pack" items="${packs }" varStatus="i">
						<div class="col-md-4">
		                    <div class="pricingTable">
		                        <div class="pricingTable-header">
		                            <span class="heading">
		                                <h3>${pack.title }</h3>
		                            </span>
		                            <span class="price-value">${pack.fee } $ <span>${pack.title } </span><span>${pack.description }</span></span>
		                        </div>
		
		                        <div class="pricingContent">
		                            <i class="fa fa-adjust"></i>
		                            <ul>
		                                <li>50GB Disk Space</li>
		                                <li>50 Email Accounts</li>
		                                <li>50GB Monthly Bandwidth</li>
		                                <li>10 subdomains</li>
		                                <li>50 Domains</li>
		                            </ul>
		                        </div>
		
		                        <div class="pricingTable-sign-up">
		                            <%-- <a href="#" class="hover-btn-new orange"><span>Buy</span></a> --%>
		                            <s:form method="post" action="${posturl }">
										<input type="hidden" name="item_number_1" value="${pack.packId }">
										<input type="hidden" name="item_name_1" value="${pack.title }">
										<input type="hidden" name="amount_1" value="${pack.fee }">
										<input type="hidden" name="quantity_1" value="1">
										<br><br>
										<input type="submit" value="Buy" class="hover-btn-new orange ">
										<input type="hidden" name="upload" value="1" /> 
										<input type="hidden" name="return" value="${returnurl }" /> 
										<input type="hidden" name="cmd" value="_cart" /> 
										<input type="hidden" name="business" value="${business }" />
										
										<input type="hidden" name="packId" value="${pack.packId }">
			                		</s:form>
		                        </div><!-- BUTTON BOX-->
		                	</div>
						</div> 
						
				</c:forEach>
        
            </div>
		</div>
    </div>

    <div id="testimonials" class="parallax section db parallax-off" style="background-image:url('${pageContext.request.contextPath }/resources/user/images/parallax_04.jpg');">
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
                                <img src="${pageContext.request.contextPath }/resources/user/images/testi_01.png" alt="" class="img-fluid">
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
                                <img src="${pageContext.request.contextPath }/resources/user/images/testi_02.png" alt="" class="img-fluid">
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
                                <img src="${pageContext.request.contextPath }/resources/user/images/testi_03.png" alt="" class="img-fluid ">
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
                                <img src="${pageContext.request.contextPath }/resources/user/images/testi_01.png" alt="" class="img-fluid">
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
                                <img src="${pageContext.request.contextPath }/resources/user/images/testi_02.png" alt="" class="img-fluid">
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
                                <img src="${pageContext.request.contextPath }/resources/user/images/testi_03.png" alt="" class="img-fluid">
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