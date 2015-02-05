package beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client implements Serializable {

	// *******************************************
	// MEMBRES
	// *******************************************
	private static final long serialVersionUID = 1L;
	private Integer idClient;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String login;
	private String pwd;
	
	private Calendar calendar;

	// *******************************************
	// CONSTRUCTEUR
	// *******************************************
	public Client() {
		super();
		this.calendar = GregorianCalendar.getInstance();
	}

	// *******************************************
	// GETTERS & SETTERS
	// *******************************************
	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}
	
	public String getDateNaissanceString() {
		return getAnneeNaissance() + "-" + getMoisNaissance() + "-" + getJourNaissance();
	}
	
	public String getDateNaissanceAfficher() {
		return getJourNaissance() + "/" + getMoisNaissance() + "/" + getAnneeNaissance();
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
		this.calendar.setTime(dateNaissance);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * Jour de naissance
	 * @return
	 */
	public int getJourNaissance(){
		return this.calendar.get(Calendar.DAY_OF_MONTH);
		
	}
	
	/**
	 * Mois de naissance
	 * @return
	 */
	public int getMoisNaissance(){
		return this.calendar.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Année de naissance
	 * @return
	 */
	public int getAnneeNaissance(){
		return this.calendar.get(Calendar.YEAR);
	}
	
}
