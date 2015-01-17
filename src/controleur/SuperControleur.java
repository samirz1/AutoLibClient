package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

abstract public class SuperControleur extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// version de l'application
	protected static final String VERSION = "1.0";
	
	// url du webservice
	protected static String WS = "http://localhost:8080/AutoLibWebService/";
	
	protected HttpSession session = null;
	protected String action = null;
	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;
	protected String redirection = null;
	
	public SuperControleur() {
        super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// VARIABLES
		// récupérer la session courante et l'initialiser au besoin
		this.session = Session.init(request.getSession());
		this.action = request.getParameter("action");
		this.request = request;
		this.response = response;
		String view = null;
		
		// EXECUTION
		try {
			// appel de la méthode principale
			view = execution();
			
		} catch(Exception e) {
			// récupération des erreurs
			view = "/erreur.jsp";
			this.request.setAttribute("erreur", e.getMessage());
			// annuler l'effet d'une éventuelle redirection
			this.redirection = null;
		}
		
		// SORTIE 
		if(this.redirection != null) {
			// effectuer une redirection si elle a été demandée
			this.response.sendRedirect(redirection);
			
		} else if(view != null) {
			
			// paramètres envoyés par défaut
			this.request.setAttribute("app_version", VERSION);
			
			this.request.setAttribute("sess_connecte", Session.isConnected(this.session));
			this.request.setAttribute("sess_type", Session.isAdmin(this.session) ? "admin" : "client");
			this.request.setAttribute("sess_iduser", Session.getIdUser(this.session));
			
			// afficher une vue si elle est demandée
			this.getServletContext().getRequestDispatcher(view).forward(this.request, this.response);
		}
	}
	
	/**
	 * Code principal de la servlet
	 * @return String url de la vie à afficher ou null
	 * @throws Exception
	 */
	protected abstract String execution() throws Exception;
	
	/**
	 * Définir l'url pour une redirection à la fin de l'execution
	 * @param url
	 */
	protected void setRedirection(String url) {
		this.redirection = url;
	}
}
