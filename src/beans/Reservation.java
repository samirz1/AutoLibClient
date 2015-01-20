package beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@XmlRootElement
public class Reservation implements Serializable {

	// *******************************************
	// MEMBRES
	// *******************************************
	private static final long serialVersionUID = 1L;
	private Vehicule vehicule;
	private Client client;
	private DateTime dateReservation;
	private DateTime dateEcheance;

	// *******************************************
	// CONSTRUCTEUR
	// *******************************************
	public Reservation() {
		super();
		this.setClient(new Client());
		this.setVehicule(new Vehicule());
	}

	// *******************************************
	// GETTERS & SETTERS
	// *******************************************
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public DateTime getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(DateTime dateReservation) {
		this.dateReservation = dateReservation;
	}

	public DateTime getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(DateTime dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	
	/**
	 * Jour Mois Année de réservation
	 * @return
	 */
	public int getJourR(){
		return this.getDateReservation().getDayOfMonth();
		
	}
	
	public int getMoisR(){
		return this.getDateReservation().getMonthOfYear();
	}
	
	public int getYearR(){
		return this.getDateReservation().getYear();
	}

	/**
	 * Jour Mois Année de échéance
	 * @return
	 */
	public int getJourE(){
		return this.getDateEcheance().getDayOfMonth();
		
	}
	
	public int getMoisE(){
		return this.getDateEcheance().getMonthOfYear();
	}
	
	public int getYearE(){
		return this.getDateEcheance().getYear();
	}

	public String getHourR(){
		String r = this.getDateReservation().getHourOfDay() +"H:"+this.getDateReservation().getMinuteOfHour();
		return r;	}
	
	public String getHourE(){
			String r = this.getDateEcheance().getHourOfDay() +"H:"+this.getDateEcheance().getMinuteOfHour();
			return r;
	}
}
