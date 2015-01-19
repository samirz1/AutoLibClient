<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Creation d'une réservation</h1>
	<form method="get" action="controleurReservation">
		<label>idVehicule </label>
	    <input type="text" id="idVehicule" name="idVehicule" value="" size="20" maxlength="20" />
	    <br />
	    <label>idClient </label>
	    <input type="text" id="idClient" name="idClient" value="" size="20" maxlength="20" />
	    <br />
	    <label>Date reservation </label>
	    <input type="text" id="dateReservation" name="dateReservation" value="" size="20" maxlength="20" />
	     <br />
	    <label>Date echéance </label>
	    <input type="text" id="dateEcheance" name="dateEcheance" value="" size="20" maxlength="20" />
	    <br />
		<br />
	    <button type="submit"/> Valider </button>
	    <input type="hidden" name="action" value="creation">
    </form>
    
    <core:out value="${message}"/>
    
    <br /><a href="./controleurReservation?action=liste">Retour</a>
</body>
</html>