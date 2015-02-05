<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
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
						<h1>Creation d'un Vehicule</h1>
						<c:out value="${message}" />
						<form method="post" action="controleurVehicule" class="form-horizontal" role="form">
						<div class="form-group">
							<label class="control-label col-sm-2" for="station">Station </label>
							<div class="col-sm-10">
						    	<input type="text" id="station" name="station" value="" size="5" maxlength="5" />
						    </div>
					    </div>
					    
					    <div class="form-group">
							<label class="control-label col-sm-2" for="idBorne">Borne </label>
							<div class="col-sm-10">
						    	<input type="text" id="idBorne" name="idBorne" value="" size="5" maxlength="5" />
						    </div>
					    </div>
					    
					    <div class="form-group">
							<label class="control-label col-sm-2" for="typeVehicule">Type de véhicule </label>
							<div class="col-sm-10">
						    	<input type="text" id="typeVehicule" name="typeVehicule" value="" size="5" maxlength="5" />
						    </div>
					    </div><input type="hidden" name="action" value="creation" />
				    
					    <div class="form-group">
	                   		<div class="col-sm-offset-2 col-sm-10">
	                   			<button
									class="btn btn-success" type="submit">
										<span class="glyphicon glyphicon-ok" aria-hidden="true" title="Enregistrer"></span> Enregistrer
								</button>
	                   			<button
									class="btn btn-info" type="reset">
										<span class="glyphicon glyphicon-refresh" aria-hidden="true" title="Réinitialiser"></span>
								</button>
	                   		</div>
	                    </div>
						</form>
						
   				<br /><br />
   				<a href="./controleurVehicule?action=toutRechercher">Retour</a>
            </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>

</body>
</html>