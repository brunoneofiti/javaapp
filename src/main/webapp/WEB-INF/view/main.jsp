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
	<c:url value="/logout" var="logoutUrl" />
	
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
	</form>
	
	
	<div id="page-wrapper">
		<div class="container-fluid">
		
		
			<div class="row">
			
				<div class="col-lg-12">
					<h1 class="page-header">List of ING ATMs by city</h1>
					<h2>Selected List: ${city}</h2>
				</div>
				
			</div>
			
			<div class="col-lg-12">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
				
					<p>Hi ${pageContext.request.userPrincipal.name} !</p>
					<p>List of ING ATMs: <a href="restricted/ingAtms">here</a>.<p>
					<p><a href="javascript:formSubmit()">Here to say bye!</a><p>
			
				</c:if>
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