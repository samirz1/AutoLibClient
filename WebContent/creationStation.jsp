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
                        
                <h1>Ajouter une station</h1>
                <h2>Référencer une nouvelle station sur le plan</h2>
    
    			<c:out value="${message}" />
                
				<form method="post" action="controleurStation" class="form-horizontal" role="form">
					<div class="form-group">
						<label class="control-label col-sm-2" for="numero">Numéro </label>
						<div class="col-sm-10">
					    	<input type="text" id="numero" name="numero" value="${station.getNumero()}" size="5" maxlength="10" />
					    </div>
				    </div>
				    
				    <div class="form-group">
						<label class="control-label col-sm-2" for="adresse">Adresse </label>
					    <div class="col-sm-10">
					    	<input type="text" id="adresse" name="adresse" value="${station.getAdresse()}" size="50" maxlength="100" />
				   		</div>
					</div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="codepostal">CP </label>
					    <div class="col-sm-10">
					    	<input type="text" id="codepostal" name="codepostal" value="${station.getCodePostal()}" size="5" maxlength="5" />
					    </div>
				    </div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="ville">Ville </label>
					    <div class="col-sm-10">
					    	<input type="text" id="ville" name="ville" value="${station.getVille()}" size="50" maxlength="60" />
					    </div>
				    </div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="latitude">Latitude </label>
					    <div class="col-sm-10">
					    	<input type="text" id="latitude" name="latitude" value="${station.getLatitude()}" size="50" maxlength="60" />
					    </div>
				    </div>
				    
				    <div class="form-group">
					    <label class="control-label col-sm-2" for="longitude">Longitude </label>
					    <div class="col-sm-10">
					    	<input type="text" id="longitude" name="longitude" value="${station.getLongitude()}" size="50" maxlength="60" />
					    </div>
				    </div>
				  
				    <input type="hidden" name="action" value="creation" />
				    
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
   				<a href="./controleurStation?action=plan">Retour</a>
            </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>

</body>
</html>