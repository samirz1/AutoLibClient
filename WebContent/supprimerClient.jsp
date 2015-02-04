<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>AutoLib - Projet</title>
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body class="background">
	
	<jsp:include page="inc/top.jsp"></jsp:include>

    <div class="container">
    <div class="row">
    <div class="col-xs-12">
        
        <div class="page">
                
            <div class="row">
	<h1>Supprimer un client</h1>
	<form method="get" action="controleurClient">
		<select class="dropdown-menu" role="menu" name="selectedClient">
			<core:forEach items="${listeClients}" var="client">²
				<option value="<core:out value="${client.getIdClient()}"/>">
					<core:out value="${client.getNom()}"/>
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

