<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Liste des réservations</h1>
	<a href="./controleurReservation?action=creation">nouvelle reservation</a>
	<table>
	<core:forEach items="${listeReservations}" var="resa">
		<tr> 
			<td> <core:out value="${resa.getVehicule().getIdVehicule()}"/> </td>
			<td> <core:out value="${resa.getClient().getIdClient()}"/> </td>
			<td> <core:out value="${resa.getDateReservation()}"/> </td>
			<td> <core:out value="${resa.getDateEcheance()}"/> </td>
			<td> <a href="controleurReservation?action=modification&idVehicule=${resa.getVehicule().getIdVehicule()}&idClient=${resa.getClient().getIdClient()}">modifier</a> </td>
			<td> <a href="controleurStation?action=suppression&idVehicule=${resa.getVehicule().getIdVehicule()}&idClient=${resa.getClient().getIdClient()}" onclick="return confirm('Supprimer ?');">supprimer</a> </td>
		</tr>
	</core:forEach>
	</table>
</body>
</html>

