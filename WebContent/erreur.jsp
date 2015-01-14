<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link type="text/css" rel="stylesheet"
	href="bootstrap/css/bootstrap.css">
</head>
<body>
	<h1>Erreur</h1>
	<p>Une erreur est survenue.</p>
	<p>
		<b>Détails de l'erreur</b><br />
		${erreur}
	</p>
</body>
</html>