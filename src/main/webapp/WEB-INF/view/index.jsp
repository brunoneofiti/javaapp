<%@page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Just a Java App</title>

	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>

<body>

	<div id="page-wrapper">
		<div class="container-fluid">
		
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">${title}</h1>
				</div>
			</div>
			
			<c:url value="/restricted" var="restrictedURL" />
			<c:url value="/ws/getCity" var="cityURL" />
			<c:url value="/ws/getCityList" var="cityListURL" />
			
			<div class="col-lg-12">
				<p>${content}</p>
				<p><a href="${restrictedURL}">Access restricted area</a></p>
				<p><a href="${cityURL}">WS return one Dutch city (default is Utrecht)</a></p>
				<p><a href="${cityListURL}">WS return a list of all Dutch cities (in my database)</a></p>
			</div>
			
		</div>
	</div>


	<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<script src="${bootstrapJs}" language="JavaScript" type="text/javascript" ></script>

</body>
</html>
