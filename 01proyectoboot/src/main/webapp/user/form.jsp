<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

	  <div class="centrado">
	<form:form modelAttribute="usuario" method="POST" action="addusuario">
		<form:hidden path="id" />
		<form:hidden path="tipousuario.id"/>
		<table>
		<tr><td><spring:message code="usuario.nombre"/></td><td><form:input path="nombre" required="required"/></td>
		<tr><td><spring:message code="usuario.pass"/></td><td><form:input path="pass" required="required" /></td>
		<tr><td><spring:message code="usuario.mail"/></td><td><form:input path="mail" required="required" /></td>
		<tr>

			<td>				
				<%-- Formato de fecha --%>
				<fmt:formatDate value="${usuario.fecha}" pattern="dd/MM/yyyy" var="fecha"/>
				<form:hidden path="fecha" value="${fecha}"/>
			</td>
		<tr>
		<tr><td><input type="submit" value="<spring:message code="accion.guardar"/>"/></td></tr>
		</table>
	</form:form>
	</div>
	<br>
	${msg}	
	<br>
	<a href="volver"><spring:message code="accion.home"/></a>
