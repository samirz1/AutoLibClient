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
			
			<button class="btn btn-primary" type="button" onclick="loc('./controleurClient?action=creation');">
				<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Nouveau client
			</button>
							
			<table class="table table-bordered">
				<tr>
					<th align="center">Login</th>
					<th align="center">Nom</th>
					<th align="center">Prenom</th>
					<th align="center">Date de naissance</th>
				</tr>
		
				<core:forEach items="${listeClients}" var="client">
		
					<tr>
						<td><core:out value="${client.getLogin()}" /></td>
						<td align="left">${client.getNom()}</td>
						<td align="left">${client.getPrenom()}</td>
						<td align="left">${client.getDateNaissanceAfficher()}</td>
					<td align="center">
							<button class="btn btn-warning" type="button" onclick="loc('./controleurClient?action=modification&idClient=${client.getIdClient()}');"><span class="glyphicon glyphicon-pencil" aria-hidden="true" title="Modifier"></span></button>
							<button class="btn btn-danger" type="button" onclick="loc_conf('Attention, vous allez supprimer un client.','./controleurClient?action=suppression&idClient=${client.getIdClient()}');"><span class="glyphicon glyphicon-trash" aria-hidden="true" title="Supprimer"></span></button>
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