<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <table border="2px">
		
		<tr>
		<th>EmployeeID</th>
		<th>EmployeeName</th>
		<th> EmployeeEmail</th>
		<th> EmployeeContact</th>
		<th> Delete </th>
		<th> Update </th>
		</tr>
		
		<c:forEach var="emp" items="${emps}">
		<tr>
		<td>${emp.employeeId}</td>
		<td>${emp.employeeName}</td>
		<td>${emp.employeeEmail}</td>
		<td>${emp.employeeContact}</td>
		<td><a href="delete?id=${emp.employeeId}">Delete</a></td>
		<td><a href="edit?id=${emp.employeeId}">Update</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<a href="add">Add Employee</a><br>
</body>
</html>