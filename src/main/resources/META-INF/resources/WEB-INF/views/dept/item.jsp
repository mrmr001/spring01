<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE >
<html>
<head>
<meta charset="UTF-8">
<title>DeptItem.jsp</title>
</head>
<body>

<table class="table table-hover">
		<tr class="alert-info">
			<td>deptno</td>
			<td>dname</td>
			<td>loc	 </td>
			<td><button class="btn btn-info btn-xs" 
						type="button"
						onclick="location.href='/dept/page/${param.pageNo}'">
						BACK</button></td>
		</tr>
		<tr>
			<td>${dept.deptno}</td> 
			<td>${dept.dname}</td>
			<td>${dept.loc}</td>
		</tr>

		<tr  class="alert-info">
			<td>no.</td>
			<td>deptno</td>  
			<td>ename</td> 
			<td>empno</td> 
			<td>job</td> 
			<td>mgr</td>  
			<td>sal</td>  
			<td>hiredate</td>  
			<td>comm</td>
		</tr>
	<c:forEach var="emp" items="${dept.emps}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${emp.deptno}</td>  
			<td>${emp.ename}</td> 
			<td>${emp.empno}</td> 
			<td>${emp.job}</td> 
			<td>${emp.mgr}</td>  
			<td>${emp.sal}</td>  
			<td>${emp.hiredate}</td>  
			<td>${emp.comm}</td>
		</tr>
	</c:forEach>
</table>	
<%-- <button type="button" onclick="location.href='/dept/page/${param.pageNo}'">BACK</button>	 --%>
	<%-- 	<a href="/dept/page/${param.pageNo}">back</a> --%>
		${err}<br>
<%-- 		${dept.deptno} ${dept.dname} ${dept.loc} --%>
</body>
</html>