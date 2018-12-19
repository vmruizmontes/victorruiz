<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

	  <div class="centrado">
<div class="centro titulo">
		<spring:message code="disculpas.mensaje" />${sesionusuario.nombre}</div>

	
	<div class="centro titulo">
	<spring:message code="pagina.construccion" /></div>
<!--  
<input type="button" onclick="location.href='listar'" value='<spring:message code="boton.editar.perfil"></spring:message>'>
<input type="button" onclick="location.href='inscribir'" value='<spring:message code="boton.inscribirse.torneo"></spring:message>'>


	<form:form modelAttribute="jugador" method="POST" action="addjugador">

		<form:hidden path="id" />
		<form:hidden path="usuario.nombre" itemValue="${sesionusuario.nombre}" />
		
		<form:select class="campos" path="juego.nombre" items="${lista}" itemLabel="nombre" itemValue="nombre" required="required" /><br>
		
						<%-- Formato de fecha --%>
				<form:input type="date" path="fecha" var="fecha1"/>
				<fmt:formatDate value="${fecha1}" pattern="dd/MM/yyyy" var="fecha"/>
				
				
				
		
		
		<br>
		<input class="boton" type="submit"	value="<spring:message code="accion.guardar"/>">

	</form:form>
			



	<p style="color:red;">${error}</p>
	
	-->
	</div>
	<a href="volver"><spring:message code="accion.home"/></a>
