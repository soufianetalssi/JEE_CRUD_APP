package Tp5;

import java.util.Date;

public class Contact {
	private String Nom,Prenom,ville;
	private int Code;
	private Date DN;

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String email) {
		ville = email;
	}

	public Date getDn() {
		return DN;
	}

	public void setDn(Date tel) {
		DN = tel;
	}

	public int getCode() {
		return Code;
	}

	public void setCode(int civ) {
		Code = civ;
	}
}
