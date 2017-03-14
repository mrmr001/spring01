<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>CountryItem.jsp</title>
</head>
<body>
		${err}<br>
		${country.code} ${country.name} ${country.population}
		<a href="/country/page/${param.pageNo}">back</a>
		<ol>
	<c:forEach var="city" items="${country.citys}">
	<li>${city.id}, ${city.name},${city.district}, ${city.population}</li>
	</c:forEach>
		</ol>
		
</body>
</html>