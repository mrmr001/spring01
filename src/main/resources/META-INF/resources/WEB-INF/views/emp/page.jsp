<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>EmpPage.jsp</title>

<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>
</head>
<body>

	<c:set var="emp" value="${page.emp}" />
	<c:set var="paging" value="${page.paging}" />

	<%-- <h1>page list pageNo=${paging.pageNo}</h1> --%>

	<%-- ${paging} --%>
	totallist=${paging.totalItem}

	<table class="table table-responsive">

		<c:forEach var="e" items="${emp}">
			<tr>
				<td>${e.deptno}</td>
				<td><a href="/emp/item/${e.empno}?pageNo=${paging.pageNo}">${e.ename}</td>
				<td>${e.empno}</td>
				<td>${e.job}</td>
				<td>${e.mgr}</td>
				<td>${e.sal}</td>
				<td>${e.hiredate}</td>
				<td>${e.comm}</td>
			</tr>
		</c:forEach>
	</table>
	<ul class="pagination">
		<li><a href="/emp/page/1">first</a></li>

		<c:if test="${paging.firstPage != 1 }">
			<li><a href="/emp/page/${paging.firstPage - 1 }">prev</a></li>
		</c:if>

		<c:forEach var="i" begin="${paging.firstPage}"
			end="${paging.lastPage}">
			<li><a href="/emp/page/${i}">${i} </a></li>
		</c:forEach>

		<c:if test="${paging.lastPage != 24 }">
			<li><a href="/emp/page/${paging.lastPage + 1 }">next</a></li>
		</c:if>

		<li><a href="/emp/page/${paging.totalPage}">last</a></li>
	</ul>
</body>
</html>