# loc-vac

## Synopsis

Notre projet consiste en une solution de r�servations de logements.  Il a �t� r�alis� par  S�bastien SY et Julien WAZAN.
Nous avons cr�� cette application dans le cadre de notre projet universitaire. 

## Installation

## C�t� utilisateur

*******************************************************************************************************************************
*******************************************************************************************************************************
*****************************************************************************************************************************
Il faut installer ce projet sous eclipse: 
File > Import 

Ensuite s�lectionnez le dossier Git > Projects from Git puis appuyez sur Next

Ensuite appuyez sur Clone URI puis appuyez sur Next

Collez le lien du projet : https://github.com/sebastiensy/loc-vac

Veuillez remplir vos identifiants puis appuyez sur Next

Selectionnez la branche "Master" puis appuyez sur Next

Enfin Appuyez sur Finish 


Pour lancer l'application, faites un clic droit sur LocVacApplication.java et appuyez sur Run as Java Application

Ouvrez un navigateur Web et Allez sur l'adresse suivante: http://localhost:8080/index

Vous pouvez vous inscrire � l'aide du bouton en haut � gauche: Inscription

Remplissez les informations personnelles (Nom, Pr�nom, Email, mot de passe et T�l�phone)

Une fois inscrit, vous �tes connect�s automatiquement: Vous pouvez r�server

Afin de r�server un logement, veuillez appuyer sur "Location"

Des logements sont propos�s, vous pouvez selectionner les logements qui vous interessent en cliquant sur l'image

Le prix par journ�e, l'adresse, la description, les �quipements, le nombre de salle de bain, le type de salle de bain,  ainsi que les p�riodes disponibilit�s du logements

Vous pouvez r�server le logement � l'aide des deux champs, soit en remplissant de vous m�me ou bien � l'aide du calendrier.

Veuillez s�lectionnez des dates disponibles.

Appuyez sur R�server

Vous avez un r�capitulatif de votre r�servation

*******************************************************************************************************************************
*******************************************************************************************************************************
*******************************************************************************************************************************

## Cot� admin

Se connecter avec 
login : admin@admin.com
mot de passe: admin

***********************Pour cr�er une location************************************************ 
Appuyez sur location, cr�er une location
Entrez les informations le nom du logement, la capacit� en personnes, la superficie, le pays, la ville, 
l'adresse, le code postal, 
s�lectionnez le type de propri�t�,
Entrez la description 
Cochez les �quipements, le type de salle de bain
Cliquez enfin sur "Passez � l �tape suivante"
****************************************************************************************************************************
Entrez la p�riode de disponibilit� avec une date de d�but pour le premier champ et une date de fin pour le deuxi�me champ
Les dates doivent �tre sous le format: JJ/MM/AAAA
Appuyez sur "Ajouter cette p�riode de disponibilit�"
Les p�riodes de disponibilit� s'affichent � gauche de votre �cran, il y a un bouton supprimer pour supprimer une p�riode si vous le d�sirez
Apr�s avoir ajouter le(s) p�riode(s) de disponibilit� veuillez cliquer  sur "Passez � la cr�ation de chambre"" pour passer � l'�tape suivante
*****************************************************************************************************************************
Pour cr�er une chambre, veuillez s�lectionner  le type de lit de la chambre et cliquer sur "Assossier un nouveau type de lit".
Une fois une chambre cr��, l'id de la chambre s'affiche � gauche dans un tableau
Apr�s avoir cr�� le nombre de chambre que vous vouliez, vous pouvez retourner � l'accueil en cliquant sur le lien "Retourner � l'accueil"
*************************************************
*************************************************
*************************************************

***********************Pour visualiser les locations****************************************************************
Appuyer sur "Location" � droite et cliquez sur Afficher les locations
Les locations sont affich�es

***********************Pour supprimer les locations*******************************************************************
Appuyer sur "Location" � droite et cliquez sur Afficher les locations
Les locations sont affich�es, vous pouvez supprimer une location en cliquant sur le bouton "Supprimer" de la Location que vous voulez supprimer


***********************Pour afficher toutes les r�servations effectu�es*********************************************************
Appuyer sur "R�servation" � gauche  puis "Afficher les r�servations"


***********************Pour afficher tous les utilisateurs*********************************************************
Appuyer sur "Utilisateur" � gauche  puis "Afficher tous les utilisateurs"

***********************Pour ajouter et supprimer des �quipements*********************************************************
Appuyer sur "Equipements" � gauche : Tous les �quipements s'affichent � droite, vous pouvez les supprimer et en ajouter des nouveaux

***********************Pour ajouter et supprimer des types de propri�t�s *********************************************************
Appuyer sur "Type Propri�t�" � gauche : Tous les types de propri�t� s'affichent � droite, vous pouvez les supprimer et en ajouter des nouveaux

***********************Pour ajouter et supprimer des types de lit *********************************************************
Appuyer sur "Type Lit" � gauche : Tous les types de lit s'affichent � droite, vous pouvez les supprimer et en ajouter des nouveaux

***********************Pour ajouter et supprimer des types de salle de bain *********************************************************
Appuyer sur "Type Salle De Bain" � gauche : Tous les types de salle de bain s'affichent � droite, vous pouvez les supprimer et en ajouter des nouveaux







## Technologie

JAVA JEE
ThymeLeaf
Spring Boot

## Tests

Tester l'application avec les identifiants suivant: 

Utilisateur
Login: sebastien.sy@gnet.com
mdp: azzz

admin
login: admin@admin.com
mdp: admin




## Auteurs

Sebastien SY
Julien WAZAN

