<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>AutoLib - Projet</title>
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body class="background">

	<jsp:include page="inc/top.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">

				<div class="page">

					<div class="row">
						<h1>Creation d'un compte client</h1>
						<form method="get" action="controleurClient">
						<label>Login </label> <input type="text" id="login" name="login"
								value="" size="20" maxlength="20" /> <br /> 
								<label>Pwd </label> <input type="password" id="pwd" name="pwd"
								value="" size="20" maxlength="20" /> <br /> 
							<label>Nom </label> <input type="text" id="nom" name="nom"
								value="" size="20" maxlength="20" /> <br /> <label>Prenom
							</label> <input type="text" id="prenom" name="prenom" value="" size="20"
								maxlength="20" /> <br /> <label>Date Naissance </label> <input
								type="text" id="dateNaissance" name="dateNaissance" value=""
								size="20" maxlength="20" /> <br /> <br />
							<button type="submit" />
							Valider
							</button>
							<input type="hidden" name="action" value="creation">
						</form>
						<core:out value="${message}" />
						<jsp:include page="inc/bottom.jsp"></jsp:include>
</body>
</html>