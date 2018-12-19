<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="centrado">
	<div class="centro titulo">
		<spring:message code="bienvenido.titulo" />${sesionusuario.nombre}</div>
	<br> <input type="button" onclick="location.href='listar'"
		value="Modificar Datos"> <input type="button"
		onclick="location.href='addjugador'" value="Inscribirse en Torneo">
</div>

<p style="color: red;">${error}</p>
