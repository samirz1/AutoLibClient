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
						<h1>Modification d'un compte client</h1>
						
						<c:out value="${message}" />
						
						<form method="post" action="controleurClient" class="form-horizontal" role="form">
						
						<div class="form-group">
							<label class="control-label col-sm-2" for="numero">Login </label>
							<div class="col-sm-10">
						    	<input type="text" id="login" name="login" value="${cli.getLogin()}" size="20" maxlength="80" />
						    </div>
					    </div>
					    
					    <div class="form-group">
							<label class="control-label col-sm-2" for="numero">Mot de passe </label>
							<div class="col-sm-10">
						    	<input type="text" id="pwd" name="pwd" value="${cli.getPwd()}" size="20" maxlength="150" />
						    </div>
					    </div>
					    
					    <div class="form-group">
							<label class="control-label col-sm-2" for="nom">Nom </label>
							<div class="col-sm-10">
						    	<input type="text" id="nom" name="nom" value="${cli.getNom()}" size="20" maxlength="150" />
						    </div>
					    </div>
					    
					    <div class="form-group">
							<label class="control-label col-sm-2" for="prenom">Prénom </label>
							<div class="col-sm-10">
						    	<input type="text" id="prenom" name="prenom" value="${cli.getPrenom()}" size="20" maxlength="150" />
						    </div>
					    </div>
					    
					    <div class="form-group">
							<label class="control-label col-sm-2" for="dateNaissance">Date de naissance </label>
							<div class="col-sm-10">
						    	<input type="text" placeholder="AAAA-MM-JJ" id="dateNaissance" name="dateNaissance" data-provide="datepicker" data-date-format="yyyy-mm-dd" class="datepicker" value="${cli.getDateNaissanceString()}" size="20" maxlength="150" />
						    </div>
					    </div>
					    
					    <input type="hidden" name="action" value="modification" />
					    <input type="hidden" name="idClient" value="${cli.getIdClient()}" />
				    
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
						<script type="text/javascript">
						$('.datepicker').datepicker({
							 startView: 2,
							 language: "fr"
						});
						</script>
						
						</form>
						
   				<br /><br />
   				<a href="./controleurClient?action=liste">Retour</a>
            </div>
            
        </div>
    </div>
    </div>
    </div>
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>

</body>
</html>