package controleur;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;

import beans.MyBoolean;
import beans.Vehicule;

@WebServlet("/controleurVehicule")
public class ControleurVehicule extends SuperControleur {

	private static final long serialVersionUID = 1L;
	private String idVehicule;

	public ControleurVehicule() {
		super();
	}

	@Override
	protected String execution() throws Exception {

		checkLoggedin();

		String vue = "";
		MyBoolean resultat = null;
		String id = null;
		List<beans.Vehicule> listeVehicules=null;

		if (action == null) {
			throw new Exception("Argument action manquant dans l'URL.");
		}

		switch (action) {
		case "creation":
			if (request.getParameter("typeVehicule") != null
					&& request.getParameter("station") != null
					&& request.getParameter("idBorne") != null) {
				Integer typeVehicule = Integer.parseInt(request
						.getParameter("typeVehicule"));
				Integer station = Integer.parseInt(request
						.getParameter("station"));
				Integer idBorne = Integer.parseInt(request
						.getParameter("idBorne"));
				resultat = Client
						.create()
						.resource(
								"http://localhost:8080/"
										+ "AutoLibWebService/serviceVehicule/creation/"
										+ typeVehicule + "/" + station + "/"
										+ idBorne).get(MyBoolean.class);
				if (resultat.isB()) {
					request.setAttribute("message",
							"Creation du véhicule effectué");
				} else {
					request.setAttribute("message",
							"Echec de la creation du véhicule");
				}
			}
			vue = "/creationVehicule.jsp";
			break;
		case "supprimer":
			String idVehicule = request.getParameter("idVehicule");
			if (idVehicule != null && !idVehicule.isEmpty()) {
				resultat = Client
						.create()
						.resource(
								"http://localhost:8080/"
										+ "AutoLibWebService/serviceVehicule/supprimer/"
										+ idVehicule).get(MyBoolean.class);
				if (resultat.isB())
					request.setAttribute("message",
							"Supression du véhicule effectué");
				else
					request.setAttribute("message",
							"Echec de la suppression du véhicule");
			}
			listeVehicules = Client
					.create()
					.resource(
							"http://localhost:8080/AutoLibWebService/serviceVehicule/toutRechercher")
					.get(new GenericType<List<beans.Vehicule>>() {
					});
			request.setAttribute("listeVehicules", listeVehicules);
			vue = "/toutRechercherVehicule.jsp";
			break;
		case "rechercher1":
			idVehicule = request.getParameter("selectedVehicule");
			this.idVehicule = idVehicule;
			if (idVehicule != null && !idVehicule.isEmpty()) {
				beans.Vehicule resultatVehicule = Client
						.create()
						.resource(
								"http://localhost:8080/"
										+ "AutoLibWebService/serviceClient/rechercher/"
										+ idVehicule).get(beans.Vehicule.class);
			}
			vue = "/affichageVehicule.jsp";
			break;
		case "rechercher2":
			String idBorne = request.getParameter("idBorne");
			if (idBorne != null && !idBorne.isEmpty()) {
				beans.Vehicule resultatVehicule = Client
						.create()
						.resource(
								"http://localhost:8080/"
										+ "AutoLibWebService/serviceClient/rechercherVehiculeBorne/"
										+ idBorne).get(beans.Vehicule.class);
			}
			vue = "/affichageVehicule.jsp";
			break;
		case "modifier":
			idVehicule = request.getParameter("idVehicule");
			String ancienIdBorne = request.getParameter("ancienIdBorne");
			String nouveauIdBorne = request.getParameter("nouveauIdBorne");
			String NouveauStation = request.getParameter("NouveauStation");
			String RFID = request.getParameter("RFID");
			String etatBatterie = request.getParameter("etatBatterie");
			String Disponibilite = request.getParameter("Disponibilite");
			String type_vehicule = request.getParameter("type_vehicule");
			if (ancienIdBorne != null) {
				resultat = Client
						.create()
						.resource(
								"http://localhost:8080/"
										+ "AutoLibWebService/serviceVehicule/modifier/"
										+ idVehicule + "/" + ancienIdBorne
										+ "/" + nouveauIdBorne + "/"
										+ NouveauStation + "/" + RFID + "/"
										+ etatBatterie + "/" + Disponibilite
										+ "/" + type_vehicule)
						.get(MyBoolean.class);
				if (resultat.isB()) {
					request.setAttribute("message",
							"Modification du véhicule effectué");
				} else {
					request.setAttribute("message",
							"Echec de la modification du véhicule");
				}
			}
			beans.Vehicule resultatVehicule = Client
					.create()
					.resource(
							"http://localhost:8080/"
									+ "AutoLibWebService/serviceVehicule/rechercher/"
									+ idVehicule).get(beans.Vehicule.class);
			request.setAttribute("vehicule", resultatVehicule);
			vue = "/modifierVehicule.jsp";
			break;
		case "toutRechercher":
			listeVehicules = Client
					.create()
					.resource(
							"http://localhost:8080/AutoLibWebService/serviceVehicule/toutRechercher")
					.get(new GenericType<List<beans.Vehicule>>() {
					});
			request.setAttribute("listeVehicules", listeVehicules);
			vue = "/toutRechercherVehicule.jsp";
			break;
		}
		return vue;
	}
}
