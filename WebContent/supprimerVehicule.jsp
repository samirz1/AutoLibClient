<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Supprimer un vehicule</h1>
	<form method="get" action="controleurVehicule">
		<select class="dropdown-menu" role="menu" name="selectedVehicule">
			<core:forEach items="${listeVehicules}" var="vehicule">²
				<option value="<core:out value="${vehicule.getIdVehicule()}"/>">
					<core:out value="${vehicule.getIdVehicule()}"/>
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

