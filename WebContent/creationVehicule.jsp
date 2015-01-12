<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Creation d'un Vehicule</h1>
	<form method="get" action="controleurClient">
		<label>Station </label>
	    <input type="text" id="station" name="station" value="" size="5" maxlength="5" />
	    <br />
	    <label>idBorne </label>
	    <input type="text" id="idBorne " name="idBorne " value="" size="20" maxlength="20" />
	    <br />
	    <label>typeVehicule </label>
	    <input type="text" id="typeVehicule" name="typeVehicule" value="" size="20" maxlength="20" />
	    <br />
		<br />
	    <button type="submit"/> Valider </button>
	    <input type="hidden" name="action" value="creation">
    </form>
    <core:out value="${message}"/>
</body>
</html>