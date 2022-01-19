<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<mt:layout_admin title="Faculty - Dashboard">

	<jsp:attribute name="content">
	
	<style>
	/**
 * 1. The `reverse` animation direction plays the animation backwards
 *    which makes it start at the stroke offset 100 which means displaying
 *    no stroke at all and animating it to the value defined in the SVG
 *    via the inline `stroke-dashoffset` attribute.
 * 2. Rotate by -90 degree to make the starting point of the
 *    stroke the top of the circle.
 * 3. Using CSS transforms on SVG elements is not supported by Internet Explorer
 *    and Edge, use the transform attribute directly on the SVG element as a
 * .  workaround (https://markus.oberlehner.net/blog/pure-css-animated-svg-circle-chart/#part-4-internet-explorer-strikes-back).
 */
.circle-chart__circle {
  animation: circle-chart-fill 2s reverse; /* 1 */ 
  transform: rotate(-90deg); /* 2, 3 */
  transform-origin: center; /* 4 */
}

/**
 * 1. Rotate by -90 degree to make the starting point of the
 *    stroke the top of the circle.
 * 2. Scaling mirrors the circle to make the stroke move right
 *    to mark a positive chart value.
 * 3. Using CSS transforms on SVG elements is not supported by Internet Explorer
 *    and Edge, use the transform attribute directly on the SVG element as a
 * .  workaround (https://markus.oberlehner.net/blog/pure-css-animated-svg-circle-chart/#part-4-internet-explorer-strikes-back).
 */
.circle-chart__circle--negative {
  transform: rotate(-90deg) scale(1,-1); /* 1, 2, 3 */
}

.circle-chart__info {
  animation: circle-chart-appear 2s forwards;
  opacity: 0;
  transform: translateY(0.3em);
}

@keyframes circle-chart-fill {
  to { stroke-dasharray: 0 100; }
}

@keyframes circle-chart-appear {
  to {
    opacity: 1;
    transform: translateY(0);
  }
}
/* 
/* Layout styles only, not needed for functionality */
html {
  font-family: sans-serif;
  padding-right: 1em;
  padding-left: 1em;
}

.grid {
  display: grid;
  grid-column-gap: 1em;
  grid-row-gap: 1em;
  grid-template-columns: repeat(1, 1fr);
}

@media (min-width: 31em) {
  .grid {
    grid-template-columns: repeat(2, 1fr);
  }
} */



	</style>
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

	<%-- <form method="get"
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
	</form> --%>
	
	
	<div class="grid">
  <section>
    <h2>Positive chart value</h2>
    <svg class="circle-chart" viewbox="0 0 33.83098862 33.83098862" width="200" height="200" xmlns="http://www.w3.org/2000/svg">
      <circle class="circle-chart__background" stroke="#efefef" stroke-width="2" fill="none" cx="16.91549431" cy="16.91549431" r="15.91549431" />
      <circle class="circle-chart__circle" stroke="#00acc1" stroke-width="2" stroke-dasharray="50" stroke-linecap="round" fill="none" cx="16.91549431" cy="16.91549431" r="15.91549431" />
      <g class="circle-chart__info">
        <text class="circle-chart__percent" x="16.91549431" y="15.5" alignment-baseline="central" text-anchor="middle" font-size="8">50%</text>
        <text class="circle-chart__subline" x="16.91549431" y="20.5" alignment-baseline="central" text-anchor="middle" font-size="2">10/20 progress!</text>
      </g>
    </svg>
  </section>

</div>

<!-- 
///////////// -->

	</jsp:attribute>
</mt:layout_admin>