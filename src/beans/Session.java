package beans;

import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

/**
 * Classe utilisée pour les clés des objets 
 * stockés en session.
 * Utiliser cette classe pour manipuler l'objet de session.
 *
 */
public class Session {

	protected static String CONNECTE = "connecte";
	protected static String IDUSER = "iduser";
	protected static String TYPEUSER = "typeuser";
	protected static String INIT = "initialized";
	public static enum Utilisateur {
		NONE,
		CLIENT,
		ADMIN
	};
	protected static String CLIENT = "client";
	
	/**
	 * Initialiser une session si elle est vide.
	 * @param session
	 * @return
	 */
	public static HttpSession init(HttpSession session) {
		if(!isInit(session)) {
			session.setAttribute(CONNECTE, false);
			session.setAttribute(IDUSER, 0);
			session.setAttribute(TYPEUSER, Utilisateur.NONE);
			session.setAttribute(INIT, true);
			session.setAttribute(CLIENT, new Client());
		}
		return session;
	}
	
	/**
	 * Savoir si la session a été initialisée
	 * @param session
	 * @return
	 */
	public static boolean isInit(HttpSession session) {
		return (session.getAttribute(INIT) != null);
	}
	
	/**
	 * Connecter un utilisateur à la session
	 * @param session
	 * @param user
	 * @param type
	 * @return
	 */
	protected static HttpSession login(HttpSession session, int user, Utilisateur type) {
		session.setAttribute(CONNECTE, true);
		session.setAttribute(IDUSER, user);
		session.setAttribute(TYPEUSER, type);
		if(TYPEUSER.equals(Utilisateur.ADMIN)) {
			Client admin = new Client();
			admin.setLogin("admin");
			admin.setPrenom("Administrateur");
			session.setAttribute(CLIENT, admin);
		}
		
		return session;
	}
	
	/**
	 * Connecter un utilisateur client à la session
	 * @param session
	 * @param user
	 * @return
	 */
	public static HttpSession loginClient(HttpSession session, int user) {
		return login(session, user, Utilisateur.CLIENT);
	}
	
	/**
	 * Connecter un utilisateur client à la session
	 * @param session
	 * @param user
	 * @return
	 */
	public static HttpSession loginAdmin(HttpSession session, int user) {
		return login(session, user, Utilisateur.ADMIN);
	}
	
	/**
	 * Déconnecter de la session
	 * @param session
	 * @return
	 */
	public static HttpSession logout(HttpSession session) {
		session.setAttribute(CONNECTE, false);
		session.setAttribute(IDUSER, 0);
		session.setAttribute(TYPEUSER, Utilisateur.NONE);
		session.setAttribute(CLIENT, new Client());
		
		return session;
	}
	
	/**
	 * Savoir si l'utilisateur est connecté
	 * @param session
	 * @return
	 */
	public static boolean isConnected(HttpSession session) {
		return (boolean) session.getAttribute(CONNECTE);
	}
	
	/**
	 * Connaitre l'id de l'utilisateur
	 * @param session
	 * @return
	 */
	public static int getIdUser(HttpSession session) {
		return (int) session.getAttribute(IDUSER);
	}
	
	/**
	 * Connaitre le type d'utilisateur connecté
	 * @param session
	 * @return
	 */
	protected static Utilisateur getTypeUtilisateur(HttpSession session) {
		return (Utilisateur) session.getAttribute(TYPEUSER);
	}
	
	/**
	 * Savoir si l'utilisateur est un client
	 * @param session
	 * @return
	 */
	public static boolean isClient(HttpSession session) {
		return (getTypeUtilisateur(session) == Utilisateur.CLIENT);
	}
	
	/**
	 * Savoir si l'utilisateur est un client
	 * @param session
	 * @return
	 */
	public static boolean isAdmin(HttpSession session) {
		return (getTypeUtilisateur(session) == Utilisateur.ADMIN);
	}
	
	/**
	 * Stocker les informations du client dans la session
	 * @param session
	 * @param client
	 * @return
	 */
	public static HttpSession setClient(HttpSession session, Client client) {
		session.setAttribute(CLIENT, client);
		return session;
	}
	
	/**
	 * Récupérer les informations du client de la session
	 * @param session
	 * @return
	 */
	public static Client getClient(HttpSession session) {
		return (Client) session.getAttribute(CLIENT);
	}
}
