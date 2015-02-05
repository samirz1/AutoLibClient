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
                        
                <h1>Modifier un véhicule</h1>
                <h2>Modification des informations relative au véhicule n°${vehicule.getIdVehicule()}</h2>
                
    			<c:out value="${message}" />
    			
				<form method="post" action="controleurVehicule" class="form-horizontal" role="form">
					<input type="hidden" id="idVehicule" name="idVehicule" value="${vehicule.getIdVehicule()}"  />
					<input type="hidden" id="ancienIdBorne" name="ancienIdBorne" value="${vehicule.getIdBorne()}"  />
					<div class="form-group">
						<label class="control-label col-sm-2" for="NouveauStation">Station </label>
						<div class="col-sm-10">
					    	<input type="text" id="NouveauStation" name="NouveauStation" value="${vehicule.getStation()}" size="5" maxlength="10" />
					    </div>
				    </div>
				    
				    <div class="form-group">
						<label class="control-label col-sm-2" for="nouveauIdBorne">Borne </label>
					    <div class="col-sm-10">
					    	<input type="text" id="nouveauIdBorne" name="nouveauIdBorne" value="${vehicule.getIdBorne()}" size="5" maxlength="10" />
				   		</div>
					</div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="RFID">RFID </label>
					    <div class="col-sm-10">
					    	<input type="text" id="RFID" name="RFID" value="${vehicule.getRfid()}" size="50" maxlength="50" />
					    </div>
				    </div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="etatBatterie">Batterie restante </label>
					    <div class="col-sm-10">
					    	<input type="text" id="etatBatterie" name="etatBatterie" value="${vehicule.getEtatBatterie()}" size="3" maxlength="3" />
					    </div>
				    </div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="Disponibilite">Disponibilite </label>
					    <div class="col-sm-10">
					    	<input type="text" id="Disponibilite" name="Disponibilite" value="${vehicule.getDisponible()}" size="50" maxlength="60" />
					    </div>
				    </div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="type_vehicule">Type de véhicule </label>
					    <div class="col-sm-10">
					    	<input type="text" id="type_vehicule" name="type_vehicule" value="${vehicule.getTypeVehicule()}" size="50" maxlength="60" />
					    </div>
				    </div>
				  
				    <input type="hidden" name="action" value="modifier" />
				    <input type="hidden" name="id" value="${vehicule.getIdVehicule()}" />
				    
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
                   			<button
								class="btn btn-danger" type="button"
								onclick="loc_conf('Attention, vous êtes sur le point de supprimer complètement ce véhicule !','./controleurVehicule?action=supprimer&idVehicule=${vehicule.getIdVehicule()}');">
									<span class="glyphicon glyphicon-trash" aria-hidden="true" title="Supprimer"></span>
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