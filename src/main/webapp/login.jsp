<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>LOGIN</h1>

    <form action="login">
	EMAIL:<input type="text" name="email" placeholder="EmployeeEmail"/><br>
	PASSWORD:<input type="password" name="password" placeholder="EmployeePassword"/><br>
	<input type="submit">
	</form>

</body>
</html>