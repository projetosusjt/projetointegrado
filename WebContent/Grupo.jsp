<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.com.projetointegrado.model.Grupo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grupo</title>
</head>
<body>
	<%Grupo grupo = (Grupo)request.getAttribute("grupo"); %>
	Id: <%=grupo.getGrupo_id() %><br>
	Nome: <%=grupo.getGrupo_nome() %><br>
	Numero: <%=grupo.getNumero() %><br>
</body>
</html>