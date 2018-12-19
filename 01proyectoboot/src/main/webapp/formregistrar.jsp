<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

	  <div class="centrado">
<h2>Introduzca datos para un nuevo usuario. (No implementado)</h2>
	<form:form modelAttribute="usuario" method="POST" action="guardar">
		<form:hidden path="id" />
		<table>
		<tr><td><spring:message code="usuario.nombre"/></td><td><form:input type="text" path="nombre" required="required" placeholder="Nombre" /></td>
		<tr><td><spring:message code="usuario.pass"/></td><td><form:input type="password" path="pass" required="required" placeholder="Contraseña"/></td>
		<tr><td><spring:message code="usuario.mail"/></td><td><form:input type="mail" path="mail" required="required" placeholder="Mail"/></td>

		
		<tr><td><input type="submit" value="<spring:message code="accion.guardar"/>"/></td></tr>
		</table>
	</form:form>
	</div>
	<br>
	${msg}
	<br>
	<a href="inicio"><spring:message code="accion.inicio"/></a>
