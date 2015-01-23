package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Station implements Serializable {

	// *******************************************
	// MEMBRES
	// *******************************************
	private static final long serialVersionUID = 1L;
	private Integer idStation;
	private Double latitude;
	private Double longitude;
	private String adresse;
	private Integer numero;
	private String ville;
	private Integer codePostal;
	
	private List<Borne> bornes;

	// *******************************************
	// CONSTRUCTEUR
	// *******************************************
	public Station() {
		super();
		this.bornes = new ArrayList<Borne>();
	}

	// *******************************************
	// GETTERS & SETTERS
	// *******************************************
	public Integer getIdStation() {
		return idStation;
	}

	public void setIdStation(Integer idStation) {
		this.idStation = idStation;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
	
	public List<Borne> getBornes() {
		return bornes;
	}

	public void setBornes(List<Borne> bornes) {
		this.bornes = bornes;
	}

	public void addBorne(Borne b) {
		this.bornes.add(b);
	}
	
	public void removeBorne(int index) {
		this.bornes.remove(index);
	}
	
	public Borne getBorne(int index) {
		return this.bornes.get(index);
	}
	
	/**
	 * Nombre de bornes libres
	 * @return int
	 */
	public int nbLibres() {
		int libre = 0;
		for(Borne b : bornes) {
			libre += b.getEtatBorne();
		}
		return libre;
	}
	
	/**
	 * Nombre de bornes libres
	 * @return int
	 */
	public int nbOccupees() {
		int occupees = 0;
		for(Borne b : bornes) {
			occupees += (1 - b.getEtatBorne());
		}
		return occupees;
	}
	
	/**
	 * Nombre de véhicules disponibles
	 * @return int
	 */
	public int nbDisponibles() {
		return this.nbOccupees();
	}
	
	/**
	 * Nombre de bornes
	 * @return int
	 */
	public int nbBornes() {
		return bornes.size();
	}
	
	/**
	 * Texte sur la disponibilité des bornes
	 * @return
	 */
	public String texteEtat() {
		int libres = this.nbLibres();
		int disponibles = this.nbDisponibles();
		return "disponible : " + disponibles + " - places : " + libres;
	}
	
	/**
	 * Etat de la station
	 * 2 -> toutes les voitures dispo
	 * 1 -> voitures dispo et places libres
	 * 0 -> aucune voiture disponible
	 * @return
	 */
	public int getEtat() {
		int libres = this.nbLibres();
		int disponibles = this.nbDisponibles();
		if(disponibles > 0 && libres == 0) {
			return 2; // toutes les voitures dispo
		} else if(disponibles > 0 && libres > 0) {
			return 1; // voitures dispo et places libres
		} else {
			return 0; // aucune voiture disponible
		}
	}
}
