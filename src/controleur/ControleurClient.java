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

@WebServlet("/controleurClient")
public class ControleurClient extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private String idClient;

	public ControleurClient() {
        super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");// on récupére le type d'action
		if (action != null && action.equals("creation")) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String dateNaissance = request.getParameter("dateNaissance");
			String login = request.getParameter("login");
			String pwd = request.getParameter("pwd");
			//System.out.println("Creation : " + nom +  "  " + prenom + "  " + dateNaissance);
			if(nom!=null && !nom.isEmpty() && prenom!=null && !prenom.isEmpty() && dateNaissance!=null && !dateNaissance.isEmpty()){
				MyBoolean resultat = Client.create().resource("http://localhost:8080/"
						+ "AutoLibWebService/serviceClient/creation/" + nom + "/" + prenom + "/" + dateNaissance+ "/" + login+ "/" + pwd).get(MyBoolean.class);
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
			System.out.println("PAGE NON TROUVEE");
		}
	}	
	
}
