<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Just a Java App</title>
	
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<spring:url value="/resources/css/app.css" var="appCss" />
	<link href="${appCss}" rel="stylesheet" />

</head>

<body>
	<div id="page-wrapper">
		<div class="container-fluid">
		
			<div class="row">
			
				<div class="col-lg-12">
					<h1 class="page-header">${title}</h1>
				</div>

			</div>
		</div>
		
	</div>
	
    <div id="map"></div>

    <script>

      function initMap() {

          var myLatLng = {lat: ${lat}, lng: ${lng}};

        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 16,
          center: myLatLng
        });

        var marker = new google.maps.Marker({
          position: myLatLng,
          map: map,
          title: 'Map World!'
        });
      }
    </script>
    
    <script async defer 
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBQvUtY6HUFStQovj-AWJivsw6uA_D9hes&callback=initMap">
    </script>
    
	<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
	<script src="${bootstrapJs}" language="JavaScript" type="text/javascript" ></script>
	<spring:url value="/resources/js/app.js" var="appJs" />
	<script src="${appJs}" language="JavaScript" type="text/javascript" ></script>

</body>
</html>