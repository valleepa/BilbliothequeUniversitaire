package modele;

public class Retard {
	private String titre;
	private String date_emp;
	private String nom;
	private String prenom;
	private String email;
	
	public Retard(String titre,String date_emp,String nom, String prenom,String email) {
		this.email = email;
		this.date_emp = date_emp;
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDate_emp() {
		return date_emp;
	}

	public void setDate_emp(String date_emp) {
		this.date_emp = date_emp;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
