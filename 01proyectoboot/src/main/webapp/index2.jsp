<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

  <div class="centrado">
  <div class="titulo"><spring:message code="identificar.nombre"/></div>
	<form action="login" method="post">
		<input class="campos" name="nombre" maxlength="20" required="required" placeholder=<spring:message code="juego.nombre"/>><br>
		<input class="campos" type="password" name="pass" maxlength="10" required="required" placeholder="PASS"><br>
		<input class="boton" type="submit" value=<spring:message code="boton.log"/>>
	</form>
	<a class="subtitulo" href="addusuario"><spring:message code="registrado.texto"/></a>
	<p style="color:red;">${error}</p>
  </div>
    	
