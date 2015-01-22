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
	
				<script type="text/javascript">
				var places = [
				
				<c:if test="${sess_type == 'admin'}">
				<c:forEach items="${listeStations}" var="station">
				['<button class="btn btn-warning" type="button" onclick="loc(\'./controleurStation?action=modification&id=${station.getIdStation()}\');"><span class="glyphicon glyphicon-pencil" aria-hidden="true" title="Modifier"></span></button> <c:out value="${station.getNumero()}"/> <c:out value="${station.getAdresse()}"/>', 
					<c:out value="${station.getLongitude()}"/>,<c:out value="${station.getLatitude()}"/>],</c:forEach></c:if>

					<c:if test="${sess_type == 'client'}">
				<c:forEach items="${listeStations}" var="station">
				['<c:out value="${station.getNumero()}"/> <c:out value="${station.getAdresse()}"/>', 
					<c:out value="${station.getLongitude()}"/>,<c:out value="${station.getLatitude()}"/>],</c:forEach></c:if>
				];
			
				var m1 = new Maps({ infosbulles: true, itineraire: false });	
				for(var p = 0 ; p < places.length ; p++) {
					m1.addPlace(places[p][0], places[p][1], places[p][2]);
				}
				m1.refresh();
				</script>
            </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>

</body>
</html>