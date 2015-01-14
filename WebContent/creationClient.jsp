<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<body>
	<h1>Creation d'un compte client</h1>
	<form method="get" action="controleurClient">
		<label>Nom </label>
	    <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
	    <br />
	    <label>Prenom </label>
	    <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
	    <br />
	    <label>Date Naissance </label>
	    <input type="text" id="dateNaissance" name="dateNaissance" value="" size="20" maxlength="20" />
	    <br />
		<br />
	    <button type="submit"/> Valider </button>
	    <input type="hidden" name="action" value="creation">
    </form>
    <core:out value="${message}"/>
</body>
</html>