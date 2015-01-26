<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
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
                        
                <h1>Plan des stations</h1>
                 
                <c:if test="${sess_type == 'admin'}">
	                <button class="btn btn-primary" type="button" onclick="loc('./controleurStation?action=creation');">
						<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Nouvelle station
					</button>
				</c:if>
	
				<c:if test="${sess_type == 'client'}">
					<c:if test="${resa_encours}">
						Vous avez actuellement un véhicule. Choisissez une station pour le dépôser.
					</c:if>
					<c:if test="${!resa_encours}">
						Choisissez une station pour réserver un véhicule.
					</c:if>
				</c:if>
	
				<script type="text/javascript">
				var places = [

				<c:forEach items="${listeStations}" var="station">
				['<c:out value="${station.getNumero()}"/> <c:out value="${station.getAdresse()}"/><br /><c:out value="${station.texteEtat()}" />', 
					<c:out value="${station.getLongitude()}"/>,<c:out value="${station.getLatitude()}"/>,<c:out value="${station.getEtat()}" />,'<c:out value="${mapaction}" />',<c:out value="${station.getIdStation()}" />],</c:forEach>
				];
			
				var m1 = new Maps({ infosbulles: true, itineraire: false });	
				for(var p = 0 ; p < places.length ; p++) {
					m1.addPlace(places[p][0], places[p][1], places[p][2], places[p][3], places[p][4], places[p][5]);
				}
				m1.refresh();
				</script>
				
				<table cellspacing="10">
					<caption class="b left">Légende</caption>
					<tr>
						<td><img src="./img/car.png" alt="" /></td>
						<td>Toutes les voitures sont disponibles (aucune place libre)</td>
					</tr><tr>
						<td><img src="./img/car-parking.png" alt="" /></td>
						<td>Voitures et places disponibles</td>
					</tr><tr>
						<td><img src="./img/parking.png" alt="" /></td>
						<td>Aucune voitures disponible (toutes les place sont libres)</td>
					</tr>
				</table>
            </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>

</body>
</html>