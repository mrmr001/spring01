<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>Citypage.jsp</title>
<c:if test="false">
<link rel="stylesheet"  href="../code_assist/animate.css">
<link rel="stylesheet"  href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>

<c:set var="citys" value="${page.citys}"/>
<c:set var="paging" value="${page.paging}"/>

<%-- <h1>page list pageNo=${paging.pageNo}</h1> --%>

<%-- ${paging} --%>
totallist=${paging.totalItem}

<table class="table table-responsive">
		<tr class="btn-success">
		<td>id</td>
		<td>name</td>
		<td>countryCode</td>
		<td>district</td>
		<td>population</td>
		</tr>
<c:forEach var="ci" items="${citys}">
		<tr>
		<td>${ci.id}</td>
		<td><a href="/city/item/${ci.id}?pageNo=${paging.pageNo}">${ci.name}</td>
		<td>${ci.countryCode}</td>
		<td>${ci.district}</td>
		<td>${ci.population}</td>
		
		</tr>
</c:forEach>
</table>
<ul class="pagination">
<li><a href="/city/page/1">first</a></li>
	
	<c:if test="${paging.firstPage != 1 }">
			<li><a href="/city/page/${paging.firstPage - 1 }">prev</a></li>
	</c:if>
	
		<c:forEach var="i" begin="${paging.firstPage}" end="${paging.lastPage}">
			<li><a  href="/city/page/${i}">${i} </a></li>
		</c:forEach>
	
	<c:if test="${paging.lastPage != 24 }">
			<li ><a href="/city/page/${paging.lastPage + 1 }">next</a></li>
	</c:if>
	
	<li ><a href="/city/page/${paging.totalPage}">last</a></li>
</ul>
</body>
</html>