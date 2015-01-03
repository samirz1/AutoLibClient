<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Connection d'un client</h1>
	<form method="get" action="controleur">
		<label>Nom Client </label>
	    <input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20" />
	    <br />    
		
	    <button type="submit"/> Valider </button>
	    <input type="hidden" name="action" value="connexionClient">
    </form>
    <core:out value="${message}"/>
</body>
</html>