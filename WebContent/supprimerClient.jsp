<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Supprimer un client</h1>
	<form method="get" action="controleurClient">
		<select class="dropdown-menu" role="menu" name="selectedClient">
			<core:forEach items="${listeClients}" var="client">²
				<option value="<core:out value="${client.getIdClient()}"/>">
					<core:out value="${client.getNom()}"/>
				</option>
			</core:forEach>
		</select>
		<button type="submit">Supprimer</button>
		<input type="hidden" name="action" value="supprimer">
	</form>
	<br/>
	<core:out value="${message}"/>
</body>
</html>

