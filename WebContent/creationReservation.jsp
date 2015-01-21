<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Creation d'une réservation</h1>
	
	<form method="post" action="controleurReservation">
		<label>idVehicule </label>
	    <input type="text" id="idVehicule" name="idVehicule" value="" size="5" maxlength="20" />
	    <br />
	    <label>idClient </label>
	    <input type="text" id="idClient" name="idClient" value="" size="5" maxlength="20" />
	    <br />
	    <label>Date reservation : le </label>
	    <input type="text" id="jourR" name="jourR" value="" size="2" maxlength="2" />/
	    <input type="text" id="moisR" name="moisR" value="" size="2" maxlength="2" />/
	    <input type="text" id="anneeR" name="anneeR" value="" size="4" maxlength="4" /> 
	    à 
	    <input type="text" id="heureR" name="heureR" value="" size="5" maxlength="5" />
	    <br />
	    <br />

	    <label>Date d'échéance : le </label>
	    <input type="text" id="jourE" name="jourE" value="" size="2" maxlength="2" />/
	    <input type="text" id="moisE" name="moisE" value="" size="2" maxlength="2" />/
	    <input type="text" id="anneeE" name="anneeE" value="" size="4" maxlength="4" /> 
	    à 
	    <input type="text" id="heureE" name="heureE" value="" size="5" maxlength="5" />
	    <br />
		<br />
		
	    <input type="submit" value="Valider" />
	    <input type="hidden" name="action" value="creation" />
    </form>
    
    <core:out value="${message}"/>
    
    <br /><a href="./controleurReservation?action=liste">Retour</a>
</body>
</html>