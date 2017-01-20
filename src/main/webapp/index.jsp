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
		
		<c:if test="${sucesso} not empty">
			<div class="alert alert-success alert-dismissable">
				<strong>Status: </strong>${sucesso} <a href="#" class="alert-link"> ${sucesso}</a>.
			</div>
		</c:if>
		
		<c:if test="${error} not empty">
			<div class="alert alert-danger alert-dismissable">
				<strong>Danger!</strong> ${error}<a href="#" class="alert-link">${error}</a>.
			</div>
		</c:if>
		
			<h3>Cadastro de Usuários</h3>
			
			<form action="/cadastro/novo" method="post">
				<input type="hidden" name="option" value="cadastrar">
				
				<fieldset>
					<legend>Novo cadastro</legend>
					<label for="nome">Nome:</label>
					<input type="text" id="nome" name="nome" required="true" placeholder="Nome">
					<label for="telefone">Telefone:</label>
					<input type="text" id="telefone" name="telefone" required="true" placeholder="Telefone">
					<button type="reset">Limpar</button> &nbsp; <button type="submit">Cadastrar</button>
				</fieldset>				
			</form>
			
			<a href="/relatorio"><button>Relatório</button></a>
		</div>
	</body>
</html>

<style>
form{margin-left: 20%; margin-right: 20%; margin-top: 5%;}
h3{margin-left: 20%; margin-right: 20%; margin-top: 5%;}
</style>