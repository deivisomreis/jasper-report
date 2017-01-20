<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>		 
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>SecurityPass :: Login</title>
	</head>
	<body>
		<div class="container">
			<h3>Relatório</h3>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>Registro</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th><a href="/relatorio?option=novorelatorio">Gerar relatório</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${relatorio}" var="usuario" >
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.telefone}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>

<style>
form{margin-left: 20%; margin-right: 20%; margin-top: 5%;}
h3{margin-left: 20%; margin-right: 20%; margin-top: 5%;}
</style>