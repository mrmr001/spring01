<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>CityItem.jsp</title>

<c:if test="false">
<link rel="stylesheet"  href="../code_assist/animate.css">
<link rel="stylesheet"  href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>

		${err}<br>
<a href="/city/page/${param.pageNo}">back</a>
	<table class="table table-responsive">
	<tr>	
	<td>${city.id}</td> 
	 <td>${city.name}</td>
	 <td>${city.countryCode}</td> 
	  <td>${city.district}</td> 
	  <td>${city.population}</td>
	</tr>
	<tr>
	<td>${city.country.code}</td>
	<td> ${city.country.name}</td>
	<td>${city.country.population}</td>
	<td></td>
	<td></td>
	</tr>
</table>
</body>
</html>