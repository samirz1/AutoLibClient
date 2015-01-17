package controleur;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

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
				if(login == null || login.length() == 0) {
					/// erreur de connexion
					request.setAttribute("message", "Connexion refusée sans login."); // NON
					
				} else if(login.compareToIgnoreCase("admin") == 0) {
					// connexion en tant qu'admin
					Session.loginAdmin(session, 1); // OK !
					request.setAttribute("autoredirect", true);
					
				} else {
					// recherche d'un client
					// TODO appel du WS de login du client
					MyBoolean resultat = new MyBoolean(true);
					if(resultat.isB()) {
						// TODO appel du WS de recherche client
						Client client = new Client();
						client.setIdClient(1);
						Session.loginClient(session, client.getIdClient()); // OK !
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
