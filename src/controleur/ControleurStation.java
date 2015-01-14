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

@WebServlet("/controleurStation")
public class ControleurStation extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static String WS = "http://localhost:8080/AutoLibWebService/";

	public ControleurStation() {
        super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); // on récupère le type d'action
		String vue = "";
		MyBoolean resultat = null;
		String id = null;
		
		try {
			
			if(action == null) {
				throw new Exception("Argumant action manquant dans l'URL.");
			}
			
			switch(action) {
			case "liste":
				List<Station> listeStations = Client.create().resource(WS + "serviceStation/toutRechercher").get(new GenericType<List<Station>>(){});
				request.setAttribute("listeStations", listeStations);
				vue = "/toutRechercherStation.jsp";
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
			
		} catch(Exception e) {
			request.setAttribute("erreur", e.getMessage());
			vue = "/erreur.jsp";
		}
		
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);
		/*
		if (action != null && action.equals("creation")) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String dateNaissance = request.getParameter("dateNaissance");
			//System.out.println("Creation : " + nom +  "  " + prenom + "  " + dateNaissance);
			if(nom!=null && !nom.isEmpty() && prenom!=null && !prenom.isEmpty() && dateNaissance!=null && !dateNaissance.isEmpty()){
				MyBoolean resultat = Client.create().resource("http://localhost:8080/"
						+ "AutoLibWebService/serviceClient/creation/" + nom + "/" + prenom + "/" + dateNaissance).get(MyBoolean.class);
				if(resultat.isB()) request.setAttribute("message", "Creation du compte effectué");
				else request.setAttribute("message", "Echec de la creation du compte");
			}			
			this.getServletContext().getRequestDispatcher( "/creationClient.jsp" ).forward( request, response );
		}else if(action != null && action.equals("supprimer")){
			String idClient = request.getParameter("selectedClient");
			if(idClient!=null && !idClient.isEmpty()){
				MyBoolean resultat = Client.create().resource("http://localhost:8080/"
						+ "AutoLibWebService/serviceClient/supprimer/" + idClient).get(MyBoolean.class);
				if(resultat.isB()) request.setAttribute("message", "Supression du compte effectué");
				else request.setAttribute("message", "Echec de la suppression du compte");
			}
			List<beans.Client> listeClients = Client.create().resource("http://localhost:8080/AutoLibWebService/serviceClient/toutRechercher").get(new GenericType<List<beans.Client>>(){});
			request.setAttribute("listeClients", listeClients);	
			this.getServletContext().getRequestDispatcher( "/supprimerClient.jsp" ).forward( request, response );
			//System.out.println("SUP");
		}else if(action != null && action.equals("modifier1")){
			String idClient = request.getParameter("selectedClient");
			this.idClient = idClient;
			if(idClient!=null && !idClient.isEmpty()){
				beans.Client resultat = Client.create().resource("http://localhost:8080/"
						+ "AutoLibWebService/serviceClient/rechercher/" + idClient).get(beans.Client.class);
				request.setAttribute("nom", resultat.getNom());
				request.setAttribute("prenom", resultat.getPrenom());

					DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					request.setAttribute("dateNaissance", formatter.format(resultat.getDateNaissance()));

				System.out.println(resultat.getNom() + resultat.getPrenom() + resultat.getDateNaissance());
			}
			List<beans.Client> listeClients = Client.create().resource("http://localhost:8080/AutoLibWebService/serviceClient/toutRechercher").get(new GenericType<List<beans.Client>>(){});
			request.setAttribute("listeClients", listeClients);	
			this.getServletContext().getRequestDispatcher( "/modifierClient.jsp" ).forward( request, response );
		}else if(action != null && action.equals("modifier2")){
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String dateNaissance = request.getParameter("dateNaissance");
			MyBoolean resultat = Client.create().resource("http://localhost:8080/"
					+ "AutoLibWebService/serviceClient/modifier/" + this.idClient+"/"+nom+"/"+prenom+"/"+dateNaissance).get(MyBoolean.class);
			if(resultat.isB()) request.setAttribute("message", "Modification du compte effectué");
			else request.setAttribute("message", "Echec de la modification du compte");
			List<beans.Client> listeClients = Client.create().resource("http://localhost:8080/AutoLibWebService/serviceClient/toutRechercher").get(new GenericType<List<beans.Client>>(){});
			request.setAttribute("listeClients", listeClients);	
			this.getServletContext().getRequestDispatcher( "/modifierClient.jsp" ).forward( request, response );
		}else if(action != null && action.equals("toutRechercher")){
			List<beans.Client> listeClients = Client.create().resource("http://localhost:8080/AutoLibWebService/serviceClient/toutRechercher").get(new GenericType<List<beans.Client>>(){});
			request.setAttribute("listeClients", listeClients);
			this.getServletContext().getRequestDispatcher( "/toutRechercherClient.jsp" ).forward( request, response );
		}else{
			System.out.println("PAGE NON TROUVER");
		}*/
	}	
	
}
