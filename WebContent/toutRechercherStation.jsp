<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Liste des stations</h1>
	
	<a href="./controleurStation?action=creation">nouvelle station</a>
	<table>
	<core:forEach items="${listeStations}" var="station">
		<tr> 
			<td> <core:out value="${station.getIdStation()}"/> </td>
			<td> <core:out value="${station.getNumero()}"/> </td>
			<td> <core:out value="${station.getAdresse()}"/> </td>
			<td> <core:out value="${station.getCodePostal()}"/> </td>
			<td> <core:out value="${station.getVille()}"/> </td>
			<td> <core:out value="${station.getLatitude()}"/>,<core:out value="${station.getLongitude()}"/> </td>
			<td> <a href="controleurStation?action=modification&id=${station.getIdStation()}">modifier</a> </td>
			<td> <a href="controleurStation?action=suppression&id=${station.getIdStation()}" onclick="return confirm('Supprimer ?');">supprimer</a> </td>
		</tr>
	</core:forEach>
	</table>
</body>
</html>

