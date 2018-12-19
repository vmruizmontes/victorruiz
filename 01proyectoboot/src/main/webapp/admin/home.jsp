<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="centrado">
	<div class="centro titulo">
		<spring:message code="bienvenido.titulo" />${sesionusuario.nombre}</div>
	<br> <input type="button" class="boton"
		onclick="location.href='addjugador'"
		value="<spring:message code="boton.crear.torneo"/>"> <input
		type="button" class="boton" onclick="location.href='addjuego'"
		value="<spring:message code="boton.crear.juego"/>"> <input
		type="button" class="boton"
		onclick="location.href='administrarusuarios'"
		value="<spring:message code="boton.administrar.usuario"/>">

</div>

<p style="color: red;">${error}</p>
