<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Bruno Neofiti Assignment</title>

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

				<h2>${subtitle}</h2>

				<form name="atmForm" action="<c:url value='/ws/createAtm' />" method="GET" class="form-inline">
					<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
					<input type="hidden" name="json" value='{ "name":"Amsterdam", "provinces":"Amsterdam", "country":"Netherland"}' />
    	
				    <div class="col-lg-8 form-group">
				        <label for="city">City name:</label>
				      	<input name="cityname" class="form-contorl" type="text">
					</div>
				    <div class="col-lg-8 form-group">
				        <label for="city">Province:</label>
				      	<input name="province" class="form-contorl" type="text">
					</div>
				    <div class="col-lg-8 form-group">
				        <label for="city">Country:</label>
				      	<input name="country" class="form-contorl" type="text">
					</div>
				    <div class="col-lg-8 form-group">
						<input name="submit" type="submit" value="Add city" />
					</div>
		
				</form>
			</div>
		</div>
	</div>


	<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<script src="${bootstrapJs}" language="JavaScript" type="text/javascript" ></script>

</body>
</html>
