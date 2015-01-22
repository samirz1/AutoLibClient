package controleur;

import java.net.URLEncoder;
import java.security.URIParameter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.runtime.URIUtils;

import com.sun.jersey.api.client.Client;

import beans.*;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends SuperControleur {
	private static final long serialVersionUID = 1L;

	public Home() {
        super();
    }

	@Override
	protected String execution() throws Exception {

		if(action != null) {
			
			if(action.compareToIgnoreCase("logout") == 0) {
				// déconnexion
				Session.logout(session);
				request.setAttribute("message", "Déconnexion effectuée.");
			
			} else if(action.compareToIgnoreCase("login") == 0) {
				// connexion
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				
				if(login == null || login.length() == 0) {
					/// erreur de connexion
					request.setAttribute("message", "Connexion refusée sans login."); // NON
					
				} else if(login.compareToIgnoreCase("admin") == 0) {
					// connexion en tant qu'admin
					Session.loginAdmin(session, 1); // OK !
					request.setAttribute("autoredirect", true);
					
				} else {
					// recherche d'un client
					
					String urlLogin = URLEncoder.encode(login,"ISO-8859-1").replace("+", "%20");
					String urlPwd = URLEncoder.encode(password,"ISO-8859-1").replace("+", "%20");
					MyBoolean resultat = Client.create().resource(WS + "serviceClient/connexionClient/" + urlLogin + "/" + urlPwd + "/").get(MyBoolean.class);
					if(resultat.isB()) {
						
						beans.Client client = Client.create().resource(WS + "serviceClient/rechercher/login/" + urlLogin + "/").get(beans.Client.class);
						client.setIdClient(1);
						Session.loginClient(session, client.getIdClient()); // OK !
						Session.setClient(session, client);
						System.out.println("Login connecté : " + client.getLogin());
						request.setAttribute("autoredirect", true);
					} else {
						request.setAttribute("message", "Client introuvable."); // NON
					}
				}
			}
			
		}
		
		String page = "";
		
		if(Session.isConnected(session)) {
			request.setAttribute("message", "Vous êtes connecté en tant " + (Session.isAdmin(session) ? "qu'administrateur" : "que client") + " à cette application.");
			page = "/home.jsp";
		} else {
			page = "/login.jsp";
		}
		
		return page;
	}
}
