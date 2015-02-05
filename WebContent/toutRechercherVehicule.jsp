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
						<h1>Liste des Vehicules</h1>
						<button class="btn btn-primary" type="button"
							onclick="loc('./controleurVehicule?action=creation');">
							<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
							Nouveau vehicule
						</button>

						<table class="table table-bordered">
							<tr>
								<th align="center">ID</th>
								<th align="center">RFID</th>
								<th align="center">Baterie</th>
								<th align="center">Etat</th>
								<th align="center">Latitude</th>
								<th align="center">LongitudeD</th>
								<th align="center">Type</th>
								<th align="center">Borne</th>
								<th align="center">Station</th>
							</tr>

							<core:forEach items="${listeVehicules}" var="vehicule">
								<tr>
									<td align="left"><core:out
											value="${vehicule.getIdVehicule()}" /></td>
									<td align="left"><core:out value="${vehicule.getRfid()}" /></td>
									<td align="left"><core:out
											value="${vehicule.getEtatBatterie()}" /></td>
									<td align="left"><core:out
											value="${vehicule.getDisponible()}" /></td>
									<td align="left"><core:out
											value="${vehicule.getLatitude()}" /></td>
									<td align="left"><core:out
											value="${vehicule.getLongitude()}" /></td>
									<td align="left"><core:out
											value="${vehicule.getTypeVehicule()}" /></td>
									<td align="left"><core:out
											value="${vehicule.getIdBorne()}" /></td>
									<td align="left"><core:out
											value="${vehicule.getStation()}" /></td>
									<td align="center">
										<button class="btn btn-warning" type="button" onclick="loc('./controleurVehicule?action=modifier&idVehicule=${vehicule.getIdVehicule()}');"><span class="glyphicon glyphicon-pencil" aria-hidden="true" title="Modifier"></span></button>
										<button class="btn btn-danger" type="button" onclick="loc_conf('Attention, vous allez supprimer un véhicule.','./controleurVehicule?action=supprimer&idVehicule=${vehicule.getIdVehicule()}');"><span class="glyphicon glyphicon-trash" aria-hidden="true" title="Supprimer"></span></button>
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

