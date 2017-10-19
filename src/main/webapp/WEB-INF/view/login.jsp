<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Just a Java App</title>

	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>

<body onload="document.loginForm.username.focus();">

	<div id="page-wrapper">
		<div class="container-fluid">
		
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">${title}</h1>
				</div>
			</div>
			
			<div>
				<c:if test="${not empty error}">
					<div class="alert alert-danger">
					  <strong>Erro:</strong> ${error}.
					</div>					
				</c:if>
				
				<c:if test="${not empty content}">
					<div class="alert alert-warning">${content}</div>
					<h2 class="page-header"></h2>
				</c:if>

				<form name="loginForm" action="<c:url value='/login' />" method="POST" class="form-inline">
					<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />

				    <div class="col-lg-8 form-group">
				      <label for="username">Username:</label>
				      <input type="text" name="username" value="bruno" class="form-control">
					</div>

				    <div class="col-lg-8 form-group">
				      <label for="password">Password:</label>
				      <input type="password" name="password" class="form-control"> (tip: 123)
					</div>
		
				    <div class="col-lg-8 form-group">
				      <input name="submit" type="submit" value="Go!" class="form-control" />
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