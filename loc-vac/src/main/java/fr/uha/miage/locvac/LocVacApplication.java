package fr.uha.miage.locvac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import aj.org.objectweb.asm.Type;
import fr.uha.miage.locvac.model.Equipement;
import fr.uha.miage.locvac.model.TypeLit;
import fr.uha.miage.locvac.model.TypePropriete;
import fr.uha.miage.locvac.model.TypeSdb;
import fr.uha.miage.locvac.repository.EquipementRepository;
import fr.uha.miage.locvac.repository.TypeLitRepository;
import fr.uha.miage.locvac.repository.TypeProprieteRepository;
import fr.uha.miage.locvac.repository.TypeSdbRepository;

@SpringBootApplication
public class LocVacApplication implements CommandLineRunner {
	
	@Autowired
	private EquipementRepository equipementRepository;
	
	@Autowired
	private TypeProprieteRepository typeProprieteRepository;
	
	@Autowired
	private TypeSdbRepository typeSdbRepository;
	
	@Autowired
	private TypeLitRepository typeLitRepository;
	
	public static void main(String[] args) {
        SpringApplication.run(LocVacApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {

		// création d'équipement dans le repository
		Equipement tv = new Equipement();
		tv.setNomEquipement("TV");
		
		Equipement internet = new Equipement();
		internet.setNomEquipement("Internet");
		
		Equipement wifi = new Equipement();
		wifi.setNomEquipement("Wifi");
		
		equipementRepository.save(tv);
		equipementRepository.save(internet);
		equipementRepository.save(wifi);
		
		
		
		// création de type de propriete dans le repository
		TypePropriete maison = new TypePropriete();
		maison.setNomTypePropriete("Maison");
		
		TypePropriete appartement = new TypePropriete();
		appartement.setNomTypePropriete("Appartement");
		
		TypePropriete hotel = new TypePropriete();
		hotel.setNomTypePropriete("Hotel");
		
		typeProprieteRepository.save(maison);
		typeProprieteRepository.save(appartement);
		typeProprieteRepository.save(hotel);
		
		
		// création de type de salle de bain dans le repository
		TypeSdb douche = new TypeSdb();
		douche.setNomTsdb("Douche");
		
		TypeSdb baignoire = new TypeSdb();
		baignoire.setNomTsdb("Baignoire");
		
		TypeSdb jacuzzi = new TypeSdb();
		jacuzzi.setNomTsdb("Jacuzzi");
		
		typeSdbRepository.save(douche);
		typeSdbRepository.save(baignoire);
		typeSdbRepository.save(jacuzzi);
		
		
		// création de type de lit dans le repository
		TypeLit litsimple = new TypeLit();
		litsimple.setNomLit("Lit simple");
		
		TypeLit litdouble = new TypeLit();
		litdouble.setNomLit("Lit double");
		
		TypeLit litsuperpose = new TypeLit();
		litsuperpose.setNomLit("Lit superposé");
		
		typeLitRepository.save(litsimple);
		typeLitRepository.save(litdouble);
		typeLitRepository.save(litsuperpose);
		
		
		
	}
	
}
