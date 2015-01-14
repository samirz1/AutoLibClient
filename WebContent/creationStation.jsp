<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Creation d'une station</h1>
	<form method="post" action="controleurStation">
		<label>Numéro </label>
	    <input type="text" id="numero" name="numero" value="" size="4" maxlength="10" />
	    <br />
		<label>Adresse </label>
	    <input type="text" id="adresse" name="adresse" value="" size="50" maxlength="100" />
	    <br />
	    <label>CP </label>
	    <input type="text" id="codepostal" name="codepostal" value="" size="5" maxlength="5" />
	    <br />
	    <label>Ville </label>
	    <input type="text" id="ville" name="ville" value="" size="50" maxlength="60" />
	    <br />
	    <label>Latitude </label>
	    <input type="text" id="latitude" name="latitude" value="" size="50" maxlength="60" />
	    <br />
	    <label>Longitude </label>
	    <input type="text" id="longitude" name="longitude" value="" size="50" maxlength="60" />
	    <br />
		<br />
	    <input type="submit" value="Valider" />
	    <input type="hidden" name="action" value="creation" />
    </form>
    
    <core:out value="${message}"/>
    
    <br /><a href="./controleurStation?action=liste">Retour</a>
</body>
</html>