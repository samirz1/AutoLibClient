package controleur;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;

import beans.*;

@WebServlet("/controleurStation")
public class ControleurStation extends SuperControleur {

	private static final long serialVersionUID = 1L;
	
	public ControleurStation() {
        super();
	}

	@Override
	protected String execution() throws Exception {

		String vue = "";
		MyBoolean resultat = null;
		String id = null;
			
		if(action == null) {
			throw new Exception("Argument action manquant dans l'URL.");
		}
		
		switch(action) {
		case "liste":
			List<Station> listeStations = Client.create().resource(WS + "serviceStation/toutRechercher").get(new GenericType<List<Station>>(){});
			request.setAttribute("listeStations", listeStations);
			vue = "/toutRechercherStation.jsp";
			break;
			
		case "plan":
			List<Station> listeStationsPlan = Client.create().resource(WS + "serviceStation/toutRechercherComplet").get(new GenericType<List<Station>>(){});
			request.setAttribute("listeStations", listeStationsPlan);
			vue = "/planStations.jsp";
			break;
			
		case "creation":
			vue = "/creationStation.jsp";
			if(request.getMethod().compareToIgnoreCase("post") == 0) {
				// validation du formulaire
				String param = "";
				param += "numero=" + URLEncoder.encode(request.getParameter("numero"),"ISO-8859-1");
				param += "&adresse=" + URLEncoder.encode(request.getParameter("adresse"),"ISO-8859-1");
				param += "&codePostal=" + URLEncoder.encode(request.getParameter("codepostal"),"ISO-8859-1");
				param += "&ville=" + URLEncoder.encode(request.getParameter("ville"),"ISO-8859-1");
				param += "&latitude=" + URLEncoder.encode(request.getParameter("latitude"),"ISO-8859-1");
				param += "&longitude=" + URLEncoder.encode(request.getParameter("longitude"),"ISO-8859-1");
				
				resultat = Client.create().resource(WS + "serviceStation/ajouter/?" + param).get(MyBoolean.class);
				if(resultat.isB()) {
					request.setAttribute("message", "Enregistrement effectué !");
				} else {
					throw new Exception("Erreur d'enregistrement de la station.");
				}
			} else {
				// affichage du formulaire
				// > aucune action spécifique
			}
			break;
			
		case "suppression":
			vue = "/supprimerStation.jsp";
			id = request.getParameter("id");
			if(id == null) {
				throw new Exception("Paramètre id manquant.");
			}
			resultat = Client.create().resource(WS + "serviceStation/supprimer/" + id + "/").get(MyBoolean.class);
			if(resultat.isB()) {
				request.setAttribute("message", "Suppression effectuée !");
			} else {
				throw new Exception("Erreur de suppression de la station.");
			}
			break;
			
		case "modification":
			id = request.getParameter("id");
			vue = "/modifierStation.jsp";
			
			if(id == null) {
				throw new Exception("Paramètre id manquant.");
			}
			
			if(request.getMethod().compareToIgnoreCase("post") == 0) {
				// validation du formulaire
				String param = "";
				param += "numero=" + URLEncoder.encode(request.getParameter("numero"),"ISO-8859-1");
				param += "&adresse=" + URLEncoder.encode(request.getParameter("adresse"),"ISO-8859-1");
				param += "&codePostal=" + URLEncoder.encode(request.getParameter("codepostal"),"ISO-8859-1");
				param += "&ville=" + URLEncoder.encode(request.getParameter("ville"),"ISO-8859-1");
				param += "&latitude=" + URLEncoder.encode(request.getParameter("latitude"),"ISO-8859-1");
				param += "&longitude=" + URLEncoder.encode(request.getParameter("longitude"),"ISO-8859-1");
				
				resultat = Client.create().resource(WS + "serviceStation/modifier/" + id + "/?" + param).get(MyBoolean.class);
				if(resultat.isB()) {
					request.setAttribute("message", "Mise à jour effectuée !");
				} else {
					throw new Exception("Erreur d'enregistrement de la station.");
				}
			}
			
			Station station = Client.create().resource(WS + "serviceStation/id-" + id).get(Station.class);
			request.setAttribute("station", station);
			break;
			
		default:
			throw new Exception("Cette action ("+action+") n'est pas reconnue pour ce module.");
		}
		
		request.setAttribute("url", "stations");

		return vue;
	}	
	
}
