<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="centrado">
<div class="titulo"><spring:message code="titulo.editar.usuario" /></div>
<br>

<div class="container">

	<table class="table table-hover">
		<thead>
			<tr>
				<th><spring:message code="usuario.id" /></th>
				<th><spring:message code="usuario.nombre" /></th>
				<th><spring:message code="usuario.pass" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.nombre}</td>
					<td>${item.pass}</td>

					<td><a href="buscar?id=${item.id}"><spring:message
								code="accion.editar" /></a></td>
					<td><a href="eliminar?nombre=${item.nombre}"><spring:message
								code="accion.eliminar" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>
</div>
<a href="volver"><spring:message code="accion.home"/></a>



