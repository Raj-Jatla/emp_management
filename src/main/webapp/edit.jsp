<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>Update</h1>
	
	<form:form modelAttribute="emp" action="update?id=${emp.employeeId}">
	NAME:<form:input path="EmployeeName"/><br>
	EMAIL:<form:input path="EmployeeEmail"/><br>
	CONTACT:<form:input path="EmployeeContact"/><br>
	PASSWORD:<form:input path="EmployeePassword"/><br>
	<input type="submit">
	</form:form>
</body>
</html>