<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>CityList.jsp</title>
</head>
<body>
<h1>list</h1>
		<c:forEach var="city" items="${citys}">
		${city.id} / ${city.name} / ${city.countryCode} / ${city.district} / ${city.population}<br>
		${city.country.name}<br>
		</c:forEach>
</body>
</html>