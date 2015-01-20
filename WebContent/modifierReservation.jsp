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
	    <input type="text" id="dateReservation" name="dateReservation" value="${resa.getJourR()}" size="10" maxlength="20" />
	     <label>Mois </label>
	    <input type="text" id="dateReservation" name="dateReservation" value="${resa.getMoisR()}" size="10" maxlength="20" />
	     <label>Année </label>
	    <input type="text" id="dateReservation" name="dateReservation" value="${resa.getYearR()}" size="10" maxlength="20" />
	    <label>Heure </label>
	    <input type="text" id="dateReservation" name="dateReservation" value="${resa.getHourR()}" size="10" maxlength="20" />
	     <br />
	      <br />
	     
	     
	     
	     
	    <label>Date echéance : </label>
	     <br />
	     <label>Jour </label>
	    <input type="text" id="dateEcheance" name="dateEcheance" value="${resa.getJourE()}" size="10" maxlength="20" />
	    
	     <label>Mois </label>
	    <input type="text" id="dateEcheance" name="dateEcheance" value="${resa.getMoisE()}" size="10" maxlength="20" />
	     <label>Année </label>
	    <input type="text" id="dateEcheance" name="dateEcheance" value="${resa.getYearE()}" size="10" maxlength="20" />
	    <label>Heure </label>
	    <input type="text" id="dateEcheance" name="dateEcheance" value="${resa.getHourE()}" size="10" maxlength="20" />
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