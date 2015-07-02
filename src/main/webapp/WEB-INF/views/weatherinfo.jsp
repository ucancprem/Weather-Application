<%@page import="com.expedia.weather.domain.LocationForecast"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.0/css/bootstrap-toggle.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.0/js/bootstrap-toggle.min.js"></script>
<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/cycle.js"/></script>
<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/weatherjs.js"/></script>
<link href="<%=request.getContextPath()%>/resources/css/weatherStyle.css" rel="stylesheet">

</head>
<body>
<div id="slideshow">
<img class="bgM" src="<c:url value="/"/>resources/images/snow.jpg"/>
<img class="bgM" src="<c:url value="/"/>resources/images/sunny.jpg"/>
<img class="bgM" src="<c:url value="/"/>resources/images/rain.jpg"/>
</div>

<%
	LocationForecast locationForecast= (LocationForecast)request.getAttribute("locationForecast");
	System.out.println("locationForecast is "+locationForecast);
%>
	<h1>Weather in USA</h1>
	<div class="weatherEntry">
	<c:choose>
	<c:when test="${not empty locationForecast}">
		<div onclick="togglerMetric();"><input id="toggle-demo" type="checkbox" checked data-toggle="toggle" data-size="normal" data-width="150" data-off="Non-US METRIC"  data-on="US METRIC" ></div>
		<div class="location">
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">City&nbsp; &nbsp;<span class="badge text-right" style="font-size:large"> ${locationForecast.city.getCity()},&nbsp;${locationForecast.city.getState()}</span></button>
		</div>
		<div class="weatherDesc">
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">Currently&nbsp; &nbsp;<span class="badge text-right" style="font-size:large"> <img src="${locationForecast.forecast.getIcon_url()}" alt="${locationForecast.forecast.getWeather()}"> &nbsp; ${locationForecast.forecast.getWeather()}</span></button>
		</div>
		<div class="temperatureF USmetric">
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">Temp&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;<span class="badge text-right" style="font-size:large">  ${locationForecast.forecast.getTemp_f()} &deg;F</span></button> 
		</div>
		<div class="temperatureF USmetric">
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">Feels Like&nbsp; &nbsp;<span class="badge text-right" style="font-size:large"> ${locationForecast.forecast.getFeelslike_f()} &deg;F</span></button>
		</div>
		<div class="temperatureC nonUSmetric">
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">Temp&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;<span class="badge text-right" style="font-size:large">  ${locationForecast.forecast.getTemp_c()} &deg;C</span></button> 
		</div>
		<div class="temperatureC nonUSmetric">
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">Feels Like&nbsp; &nbsp;<span class="badge text-right" style="font-size:large"> ${locationForecast.forecast.getFeelslike_c()} &deg;C</span></button>
		</div>
		<div class="wind USmetric">
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">Wind&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;<span class="badge text-right" style="font-size:large">${locationForecast.forecast.getWind_mph()} mph</span></button>
		</div>
		<div class="wind nonUSmetric">
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">Wind&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;<span class="badge text-right" style="font-size:large">${locationForecast.forecast.getWind_kph()} kph</span></button>
		</div>
		<div>
			<button type="button" class="btn btn-primary btn-lg btn-block" onclick="return false;">Humidity&nbsp;&nbsp; &nbsp;  &nbsp; &nbsp;<span class="badge text-right" style="font-size:large">${locationForecast.forecast.getRelative_humidity()}</span></button>
		</div>
	</c:when>
	</c:choose>
	</div>	
	<form:form class="mainEntry" commandName="location" action="display" method="post">
	<div class="mainEntry" >
		<form:errors class="label Warning Label" style="font-size: 2rem" path="zip" />
		<br>
		<br>
		<form:input  path="zip" size="100"  placeholder="Enter zip code to search for weather in your city" />
		<br>
		<br>
		<button type="submit" id="submit" class="btn btn-primary btn-block">Weather Search</button>
		
		</div>	
	</form:form>

</body>
</html>
