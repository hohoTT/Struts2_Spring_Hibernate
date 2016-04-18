<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Emp-input Page</title>
</head>
<body>

	<h1>Emp Input Page</h1><hr>
	
	<s:form action="emp-save" method="post">
		<s:textfield name="lastName" label="LastName"></s:textfield>
		<s:textfield name="email" label="Email"></s:textfield>
		<s:textfield name="birth" label="Birth"></s:textfield>
		
		<s:select list="#request.departments"
			listKey="id" listValue="departmentName" name="department.id"
			label="Department"></s:select>
			
		<s:submit></s:submit>	
	</s:form>

</body>
</html>