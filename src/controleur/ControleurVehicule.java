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
import beans.Vehicule;

@WebServlet("/controleurVehicule")
public class ControleurVehicule extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private String idVehicule;

	public ControleurVehicule() {
        super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");// on récupére le type d'action
		if (action != null && action.equals("creation")) {
			Integer typeVehicule = Integer.parseInt(request.getParameter("typeVehicule"));
			Integer station = Integer.parseInt(request.getParameter("station"));
			Integer idBorne = Integer.parseInt(request.getParameter("idBorne"));
			if(typeVehicule!=null && station!=null && idBorne!=null ){
				MyBoolean resultat = Client.create().resource("http://localhost:8080/"
						+ "AutoLibWebService/serviceVehicule/creation/" + typeVehicule + "/" + station + "/" + idBorne).get(MyBoolean.class);
				if(resultat.isB()) request.setAttribute("message", "Creation du véhicule effectué");
				else request.setAttribute("message", "Echec de la creation du véhicule");
			}			
			this.getServletContext().getRequestDispatcher( "/creationVehicule.jsp" ).forward( request, response );
		}else if(action != null && action.equals("supprimer")){
			String idVehicule = request.getParameter("selectedVehicule");
			if(idVehicule!=null && !idVehicule.isEmpty()){
				MyBoolean resultat = Client.create().resource("http://localhost:8080/"
						+ "AutoLibWebService/serviceVehicule/supprimer/" + idVehicule).get(MyBoolean.class);
				if(resultat.isB()) request.setAttribute("message", "Supression du véhicule effectué");
				else request.setAttribute("message", "Echec de la suppression du véhicule");
			}
			List<beans.Vehicule> listeVehicule = Client.create().resource("http://localhost:8080/AutoLibWebService/serviceVehicule/toutRechercher").get(new GenericType<List<beans.Vehicule>>(){});
			request.setAttribute("listeVehicule", listeVehicule);	
			this.getServletContext().getRequestDispatcher( "/supprimerVehicule.jsp" ).forward( request, response );
		}else if(action != null && action.equals("rechercher1")){
			String idVehicule = request.getParameter("selectedVehicule");
			this.idVehicule = idVehicule;
			if(idVehicule!=null && !idVehicule.isEmpty()){
				beans.Vehicule resultat = Client.create().resource("http://localhost:8080/"
						+ "AutoLibWebService/serviceClient/rechercher/" + idVehicule).get(beans.Vehicule.class);
			}
			this.getServletContext().getRequestDispatcher( "/affichageVehicule.jsp" ).forward( request, response );
		}else if(action != null && action.equals("rechercher2")){
			String idBorne = request.getParameter("idBorne");
			if(idBorne!=null && !idBorne.isEmpty()){
				beans.Vehicule resultat = Client.create().resource("http://localhost:8080/"
						+ "AutoLibWebService/serviceClient/rechercherVehiculeBorne/" + idBorne).get(beans.Vehicule.class);
			}
			this.getServletContext().getRequestDispatcher( "/affichageVehicule.jsp" ).forward( request, response );
		}else if(action != null && action.equals("modifier")){
			String idVehicule = request.getParameter("idVehicule");
			String ancienIdBorne = request.getParameter("ancienIdBorne");
			String nouveauIdBorne = request.getParameter("nouveauIdBorne");
			String NouveauStation = request.getParameter("NouveauStation");
			String RFID = request.getParameter("RFID");
			String etatBatterie = request.getParameter("etatBatterie");
			String Disponibilite = request.getParameter("Disponibilite");
			String type_vehicule = request.getParameter("type_vehicule");
			MyBoolean resultat = Client.create().resource("http://localhost:8080/"
					+ "AutoLibWebService/serviceVehicule/modifier/" + idVehicule+"/"+ancienIdBorne+"/"+nouveauIdBorne+
					"/"+NouveauStation+"/"+RFID+"/"+etatBatterie+"/"+Disponibilite+"/"+type_vehicule).get(MyBoolean.class);
			if(resultat.isB()) {
				request.setAttribute("message", "Modification du véhicule effectué");
			}
			else {
				request.setAttribute("message", "Echec de la modification du véhicule");
			}
			List<beans.Vehicule> listeVehicules = Client.create().resource("http://localhost:8080/AutoLibWebService/serviceVehicule/toutRechercher").get(new GenericType<List<beans.Vehicule>>(){});
			request.setAttribute("listeVehicules", listeVehicules);	
			this.getServletContext().getRequestDispatcher( "/modifierVehicule.jsp" ).forward( request, response );
		}
		else if(action != null && action.equals("toutRechercher")){
			List<beans.Vehicule> listeVehicules = Client.create().resource("http://localhost:8080/AutoLibWebService/serviceVehicule/toutRechercher").get(new GenericType<List<beans.Vehicule>>(){});
			request.setAttribute("listeVehicules", listeVehicules);
			this.getServletContext().getRequestDispatcher( "/toutRechercherVehicule.jsp" ).forward( request, response );
		}else{
			System.out.println("PAGE NON TROUVEE");
		}
	}
}

