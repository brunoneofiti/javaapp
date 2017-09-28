<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bruno Neofiti Assignment</title>

	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
</head>

<body onload="document.loginForm.username.focus();">

	<div id="page-wrapper">
		<div class="container-fluid">
		
			<div class="row">
			
				<div class="col-lg-12">
					<c:if test="${empty error and empty message}">
						<h1 class="page-header">Please, login with user and password</h1>
					</c:if>

					<c:if test="${not empty error}">
						<h1 class="page-header">${error}</h1>
					</c:if>
					
					<c:if test="${not empty msg}">
						<h1 class="page-header">${msg}</h1>
					</c:if>
				</div>
				
			</div>
			
			<div class="col-lg-12">
				<form name="loginForm" action="<c:url value='/login' />" method="POST">
					<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
		
					<table>
						<tr>
							<td>Username:</td>
							<td><input type="text" name="username" value="bruno"></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password" /> (e.g. 123)</td>
						</tr>
						<tr>
							<td colspan="2"><input name="submit" type="submit"	value="Go!" /></td>
						</tr>
					</table>
				</form>
			</div>
			
		</div>
	</div>

	<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<script src="${bootstrapJs}" language="JavaScript" type="text/javascript" ></script>

</body>
</html>