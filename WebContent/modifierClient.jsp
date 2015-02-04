<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
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
						<h1>Modifier un client</h1>
						<form method="get" action="controleurClient">
							<select class="dropdown-menu" role="menu" name="selectedClient">
								<core:forEach items="${listeClients}" var="client">²
				<option value="<core:out value="${client.getIdClient()}"/>">
										<core:out value="${client.getNom()}" />
									</option>
								</core:forEach>
							</select>
							<button type="submit">Valider</button>
							<input type="hidden" name="action" value="modifier1">
						</form>
						<br />

						<form method="get" action="controleurClient">
							<label>Nom </label> <input type="text" id="nom" name="nom"
								value="<core:out value="${nom}"/>" size="20" maxlength="20" />
							<br /> <label>Prenom </label> <input type="text" id="prenom"
								name="prenom" value="<core:out value="${prenom}"/>" size="20"
								maxlength="20" /> <br /> <label>Date Naissance </label> <input
								type="text" id="dateNaissance" name="dateNaissance"
								value="<core:out value="${dateNaissance}"/>" size="20"
								maxlength="20" /> <br /> <br />
							<button type="submit" />
							Modifier
							</button>
							<input type="hidden" name="action" value="modifier2">
						</form>

						<core:out value="${message}" />
					</div>

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="inc/bottom.jsp"></jsp:include>
</body>
</html>

