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
		<label>Login </label>
	    <input type="text" id="login" name="login" value="" size="14" maxlength="45" />
	      
	     <label>Pwd</label>
	    <input type="password" id="pwd" name="pwd" value="" size="14" maxlength="45" />
		
	    <button type="submit"/> Valider </button>
	    <input type="hidden" name="action" value="connexionClient">
    </form>
    <core:out value="${message}"/>
</body>
</html>