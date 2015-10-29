package fr.uha.miage.locvac.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	
	@Column(length=40)
	private String nomUser;
	
	@Column(length=40)
	private String prenomUser;
	
	@Column(length=100)
	private String emailUser;
	
	@Column(length=200)
	private String mdpUser;
	
	@Column(length=10)
	private String telUser;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getMdpUser() {
		return mdpUser;
	}
	public void setMdpUser(String mdpUser) {
		this.mdpUser = mdpUser;
	}
	public String getTelUser() {
		return telUser;
	}
	public void setTelUser(String telUser) {
		this.telUser = telUser;
	}
	
	
	//user
	@OneToMany(mappedBy="userReserver")
	private List<Reserver> reserver;

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nomUser=" + nomUser + ", prenomUser=" + prenomUser + ", emailUser="
				+ emailUser + ", mdpUser=" + mdpUser + ", telUser=" + telUser + ", reserver=" + reserver + "]";
	}
	public List<Reserver> getReserver() {
		return reserver;
	}
	public void setReserver(List<Reserver> reserver) {
		this.reserver = reserver;
	}
	
	
}
