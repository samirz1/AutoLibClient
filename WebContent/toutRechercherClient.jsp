<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<title>AutoLib - Projet</title>
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body>
<body class="background">
<jsp:include page="inc/top.jsp"></jsp:include>
 <div class="container">
    <div class="row">
    <div class="col-xs-12">
        
        <div class="page">
                
            <div class="row">
	<h1>Liste des clients</h1>
	<table class="table_bordered">
		<tr>
			<th align="center">Login</th>
			<th align="center">Nom</th>
			<th align="center">Prenom</th>
			<th align="center">Date</th>
		</tr>

		<core:forEach items="${listeClients}" var="client">

			<tr>
				<td><core:out value="${client.getLogin()}" /></td>
				<td align="left">${client.getNom()}</td>
				<td align="left">${client.getPrenom()}</td>
				<td align="left">${client.getDateNaissance()}</td>
			<td align="center">
					<a href="controleurClient?action=modifier1&idClient=${client.getIdClient()}" title="modifier "><img src="img/edit.png" alt="modifier" /></a>
					<a href="controleurClient?action=supprimer&idClient=${client.getIdClient()}" title="supprimer " onclick="return confirm('Attention, vous êtes sur le point de supprimer un compte client !');"><img src="img/supprimer.png" alt="supprimer" /></a>
				</td>
			</tr>

		</core:forEach>
	</table>
	 </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>
</body>
</html>

