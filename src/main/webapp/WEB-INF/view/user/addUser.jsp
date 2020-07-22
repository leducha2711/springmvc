<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<h2>Them khach hang</h2>
	<c:url value="/them-khach-hang" var="url"></c:url>
	<form:form action="${url }" method="post" modelAttribute="user">

		Name: <form:input path="name" />
		<br />
		<p style="color:red"><form:errors path="name"></form:errors></p>
		<br />
		Phone: <form:input path="phone" />
		<br />
		<p style="color:red"><form:errors path="phone"></form:errors></p>
		<br />
		Password:
		<form:password path="password" />
		<br />
		<p style="color:red"><form:errors path="password"></form:errors></p>
		<br />
		<input type="submit" value="Submit" />

	</form:form>
