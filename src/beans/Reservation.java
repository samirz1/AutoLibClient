package beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reservation implements Serializable {

	// *******************************************
	// MEMBRES
	// *******************************************
	private static final long serialVersionUID = 1L;
	private Vehicule vehicule;
	private Client client;
	private Date dateReservation;
	private Date dateEcheance;
	
	private Calendar calendarReservation;
	private Calendar calendarEcheance;

	// *******************************************
	// CONSTRUCTEUR
	// *******************************************
	public Reservation() {
		super();
		this.setClient(new Client());
		this.setVehicule(new Vehicule());
		this.calendarReservation = GregorianCalendar.getInstance();
		this.calendarEcheance = GregorianCalendar.getInstance();
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

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
		this.calendarReservation.setTime(this.dateReservation);
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
		this.calendarEcheance.setTime(this.dateEcheance);
	}
	
	/**
	 * Jour de réservation
	 * @return
	 */
	public int getJourR(){
		return this.calendarReservation.get(Calendar.DAY_OF_MONTH);
		
	}
	
	/**
	 * Mois de réservation
	 * @return
	 */
	public int getMoisR(){
		return this.calendarReservation.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Année de réservation
	 * @return
	 */
	public int getAnneeR(){
		return this.calendarReservation.get(Calendar.YEAR);
	}
	
	/**
	 * Heure de réservation
	 * @return
	 */
	public String getHeureR(){
		return this.calendarReservation.get(Calendar.HOUR_OF_DAY)
				+ ":" + this.calendarReservation.get(Calendar.MINUTE);
	}

	/**
	 * Jour d'échéance
	 * @return
	 */
	public int getJourE(){
		return this.calendarEcheance.get(Calendar.DAY_OF_MONTH);
		
	}
	
	/**
	 * Mois d'échéance
	 * @return
	 */
	public int getMoisE(){
		return this.calendarEcheance.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Année d'échéance
	 * @return
	 */
	public int getAnneeE(){
		return this.calendarEcheance.get(Calendar.YEAR);
	}

	/**
	 * Heure d'échéance
	 * @return
	 */
	public String getHeureE(){
		return this.calendarEcheance.get(Calendar.HOUR_OF_DAY)
				+ ":" + this.calendarEcheance.get(Calendar.MINUTE);
	}
	
	/**
	 * Date de réservation au format français des dates
	 * @return
	 */
	public String getDateReservationString() {
		return this.getJourR() + "/" + this.getMoisR() + "/" + this.getAnneeR()
				+ " " + this.getHeureR();
	}
	
	/**
	 * Date de réservation au format français des dates
	 * @return
	 */
	public String getDateEcheanceString() {
		return this.getJourE() + "/" + this.getMoisE() + "/" + this.getAnneeE()
				+ " " + this.getHeureE();
	}
}
