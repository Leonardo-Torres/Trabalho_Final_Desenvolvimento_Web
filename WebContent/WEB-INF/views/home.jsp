<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MUNDIÇA NEWS</title>
</head>
<body>
	<center> 
	<h1>Mundiça News</h1><br/>
	<c:if test="${usuario == null}">
		<a href="loginUsuarioFormulario">Login</a><br/>
		<a href="inserirLeitorFormulario">Cadastro</a>
	</c:if>
	<c:if test="${usuario != null}">
		<a href="logout">Sair do Jornal</a>
	</c:if>
	</center>
	<c:if test="${editor_logado != null}">
		<a href = "inserirJornalistaformulario">Inserir Jornalista</a><br/>
		<a href = "listarUsuario">Listar Usuarios</a><br/>
		<a href = "alterarSecaoFormulario">Alterar Secao</a><br/>
		<a href = "inserirSecaoFormulario">Inserir Secao</a><br/>
		<a href = "listarSecao">Listar Secao</a><br/>
	</c:if>
</body>
</html>