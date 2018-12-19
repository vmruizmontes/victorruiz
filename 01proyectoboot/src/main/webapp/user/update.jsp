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
		<tr>
			<td>${sesionusuario.id}</td>
			<td>${sesionusuario.nombre}</td>
			<td>${sesionusuario.pass}</td>

			<td><a href="buscar?id=${sesionusuario.id}"><spring:message
						code="accion.editar" /></a></td>
			<td><a href="eliminar?nombre=${sesionusuario.nombre}"><spring:message
						code="accion.eliminar" /></a></td>
		</tr>
		</tbody>
	</table>
	
</div>
</div>
<a href="volver"><spring:message code="accion.home" /></a>
