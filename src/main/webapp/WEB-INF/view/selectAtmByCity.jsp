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

	<div id="page-wrapper">
		<div class="container-fluid">
		
			<div class="row">
			
				<div class="col-lg-12">
					<h1 class="page-header">${title}</h1>
				</div>

				<h2>${subtitle}</h2>

				<form name="atmForm" action="<c:url value='/ws/getAtmList' />" method="GET" class="form-inline">
					<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />

				    <div class="col-lg-8 form-group">
				      <label for="city">Please select one city:</label>
						<select name="cityname" class="form-control">
							<c:forEach items="${cities}" var="city">
								<option><c:out value="${city.name}"></c:out></option>
							</c:forEach>
						</select>
						<input name="submit" type="submit" value="Show me" />
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
