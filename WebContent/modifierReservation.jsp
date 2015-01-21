<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Modification d'une réservation</h1>
	<form method="post" action="controleurReservation">
		<label>idVehicule : </label>
	    ${resa.getVehicule().getIdVehicule()}
	    <br />
	    <label>idClient :</label>
	    ${resa.getClient().getIdClient()}
	    <br />
	    <br />
	    
	    
	    <label>Date reservation : le </label>
	    <input type="text" id="jourR" name="jourR" value="${resa.getJourR()}" size="2" maxlength="2" />/
	    <input type="text" id="moisR" name="moisR" value="${resa.getMoisR()}" size="2" maxlength="2" />/
	    <input type="text" id="anneeR" name="anneeR" value="${resa.getAnneeR()}" size="4" maxlength="4" /> 
	    à 
	    <input type="text" id="heureR" name="heureR" value="${resa.getHeureR()}" size="5" maxlength="5" />
	    <br />
	    <br />

	    <label>Date d'échéance : le </label>
	    <input type="text" id="jourE" name="jourE" value="${resa.getJourE()}" size="2" maxlength="2" />/
	    <input type="text" id="moisE" name="moisE" value="${resa.getMoisE()}" size="2" maxlength="2" />/
	    <input type="text" id="anneeE" name="anneeE" value="${resa.getAnneeE()}" size="4" maxlength="4" /> 
	    à 
	    <input type="text" id="heureE" name="heureE" value="${resa.getHeureE()}" size="5" maxlength="5" />
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