<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
	<a class="navbar-brand subtitulo" href="volver">TrueGamer</a>
	<ul class="navbar-nav">


		<c:if test="${not empty sesionusuario}">
			<li class="nav-item active"><a class="nav-link" href="sesion">${sesionusuario.nombre}
					<spring:message code="cerrar.sesion"/></a></li>
		</c:if>
		
		<c:if test="${empty sesionusuario}">
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle"	href="#" id="navbardrop" data-toggle="dropdown"> 
			<spring:message	code="menu.idioma" /></a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="inicio?lang=es"><spring:message code="idioma.es" /></a> 
				<a class="dropdown-item" href="inicio?lang=en"><spring:message code="idioma.en" /></a>
			</div></li>
		</c:if>


		<!-- Dropdown -->
		

	</ul>
</nav>