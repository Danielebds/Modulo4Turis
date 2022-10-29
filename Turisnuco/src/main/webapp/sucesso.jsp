<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastro de Clientes</title>
</head>
<body>
<div class="container">
<fieldset class="form-control">
<h3>Cadastro de Clientes</h3>
<legend>Dados do Cliente Cadastrado</legend>
<p>O seguinte cliente foi cadastrado com sucesso:</p>
<b>NOME: </b> ${Cliente.nome}<br> <b>TELEFONE:</b>
${Cliente.telefone}<br> <b>EMAIL:</b> ${Cliente.email}<br>
</fieldset>
</div>
</body>
</html>