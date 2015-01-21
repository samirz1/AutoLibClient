package controleur;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;

import beans.*;

@WebServlet("/controleurReservation")
public class ControleurReservation extends SuperControleur {

	private static final long serialVersionUID = 1L;

	public ControleurReservation() {
        super();
	}
	
	protected String checkHeureMinute(String hm) {
		if(!hm.contains(":")) {
			return hm + ":00";
		} else {
			return hm;
		}
	}

	@Override
	protected String execution() throws Exception {

		String vue = "";
		MyBoolean resultat = null;
		String idVehicule = null;
		String idClient = null;
		String url = null;

		if(action == null) {
			throw new Exception("Argumant action manquant dans l'URL.");
		}
		
		switch(action) {
		case "liste":
			List<Reservation> listeReservations = Client.create().resource(WS + "serviceReservation/toutRechercher").get(new GenericType<List<Reservation>>(){});
			request.setAttribute("listeReservations", listeReservations);
			vue = "/toutRechercherReservation.jsp";
			break;
			
		case "creation":
			vue = "/creationReservation.jsp";
			if(isPost()) {
				// validation du formulaire
				
				// url d'appel de la forme ..../idVehicule/idClient/dateRésa/dateEchéance
				url = "";
				url += URLEncoder.encode(request.getParameter("idVehicule"),"ISO-8859-1");
				url += "/" + URLEncoder.encode(request.getParameter("idClient"),"ISO-8859-1");
				url += "/" + URLEncoder.encode(request.getParameter("anneeR")
						+ "-" + request.getParameter("moisR")
						+ "-" + request.getParameter("jourR")
						+ " " + checkHeureMinute(request.getParameter("heureR")) + ":00","ISO-8859-1") ;
				url += "/" + URLEncoder.encode(request.getParameter("anneeE")
						+ "-" + request.getParameter("moisE")
						+ "-" + request.getParameter("jourE")
						+ " " + checkHeureMinute(request.getParameter("heureE")) + ":00","ISO-8859-1") ;
						
				resultat = Client.create().resource(WS + "serviceReservation/creation/" + url).get(MyBoolean.class);
				if(resultat.isB()) {
					request.setAttribute("message", "Enregistrement effectué !");
				} else {
					throw new Exception("Erreur d'enregistrement de la réservation.");
				}
			} else {
				// affichage du formulaire
				// > aucune action spécifique
			}
			break;
			
		case "suppression":
			vue = "/supprimerReservation.jsp";
			idVehicule = request.getParameter("idVehicule");
			idClient = request.getParameter("idClient");
			
			if(idVehicule == null || idClient == null) {
				throw new Exception("Paramètre id(s) manquant(s).");
			}
			
			url = "";
			url += URLEncoder.encode(idVehicule,"ISO-8859-1");
			url += "/" + URLEncoder.encode(idClient,"ISO-8859-1");
			url += "/";
			
			resultat = Client.create().resource(WS + "serviceReservation/supprimer/" + url).get(MyBoolean.class);
			if(resultat.isB()) {
				request.setAttribute("message", "Suppression effectuée !");
			} else {
				throw new Exception("Erreur de suppression de la Reservation.");
			}
			break;
			
		case "modification":
			idVehicule = request.getParameter("idVehicule");
			idClient = request.getParameter("idClient");
			vue = "/modifierReservation.jsp";
			
			if(idVehicule == null || idClient ==null) {
				throw new Exception("Paramètre id(s) manquant(s).");
			}
			
			if(isPost()) {
				// validation du formulaire
				
				// url d'appel de la forme ..../idVehicule/idClient/dateRésa/dateEchéance
				url = "";
				url += URLEncoder.encode(request.getParameter("idVehicule"),"ISO-8859-1");
				url += "/" + URLEncoder.encode(request.getParameter("idClient"),"ISO-8859-1");
				url += "/" + URLEncoder.encode(request.getParameter("anneeR")
						+ "-" + request.getParameter("moisR")
						+ "-" + request.getParameter("jourR")
						+ " " + checkHeureMinute(request.getParameter("heureR")) + ":00","ISO-8859-1") ;
				url += "/" + URLEncoder.encode(request.getParameter("anneeE")
						+ "-" + request.getParameter("moisE")
						+ "-" + request.getParameter("jourE")
						+ " " + checkHeureMinute(request.getParameter("heureE")) + ":00","ISO-8859-1") ;
				
				resultat = Client.create().resource(WS + "serviceReservation/modifier/" + url).get(MyBoolean.class);
				if(resultat.isB()) {
					request.setAttribute("message", "Mise à jour effectuée !");
				} else {
					throw new Exception("Erreur d'enregistrement de la réservation.");
				}
			}
			
			Reservation reservation = Client.create().resource(WS + "serviceReservation/rechercher/" + idVehicule + "/" + idClient).get(Reservation.class);
			request.setAttribute("resa", reservation);
			break;
			
		default:
			throw new Exception("Cette action ("+action+") n'est pas reconnue pour ce module.");
		}
			
		return vue;
	
	}	
	
}
