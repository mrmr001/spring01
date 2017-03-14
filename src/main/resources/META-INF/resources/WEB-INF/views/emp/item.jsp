<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>EmpList.jsp</title>
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>
</head>
<body>
	<a href="/emp/page/${param.pageNo}">back</a> ${err}
	<br>
	<table class="table table-responsive">
		<tr>
			<td>${emp.deptno}</td>
			<td>${emp.ename}</td>
			<td>${emp.empno}</td>
			<td>${emp.job}</td>
			<td>${emp.mgr}</td>
			<td>${emp.sal}</td>
			<td>${emp.hiredate}</td>
			<td>${emp.comm}</td>
		</tr>
		<tr>
		<td>${emp.dept.deptno}</td>
		<td>${emp.dept.dname}</td>
		<td>${emp.dept.loc}</td>
		</tr>
		</table>
</body>
</html>