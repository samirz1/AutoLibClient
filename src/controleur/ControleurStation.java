package controleur;

import java.io.IOException;
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
