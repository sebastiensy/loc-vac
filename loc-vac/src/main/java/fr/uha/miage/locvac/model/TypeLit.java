package fr.uha.miage.locvac.model;
import fr.uha.miage.locvac.model.Chambre;

//import org.hibernate.mapping.Collection;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TypeLit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTypeLit;
	
	
	@Column(length=40)
	private String nomLit;

	public int getIdTypeLit() {
		return idTypeLit;
	}

	public void setIdTypeLit(int idTypeLit) {
		this.idTypeLit = idTypeLit;
	}

	public String getNomLit() {
		return nomLit;
	}

	public void setNomLit(String nomLit) {
		this.nomLit = nomLit;
	}
	
	@ManyToMany(mappedBy="typeLits")
	private Collection<Chambre> chambres;
	

}
