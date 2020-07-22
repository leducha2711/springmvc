<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


	<h2>Danh sach</h2>
	
	<table>
		<tr>
			<td>Ten</td>
			<td>Gia</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${productDTOs }" var="product">
			<tr>
				<td>${product.productName }</td>
				<td>${product.price }</td>
				<td>
					<a href="<c:url value='/chi-tiet-san-pham/${product.id }'/>">Chi tiet</a>
					<a href="<c:url value='/sua-san-pham/${product.id }'/>">Sua</a>
					<a href="<c:url value='/xoa-san-pham/${product.id }'/>">Xoa</a>
					<a href="<c:url value='/xoa-san-pham/${product.id }'/>">Add to cart</a></td>
			</tr>
		</c:forEach>
	</table>
