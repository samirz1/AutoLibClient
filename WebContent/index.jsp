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
	<form action="controleurClient?action=toutRechercher" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Consuslter la liste des clients</button>
	</form>
	<form action="controleurClient?action=modifier1" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Modification d'un client</button>
	</form>
	<form action="controleurClient?action=creation" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Creation d'un nouveau client</button>
	</form>
	<form action="controleurClient?action=supprimer" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Supprimer un client</button>
	</form>




	<form action="controleurVehicule?action=toutRechercher" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Consuslter la liste des vehicules</button>
	</form>
	<form action="controleurVehicule?action=modifier" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Modification d'un vehicule</button>
	</form>
	<form action="controleurVehicule?action=creation" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Creation d'un nouveau vehicule</button>
	</form>
	<form action="controleurVehicule?action=supprimer" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Supprimer un vehicule</button>
	</form>
	<form action="controleurVehicule?action=rechercher1" method="POST">
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Rechercher un vehicule</button>
	</form>





	<form action="controleurStation">
		<input type="hidden" name="action" value="liste" />
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Liste des stations</button>
	</form>
	<form action="controleurStation">
		<input type="hidden" name="action" value="creation" />
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Ajouter une station</button>
	</form>








	<form action="controleurReservation">
		<input type="hidden" name="action" value="creation" />
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Ajouter une reservation </button>
	</form>
	
	
	
	<form action="controleurReservation">
		<input type="hidden" name="action" value="liste" />
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Liste des réservations </button>
	</form>
	
	<form action="controleurReservation">
		<input type="hidden" name="action" value="rechercher" />
		<button type="submit" class="btn btn-primary"
			style="display: block; margin: auto; margin-top: 5%; height: 60px;">
			Rechercher une réservation </button>
	</form>


</body>
</html>