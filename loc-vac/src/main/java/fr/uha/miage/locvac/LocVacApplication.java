package fr.uha.miage.locvac;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import aj.org.objectweb.asm.Type;
import fr.uha.miage.locvac.model.Chambre;
import fr.uha.miage.locvac.model.DateDispo;
import fr.uha.miage.locvac.model.Equipement;
import fr.uha.miage.locvac.model.Location;
import fr.uha.miage.locvac.model.Reserver;
import fr.uha.miage.locvac.model.TypeLit;
import fr.uha.miage.locvac.model.TypePropriete;
import fr.uha.miage.locvac.model.TypeSdb;
import fr.uha.miage.locvac.model.User;
import fr.uha.miage.locvac.repository.ChambreRepository;
import fr.uha.miage.locvac.repository.DateDispoRepository;
import fr.uha.miage.locvac.repository.EquipementRepository;
import fr.uha.miage.locvac.repository.LocationRepository;
import fr.uha.miage.locvac.repository.ReserverRepository;
import fr.uha.miage.locvac.repository.TypeLitRepository;
import fr.uha.miage.locvac.repository.TypeProprieteRepository;
import fr.uha.miage.locvac.repository.TypeSdbRepository;
import fr.uha.miage.locvac.repository.UserRepository;

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
	
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ChambreRepository chambreRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReserverRepository reserverRepository;
	
	@Autowired
	private DateDispoRepository dateDispoRepository;
	
	
	
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
		
		
		
		
		/*
		 * 
		 * ajout d'une location
		 * 
		 */
		
		//creation d'une chambre assossié a la location
		Chambre chambreAuberge = new Chambre();
		int idchambreAuberge = chambreAuberge.getIdChambre();
		
		// ajout d'une liste de lit disponible dans la location
		List<TypeLit> lits = new ArrayList<>();
		lits.add(litsuperpose);
		lits.add(litsimple);
		
		chambreAuberge.setTypeLits(lits);
			
		chambreRepository.save(chambreAuberge);
		
		
		// création de location dans le repository
		Location belleAuberge = new Location();
		belleAuberge.setNomLocation("A la belle auberge");
		belleAuberge.setCapaciteLocation(3);
		belleAuberge.setVilleLocation("Mulhouse");
		belleAuberge.setPaysLocation("France");
		belleAuberge.setAdresseLocation("Rue de la tour");
		belleAuberge.setCodePostalLocation(68100);
		belleAuberge.setPrixLocation(12.5);
		belleAuberge.setTypePropriete(hotel);
		belleAuberge.setSuperficie(50);
		belleAuberge.setUrl("http://media-cdn.tripadvisor.com/media/photo-o/04/07/fa/42/la-belle-victorienne.jpg");
		
		//ajout de la chambre a cette location
		List<Chambre> chambres = new ArrayList<>();
		chambres.add(chambreAuberge);
		belleAuberge.setChambres(chambres);
		
		//ajout d'equipements à cette location
		List<Equipement> equipements = new ArrayList<>();
		equipements.add(wifi);
		equipements.add(tv);
		belleAuberge.setEquipements(equipements);
		
		//ajout de type de sdb à cette location
		List<TypeSdb> typeSdbs = new ArrayList<>();
		typeSdbs.add(baignoire);
		typeSdbs.add(jacuzzi);
		belleAuberge.setTypeSdbs(typeSdbs);
		
		
		
		
		/*
		 * 
		 * Création de date dispo pour la belle auberge
		 * 
		 */
		
		//sauvegarde
		locationRepository.save(belleAuberge);
				
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		df1.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		Date dateAubergeD1 = df1.parse("01/12/2015");
		Date dateAubergeF1 = df1.parse("31/12/2015");
		Date dateAubergeD2 = df1.parse("01/01/2016");
		Date dateAubergeF2 = df1.parse("31/12/2016");
		
		DateDispo dateAuberge1 = new DateDispo();
		dateAuberge1.setDateDebut(dateAubergeD1);
		dateAuberge1.setDateFin(dateAubergeF1);
		dateAuberge1.setLocationDateDispo(belleAuberge);

		
		
		DateDispo dateAuberge2 = new DateDispo();
		dateAuberge2.setDateDebut(dateAubergeD2);
		dateAuberge2.setDateFin(dateAubergeF2);
		dateAuberge2.setLocationDateDispo(belleAuberge);
		
		List<DateDispo> listeDateDispoAuberge = new ArrayList<>();
		listeDateDispoAuberge.add(dateAuberge1);
		listeDateDispoAuberge.add(dateAuberge2);

		belleAuberge.setDateDispo(listeDateDispoAuberge);
		dateDispoRepository.save(dateAuberge1);
		dateDispoRepository.save(dateAuberge2);

		
		
		
		
		/*
		 * 
		 * Ajout d'une location
		 * 
		 */
		
		
		// création de location dans le repository
		Location laCabanedeReve = new Location();
		laCabanedeReve.setNomLocation("La cabane de reve");
		laCabanedeReve.setCapaciteLocation(4);
		laCabanedeReve.setVilleLocation("Lille");
		laCabanedeReve.setPaysLocation("France");
		laCabanedeReve.setAdresseLocation("Rue de Lesquin");
		laCabanedeReve.setCodePostalLocation(59000);
		laCabanedeReve.setPrixLocation(17.5);
		laCabanedeReve.setTypePropriete(appartement);
		laCabanedeReve.setSuperficie(15);
		laCabanedeReve.setUrl("http://annie.blogs.marieclaireidees.com/media/01/00/753321507.jpeg");
		
		
	
		
		
		
		/*
		 * 
		 * Création de date dispo pour la cabane de reve
		 * 
		 */
		
		locationRepository.save(laCabanedeReve);

		DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
		df2.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		

		Date dateCabaneD1 = df2.parse("12/12/2015");
		Date dateCabaneF1 = df2.parse("17/12/2015");
		Date dateCabaneD2 = df2.parse("01/01/2016");
		Date dateCabaneF2 = df2.parse("06/01/2016");
		
		DateDispo dateCabane1 = new DateDispo();
		dateCabane1.setDateDebut(dateCabaneD1);
		dateCabane1.setDateFin(dateCabaneF1);
		
		DateDispo dateCabane2 = new DateDispo();
		dateCabane2.setDateDebut(dateCabaneD2);
		dateCabane2.setDateFin(dateCabaneF2);
		
		List<DateDispo> listeDateDispoCabane = new ArrayList<>();
		listeDateDispoCabane.add(dateCabane1);
		listeDateDispoCabane.add(dateCabane2);
		
		laCabanedeReve.setDateDispo(listeDateDispoCabane);
		
		dateDispoRepository.save(dateCabane1);
		dateDispoRepository.save(dateCabane2);
		

		
		/*
		 * 
		 * ajout d'un utilisateur
		 * 
		 */
		
		
		
		
		// création de user dans le repository
		User user1 = new User();
		user1.setNomUser("Sy");
		user1.setPrenomUser("Sebastien");
		user1.setEmailUser("sebastien.sy@gnet.com");
		
		// hashage du mot de passe
    	String hashed1 = BCrypt.hashpw("azzz", BCrypt.gensalt(12));
		user1.setMdpUser(hashed1);
		user1.setTelUser("0794032345");

		
		//sauvegarde
		userRepository.save(user1);
		
		
		/*
		 * 
		 * ajout d'un utilisateur
		 * 
		 */
			
		
		
		// création de user dans le repository
		User user2 = new User();
		user2.setNomUser("Wazan");
		user2.setPrenomUser("Julien");
		user2.setEmailUser("julienwazn@gmail.com");
		
		// hashage du mot de passe
    	String hashed2 = BCrypt.hashpw("azzz", BCrypt.gensalt(12));
		user2.setMdpUser(hashed2);
		user2.setTelUser("0642344345");

		
		//sauvegarde
		userRepository.save(user2);
		
		
		
		
		/*
		 * 
		 * ajout d'une reservation
		 * 
		 */
		
		
		//creation d'une date
		Date dateDebutReserv = new Date();
		Date dateFinReserv= new Date();
		
		//creation de l'objet reservation
		Reserver reservation1 = new Reserver();
		reservation1.setDateDebutReserver(dateDebutReserv);
		reservation1.setDateFinReserver(dateFinReserv);
		reservation1.setLocationReserver(laCabanedeReve);
		reservation1.setPrixReserver(124);
		reservation1.setUserReserver(user1);
		
		//ajout de la reservation a l'utilisateur
		List<Reserver> reservationsUser1 = new ArrayList<>();
		reservationsUser1.add(reservation1);		
		user2.setReservers(reservationsUser1);
		
		
		//sauvegarde
		reserverRepository.save(reservation1);
		
		
		
		/*
		 * 
		 * ajout d'une seconde reservation
		 * 
		 */
		
		
		//creation de l'objet reservation
		Reserver reservation2 = new Reserver();
		reservation2.setDateDebutReserver(dateDebutReserv);
		reservation2.setDateFinReserver(dateFinReserv);
		reservation2.setLocationReserver(belleAuberge);
		reservation2.setPrixReserver(144);
		reservation2.setUserReserver(user2);
		
		
		
		//ajout de la reservation a l'utilisateur
		List<Reserver> reservations = new ArrayList<>();
		reservations.add(reservation2);		
		user2.setReservers(reservations);
		
		
		
		
		//sauvegarde
		reserverRepository.save(reservation2);
		
		
		/*
		 * 
		 * création de l'admin
		 * 
		 */
		User admin = new User();
		admin.setEmailUser("admin@admin.com");
		String hashed3 = BCrypt.hashpw("admin", BCrypt.gensalt(12));
		admin.setMdpUser(hashed3);
		
		userRepository.save(admin);
		
		
		
		
	}
	
}
