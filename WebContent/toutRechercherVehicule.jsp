<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
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
						<meta charset="utf-8" />
						</head>
						<body>
							<h1>Liste des Vehicules</h1>
							<table class="table_bordered">
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

									<core:forEach items="${listeVehicules}" var="vehicule">
										<tr>
											<td><core:out value="${vehicule.getIdVehicule()}" /></td>
											<td><core:out value="${vehicule.getRfid()}" /></td>
											<td><core:out value="${vehicule.getEtatBatterie()}" /></td>
											<td><core:out value="${vehicule.getDisponible()}" /></td>
											<td><core:out value="${vehicule.getLatitude()}" /></td>
											<td><core:out value="${vehicule.getLongitude()}" /></td>
											<td><core:out value="${vehicule.getTypeVehicule()}" /></td>
											<td><core:out value="${vehicule.getIdBorne()}" /></td>
											<td><core:out value="${vehicule.getStation()}" /></td>
											<td align="center">
					<a href="controleurVehicule?action=modifier&idVehicule=${vehicule.getIdVehicule()}" title="modifier "><img src="img/edit.png" alt="modifier" /></a>
					<a href="controleurVehicule?action=supprimer&idVehicule=${vehicule.getIdVehicule()}" title="supprimer " onclick="return confirm('Attention, vous êtes sur le point de supprimer un vehicule  !');"><img src="img/supprimer.png" alt="supprimer" /></a>
				</td>
									</core:forEach>
							</table>
						</body>
</html>

