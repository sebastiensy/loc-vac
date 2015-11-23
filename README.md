# loc-vac

## Synopsis

Notre projet consiste en une solution de réservations de logements.  Il a été réalisé par  Sébastien SY et Julien WAZAN.
Nous avons créé cette application dans le cadre de notre projet universitaire. 

## Installation

## Côté utilisateur

*******************************************************************************************************************************
*******************************************************************************************************************************
*****************************************************************************************************************************
Il faut installer ce projet sous eclipse: 
File > Import 

Ensuite sélectionnez le dossier Git > Projects from Git puis appuyez sur Next

Ensuite appuyez sur Clone URI puis appuyez sur Next

Collez le lien du projet : https://github.com/sebastiensy/loc-vac

Veuillez remplir vos identifiants puis appuyez sur Next

Selectionnez la branche "Master" puis appuyez sur Next

Enfin Appuyez sur Finish 


Pour lancer l'application, faites un clic droit sur LocVacApplication.java et appuyez sur Run as Java Application

Ouvrez un navigateur Web et Allez sur l'adresse suivante: http://localhost:8080/index

Vous pouvez vous inscrire à l'aide du bouton en haut à gauche: Inscription

Remplissez les informations personnelles (Nom, Prénom, Email, mot de passe et Téléphone)

Une fois inscrit, vous êtes connectés automatiquement: Vous pouvez réserver

Afin de réserver un logement, veuillez appuyer sur "Location"

Des logements sont proposés, vous pouvez selectionner les logements qui vous interessent en cliquant sur l'image

Le prix par journée, l'adresse, la description, les équipements, le nombre de salle de bain, le type de salle de bain,  ainsi que les périodes disponibilités du logements

Vous pouvez réserver le logement à l'aide des deux champs, soit en remplissant de vous même ou bien à l'aide du calendrier.

Veuillez sélectionnez des dates disponibles.

Appuyez sur Réserver

Vous avez un récapitulatif de votre réservation

*******************************************************************************************************************************
*******************************************************************************************************************************
*******************************************************************************************************************************

## Coté admin

Se connecter avec 
login : admin@admin.com
mot de passe: admin

***********************Pour créer une location************************************************ 
Appuyez sur location, créer une location
Entrez les informations le nom du logement, la capacité en personnes, la superficie, le pays, la ville, 
l'adresse, le code postal, 
sélectionnez le type de propriété,
Entrez la description 
Cochez les équipements, le type de salle de bain
Cliquez enfin sur "Passez à l étape suivante"
****************************************************************************************************************************
Entrez la période de disponibilité avec une date de début pour le premier champ et une date de fin pour le deuxième champ
Les dates doivent être sous le format: JJ/MM/AAAA
Appuyez sur "Ajouter cette période de disponibilité"
Les périodes de disponibilité s'affichent à gauche de votre écran, il y a un bouton supprimer pour supprimer une période si vous le désirez
Après avoir ajouter le(s) période(s) de disponibilité veuillez cliquer  sur "Passez à la création de chambre"" pour passer à l'étape suivante
*****************************************************************************************************************************
Pour créer une chambre, veuillez sélectionner  le type de lit de la chambre et cliquer sur "Assossier un nouveau type de lit".
Une fois une chambre créé, l'id de la chambre s'affiche à gauche dans un tableau
Après avoir créé le nombre de chambre que vous vouliez, vous pouvez retourner à l'accueil en cliquant sur le lien "Retourner à l'accueil"
*************************************************
*************************************************
*************************************************

***********************Pour visualiser les locations****************************************************************
Appuyer sur "Location" à droite et cliquez sur Afficher les locations
Les locations sont affichées

***********************Pour supprimer les locations*******************************************************************
Appuyer sur "Location" à droite et cliquez sur Afficher les locations
Les locations sont affichées, vous pouvez supprimer une location en cliquant sur le bouton "Supprimer" de la Location que vous voulez supprimer


***********************Pour afficher toutes les réservations effectuées*********************************************************
Appuyer sur "Réservation" à gauche  puis "Afficher les réservations"


***********************Pour afficher tous les utilisateurs*********************************************************
Appuyer sur "Utilisateur" à gauche  puis "Afficher tous les utilisateurs"

***********************Pour ajouter et supprimer des équipements*********************************************************
Appuyer sur "Equipements" à gauche : Tous les équipements s'affichent à droite, vous pouvez les supprimer et en ajouter des nouveaux

***********************Pour ajouter et supprimer des types de propriétés *********************************************************
Appuyer sur "Type Propriété" à gauche : Tous les types de propriété s'affichent à droite, vous pouvez les supprimer et en ajouter des nouveaux

***********************Pour ajouter et supprimer des types de lit *********************************************************
Appuyer sur "Type Lit" à gauche : Tous les types de lit s'affichent à droite, vous pouvez les supprimer et en ajouter des nouveaux

***********************Pour ajouter et supprimer des types de salle de bain *********************************************************
Appuyer sur "Type Salle De Bain" à gauche : Tous les types de salle de bain s'affichent à droite, vous pouvez les supprimer et en ajouter des nouveaux







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

