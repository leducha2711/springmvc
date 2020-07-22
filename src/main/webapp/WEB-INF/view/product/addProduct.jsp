<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<h2>Them san pham</h2>
	<c:url value="/them-san-pham" var="url"></c:url>
	<form:form action="${url }" method="post" modelAttribute="product">

		Product's name: <form:input path="productName" />
		<br />
		
		Product's price: <form:input path="price" />
		<br />
		
		<input type="submit" value="Submit" />

	</form:form>
