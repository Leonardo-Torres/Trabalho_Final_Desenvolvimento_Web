<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Secao</title>
</head>
<body>
	<h2> Alterar Secao</h2>

<form action="alterarSecao" method = "post"> 
	<input type = "hidden" name = "id_secao" value = "${secao.id_secao}" />
	Titulo: <input type = "text" name = "titulo" value = "${secao.titulo}" /><br />
	Descricao: <input type = "text" name = "descricao" value = "${secao.descricao}" /><br />
	<input type ="submit" value ="ALTERAR" />

</form>

</body>
</html>