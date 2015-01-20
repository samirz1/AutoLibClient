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
		<label>idVehicule : </label>
	    ${resa.getVehicule().getIdVehicule()}
	    <br />
	    <label>idClient :</label>
	    ${resa.getClient().getIdClient()}
	    <br />
	     <br />
	    
	    
	    <label>Date reservation:  </label>
	    <br />
	     <label>Jour </label>
	    <input type="text" id="jourR" name="jourR" value="${resa.getJourR()}" size="10" maxlength="20" />
	     <label>Mois </label>
	    <input type="text" id="moisR" name="moisR" value="${resa.getMoisR()}" size="10" maxlength="20" />
	     <label>Année </label>
	    <input type="text" id="anneeR" name="anneeR" value="${resa.getYearR()}" size="10" maxlength="20" />
	    <label>Heure </label>
	    <input type="text" id="heureR" name="heureR" value="${resa.getHourR()}" size="10" maxlength="20" />
	     <br />
	      <br />
	     
	     
	     
	     
	    <label>Date echéance : </label>
	     <br />
	     <label>Jour </label>
	    <input type="text" id="jourE" name="jourE" value="${resa.getJourE()}" size="10" maxlength="20" />
	    
	     <label>Mois </label>
	    <input type="text" id="moisE" name="moisE" value="${resa.getMoisE()}" size="10" maxlength="20" />
	     <label>Année </label>
	    <input type="text" id="annneE" name="annneE" value="${resa.getYearE()}" size="10" maxlength="20" />
	    <label>Heure </label>
	    <input type="text" id="heureE" name="heureE" value="${resa.getHourE()}" size="10" maxlength="20" />
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