<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Modification d'une station</h1>
	<form method="get" action="controleurReservation">
		<label>idVehicule </label>
	    <input type="text" id="idVehicule" name="idVehicule" value="${resa.getVehicule().getIdVehicule()}" size="20" maxlength="20" />
	    <br />
	    <label>idClient </label>
	    <input type="text" id="idClient" name="idClient" value="${resa.getClient().getIdClient()}" size="20" maxlength="20" />
	    <br />
	    <label>Date reservation </label>
	    <input type="text" id="dateReservation" name="dateReservation" value="${resa.getDateReservation()}" size="20" maxlength="20" />
	     <br />
	    <label>Date echéance </label>
	    <input type="text" id="dateEcheance" name="dateEcheance" value="${resa.getDateEcheance()}" size="20" maxlength="20" />
	    <br />
		<br />
	    <input type="submit" value="Valider" />
	    <input type="hidden" name="action" value="modification" />
	    <input type="hidden" name="idVehicule" value="${resa.getVehicule().getIdVehicule()}" />
	    <input type="hidden" name="idClient" value="${resa.getClient().getIdClient()}" />
    </form>
    
    <core:out value="${message}"/>
    
    <br /><a href="./controleurReservation?action=liste">Retour</a>
</body>
</html>