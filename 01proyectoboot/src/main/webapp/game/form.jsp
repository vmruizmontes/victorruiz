<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="centrado">
	<div class="titulo">
		<spring:message code="juego.titulo" />
	</div>
	<form:form modelAttribute="juego" method="POST" action="addjuego">

		<form:hidden path="id" />
		<form:input class="campos" path="nombre" required="required" /><br>
		<form:select class="campos" path="tipojuego.id" items="${lista}"
			itemLabel="nombre" itemValue="id" required="required" /><br>
		<input class="boton" type="submit"	value="<spring:message code="accion.guardar"/>">
	
	</form:form>

	<br> ${msg} <br> 
	

</div>
<a href="volver"><spring:message code="accion.home"/></a>






