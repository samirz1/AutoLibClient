<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<title>AutoLib - Projet</title>
<jsp:include page="inc/head.jsp"></jsp:include>
<script type="text/javascript" src="js/Maps.js"></script>
</head>
<body class="background">
	
	<jsp:include page="inc/top.jsp"></jsp:include>

    <div class="container">
    <div class="row">
    <div class="col-xs-12">
        
        <div class="page">
                
            <div class="row">
	<h1>Supprimer un vehicule</h1>
	<form method="get" action="controleurVehicule">
		<select class="dropdown-menu" role="menu" name="selectedVehicule">
			<core:forEach items="${listeVehicules}" var="vehicule">²
				<option value="<core:out value="${vehicule.getIdVehicule()}"/>">
					<core:out value="${vehicule.getIdVehicule()}"/>
				</option>
			</core:forEach>
		</select>
		<button type="submit">Supprimer</button>
		<input type="hidden" name="action" value="supprimer">
	</form>
	<br/>
	<core:out value="${message}"/>
	   </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>
</body>

</html>

