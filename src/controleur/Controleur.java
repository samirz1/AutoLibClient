package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MyBoolean;

import com.sun.jersey.api.client.Client;


@WebServlet("/controleur")
public class Controleur extends HttpServlet{

	private static final long serialVersionUID = 1L;
		
	
	public Controleur() {
        super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");// on récupére le type d'action
		if (action != null && action.equals("connexionClient")) {
			String nomClient = request.getParameter("nomClient");
			MyBoolean success = Client.create().resource("http://localhost:8080/AutoLibWebService/serviceClient/connexionClient/" + nomClient).get(MyBoolean.class);
			if(success.isB()){
				System.out.println("Vrai");
			}
			else {
			System.out.println("False");
			}
			request.setAttribute("message", success.isB());
		}else{
			System.out.println("PAGE NON TROUVEE");
		}
	}	
	
}
