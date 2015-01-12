<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Modifier un vehicule</h1>
	<form method="get" action="controleurVehicule">
		<select class="dropdown-menu" role="menu" name="idVehicule">
			<core:forEach items="${listeVehicules}" var="vehicule">²
				<option value="<core:out value="${vehicule.getIdVehicule()}"/>">
					<core:out value="${vehicule.getidVehicule()}"/>
				</option>
			</core:forEach>
		</select>
		<input type="hidden" id="ancienIdBorne" name="ancienIdBorne" value="${idBorne}"  />
		<label>Station </label>
	    <input type="text" id="NouveauStation" name="NouveauStation" value="<core:out value="${station}"/>" size="20" maxlength="20" />
	    <br />
		<label>Borne </label>
	    <input type="text" id="nouveauIdBorne" name="nouveauIdBorne" value="<core:out value="${idBorne}"/>" size="20" maxlength="20" />
	    <br />
	    <label>RFID </label>
	    <input type="text" id="RFID" name="RFID" value="<core:out value="${Rfid}"/>" size="20" maxlength="20" />
	    <br />
	    <label>Etat de la batterie </label>
	    <input type="text" id="etatBatterie" name="etatBatterie" value="<core:out value="${etatBatterie}"/>" size="20" maxlength="20" />
	    <br />
	    <label>Disponibilite </label>
	    <input type="text" id="Disponibilite" name="Disponibilite" value="<core:out value="${disponible}"/>" size="20" maxlength="20" />
	    <br />
	    <label>Type du vehicule </label>
	    <input type="text" id="type_vehicule" name="type_vehicule" value="<core:out value="${typeVehicule}"/>" size="20" maxlength="20" />
	    <br />
		<br />
	    <button type="submit"/> Modifier </button>
	    <input type="hidden" name="action" value="modifier">
    </form>
	
	<core:out value="${message}"/>
</body>
</html>

