CookMe
======
Baptiste Bouchereau & Pierre-jean Leger

### Questions réalisées

La liste suivante détaille l'ensemble des éléments réalisés durant ce projet : 
* Créer une première page type « Splash screen» présentation le site 
* Créer une seconde page permettant de sélectionner l’activité choisie.
* Créer un template d’activité précisant l’entête et footer comme suit : 
* Créer une page d’inscription permettant l’ajout d’un nouvel utilisateur
* Gestion de la connexion d’un utilisateur
* Module de recherche 
* Présentation du résultat de recherche 


### Questions non-réalisées

La liste suivante détaille l'ensemble des éléments qui n'ont pas pu être réalisés par manque de temps : 
* Présentation d’un résultat de recherche détaillé (bug avec Primefaces et le templating JSF)
* Administration

### Autres commentaires

Ce projet nous a littéralement dégouté de la technologie Java EE principalement à cause de la charge de travail répartie comme telle :
* 1/3 de développement
* 2/3 de debuguage, la plupart du temps sur des éléments dont nous avions pas la main

Ainsi, voici le seul bug détecté subsistant :
* Impossible d'afficher la boite modale Primeface à l'intérieur d'un template (fonctionne en page simple, mais pas avec une composition)

De plus, il peut être interessant de noter que la liste déroulante permettant de selectionner le type de plat souhaité lors d'une recherche est dynamique et est chargée à partir des données en base.
