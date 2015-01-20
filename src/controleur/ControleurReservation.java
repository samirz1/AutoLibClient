package controleur;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;

import beans.*;

@WebServlet("/controleurReservation")
public class ControleurReservation extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static String WS = "http://localhost:8080/AutoLibWebService/";

	public ControleurReservation() {
        super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); // on récupère le type d'action
		String vue = "";
		MyBoolean resultat = null;
		String idVehicule = null;
		String idClient = null;
		
		System.out.println("cccc");
		
		try {
			
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
				System.out.println("cc456");
				vue = "/creationReservation.jsp";
				if(request.getMethod().compareToIgnoreCase("post") == 0) {
					// validation du formulaire
					String param = "";
					param += "idVehicule=" + URLEncoder.encode(request.getParameter("idvehicule"),"ISO-8859-1");
					param += "idClient=" + URLEncoder.encode(request.getParameter("idClient"),"ISO-8859-1");
					param += "dateReservation=" + URLEncoder.encode(request.getParameter("dateReservation"),"ISO-8859-1");
					param += "dateEcheance=" + URLEncoder.encode(request.getParameter("dateEcheance"),"ISO-8859-1");
					
					resultat = Client.create().resource(WS + "serviceReservation/creation/?" + param).get(MyBoolean.class);
					System.out.println("cc");
					if(resultat.isB()) {
						request.setAttribute("message", "Enregistrement effectué !");
					} else {
						throw new Exception("Erreur d'enregistrement de la Reservation.");
					}
				} else {
					// affichage du formulaire
					// > aucune action spécifique
				}
				break;
				
			case "suppression":
				vue = "/supprimerReservation.jsp";
				idVehicule = request.getParameter("idvehicule");
				idClient = request.getParameter("idClient");
				System.out.println("idVehicule"+idVehicule);
				System.out.println("idClient");
				if(idVehicule == null || idClient ==null) {
					throw new Exception("Paramètre id(s) manquants.");
				}
				resultat = Client.create().resource(WS + "serviceReservation/supprimer/" + idVehicule +idClient+ "/").get(MyBoolean.class);
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
					throw new Exception("Paramètre id manquant.");
				}
				System.out.println("idV"+idVehicule + "idC"+idClient);
				
				if(request.getMethod().compareToIgnoreCase("post") == 0) {
					// validation du formulaire
					String param = "";
					//param += "idVehicule=" + URLEncoder.encode(request.getParameter("idvehicule"),"ISO-8859-1");
					//param += "idClient=" + URLEncoder.encode(request.getParameter("idClient"),"ISO-8859-1");
					param += "dateReservation=" + URLEncoder.encode(request.getParameter("dateReservation"),"ISO-8859-1");
					param += "dateEcheance=" + URLEncoder.encode(request.getParameter("dateEcheance"),"ISO-8859-1");
					System.out.println("param");
					resultat = Client.create().resource(WS + "serviceReservation/modifier/" + idVehicule+"/"  +idClient + "/?" + param).get(MyBoolean.class);
					if(resultat.isB()) {
						request.setAttribute("message", "Mise à jour effectuée !");
					} else {
						throw new Exception("Erreur d'enregistrement de la Reservation.");
					}
				}
				
				Reservation reservation = Client.create().resource(WS + "serviceReservation/rechercher/" + idVehicule+"/" +idClient).get(Reservation.class);
				request.setAttribute("resa", reservation);
				break;
				
			default:
				throw new Exception("Cette action ("+action+") n'est pas reconnue pour ce module.");
			}
			
		} catch(Exception e) {
			request.setAttribute("erreur", e.getMessage());
			vue = "/erreur.jsp";
		}
		
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);
	
	}	
	
}
