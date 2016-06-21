<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Comentario</title>
</head>
<body>
	<form action="inserirComentario" method = "post">
	<input type = "hidden" name = "idUsuario" value=""/>
	<input type = "hidden" name = "idNoticia" value=""/>
	Texto :<input type ="text" name ="texto" />
	<input type ="submit" name ="ENVIAR" />
	</form>

</body>
</html>