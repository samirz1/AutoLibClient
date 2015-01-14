<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Liste des Vehicules</h1>
	<core:forEach items="${listeVehicules}" var="vehicule">
		<tr> 
			<td> <core:out value="${vehicule.getIdVehicule()}"/> </td>
			<td> <core:out value="${vehicule.getRfid()}"/> </td>
			<td> <core:out value="${vehicule.getEtatBatterie()}"/> </td>
			<td> <core:out value="${vehicule.getDisponible()}"/> </td>
			<td> <core:out value="${vehicule.getLatitude()}"/> </td>
			<td> <core:out value="${vehicule.getLongitude()}"/> </td>
			<td> <core:out value="${vehicule.getTypeVehicule()}"/> </td>
			<td> <core:out value="${vehicule.getIdBorne()}"/> </td>
			<td> <core:out value="${vehicule.getStation()}"/> </td>
		</tr>
		</br>
	</core:forEach>
</body>
</html>

