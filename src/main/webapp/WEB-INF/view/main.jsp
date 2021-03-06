<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Just a Java App</title>

	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>

<body>
	<c:url value="/logout" var="logoutUrl" />
	
	<c:url value="/map" var="mapURL" />
	<c:url value="/restricted/createAtm" var="createAtmURL" />
	<c:url value="/restricted/selectAtmByCity" var="selectAtmByCityURL" />

	<c:url value="/ws/getRemoteWS" var="getRemoteWSURL" />
	<c:url value="/ws/getLocalWS" var="getLocalWSURL" />
	<c:url value="/ws/getLocalFile" var="getLocalFileURL" />
	<c:url value="/ws/getAtmList" var="getAtmListURL" />
	<c:url value="/ws/createAtm" var="createAtmWSURL" />
	
	<c:url value="/ws/getCity" var="getCityURL" />
	<c:url value="/ws/getCityList" var="getCityListURL" />
	<c:url value="/ws/getDutchCityList" var="getDutchCityListURL" />
	
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
	</form>
	
	<div id="page-wrapper">
		<div class="container-fluid">
		
			<div class="row">
			
				<div class="col-lg-12">
					<h1 class="page-header">${title}</h1>
				</div>
				
			</div>
			
			<div class="col-lg-12">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<p>Hi ${pageContext.request.userPrincipal.name} !</p>
					<p><a href="javascript:formSubmit()">Logout!</a><p>
				</c:if>
				
					<h2>Pages:</h2>
					<p><a href="${mapURL}">One ATM in the Map</a></p>
					<p><a href="${createAtmURL}">Add city to ATMs List</a></p>
					<p><a href="${selectAtmByCityURL}">Select ATM by city</a></p>
					
					<p><a href="${getRemoteWSURL}">Remote WS</a></p>
					<p><a href="${getLocalWSURL}">Local WS</a></p>
					<p><a href="${getLocalFileURL}">Local File</a></p>
					<p><a href="${getAtmListURL}">See list of ATMs</a></p>
					<p><a href="${createAtmWSURL}">ATM WS</a></p>
					
					<p><a href="${getCityURL}">Get City</a></p>
					<p><a href="${getCityListURL}">City List</a></p>
					<p><a href="${getDutchCityListURL}">Dutch City List</a></p>

					<h2>Web Services:</h2>
					<p><a href="${cityURL}">Select one Dutch city (default Urtrach)</a></p>
					<p><a href="${cityListURL}">List of Dutch cities</a></p>
				
			</div>
		
		</div>
	</div>
	
	<!--  
	<c:url value="/res" var="resour" />
	<h1>${resour} - Title : ${title}</h1>
	-->
	
	<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<spring:url value="/resources/js/app.js" var="coreJs" />

	<script src="${bootstrapJs}" language="JavaScript" type="text/javascript" ></script>
	<script src="${coreJs}" language="JavaScript" type="text/javascript" ></script>

</body>
</html>