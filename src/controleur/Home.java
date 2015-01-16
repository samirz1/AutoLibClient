package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String WS = "http://localhost:8080/AutoLibWebService/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupérer la session courante et l'initialiser au besoin
		HttpSession session = Session.init(request.getSession());
		
		String action = request.getParameter("action");
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
					
				} else {
					// recherche d'un client
					// TODO appel du WS de login du client
					MyBoolean resultat = new MyBoolean(true);
					if(resultat.isB()) {
						// TODO appel du WS de recherche client
						Client client = new Client();
						client.setIdClient(1);
						Session.loginClient(session, client.getIdClient()); // OK !
					} else {
						request.setAttribute("message", "Client introuvable."); // NON
					}
				}
			}
			
		}
		
		String page = "";
		
		if(Session.isConnected(session)) {
			request.setAttribute("connecte", true);
			request.setAttribute("message", "Bonjour " + (Session.isAdmin(session) ? "administrateur" : "client"));
			page = "/home.jsp";
		} else {
			request.setAttribute("connecte", false);
			page = "/login.jsp";
		}
		
		this.getServletContext().getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

}
