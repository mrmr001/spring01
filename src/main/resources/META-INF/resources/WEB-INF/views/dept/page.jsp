<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>DeptPage.jsp</title>
<c:if test="false">
<link rel="stylesheet"  href="../code_assist/animate.css">
<link rel="stylesheet"  href="../code_assist/bootstrap.css">
</c:if>
</head>
<body>

<c:set var="depts" value="${page.depts}"/>
<c:set var="paging" value="${page.paging}"/>

<%-- <h1>page list pageNo=${paging.pageNo}</h1> --%>

<%-- ${paging} --%>
totallist=${paging.totalItem}


<table class="table table-hover">
		<tr class="alert-info">
			<td>	No.			</td>
			<td>	Deptno		</td>
			<td>	dname		</td>
			<td>	loc	</td>
		</tr>
	<c:forEach var="d" items="${depts}" varStatus="status">
		<tr>
			<td><b>${status.index +1}</b></td> 
			<td> ${d.deptno}</td>
			<td><a href="/dept/item/${d.deptno}?pageNo=${paging.pageNo}">${d.dname}</a> </td>
			<td> ${d.loc}</td>
		</tr>
	</c:forEach>
</table>


<ul class="pagination">
	<c:if test="${paging.firstPage != 1 }">
			<li class="previous"><a href="/dept/page/${paging.firstPage - 1 }">prev</a></li>
	</c:if>
		<c:forEach var="i" begin="${paging.firstPage}" end="${paging.lastPage}">
			<li><a class="btn btn-default" href="/dept/page/${i}">${i} </a></li>
		</c:forEach>
	<c:if test="${paging.lastPage != 24 }">
			<li class="next"><a href="/dept/page/${paging.lastPage + 1 }">next</a></li>
	</c:if>
</ul>

</body>
</html>