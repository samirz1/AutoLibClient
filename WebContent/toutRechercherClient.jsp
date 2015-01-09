<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Liste des clients</h1>
	<core:forEach items="${listeClients}" var="client">
		<tr> 
			<td> <core:out value="${client.getNom()}"/> </td>
			<td> <core:out value="${client.getPrenom()}"/> </td>
			<td> <core:out value="${client.getDateNaissance()}"/> </td>
		</tr>
		</br>
	</core:forEach>
</body>
</html>

