<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


	<h2>Danh sach</h2>
	<a href="<c:url value='/them-khach-hang'/>">Them khach hang</a>
	<table>
		<tr>
			<td>Ten</td>
			<td>Phone</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.name }</td>
				<td>${user.phone }</td>
				<td><a href="<c:url value='/chi-tiet-khach-hang/${user.id }'></c:url>">Chi tiet</a> ||
						<a href="<c:url value='/sua-khach-hang/${user.id }'/>">Sua</a>||
					<a href="<c:url value='/xoa-khach-hang/${user.id }'/>">Xoa</a></td>
			</tr>
		</c:forEach>
	</table>
