Comem – Cours BaseProg M53

# Série 2 (Sélection)

1. Ecrire un programme qui saisit et calcule la valeur absolue d’un réel. 
   Afficher le résultat sous la forme : "La valeur absolue de -5 est 5"      

2. Ecrire un programme qui demande un caractère à l’utilisateur et qui vérifie si c’est une lettre minuscule (ne pas prendre en compte les caractères accentués). 

3. Ecrire un programme qui demande un caractère à l’utilisateur et qui vérifie si c’est une voyelle
   (ne pas prendre en compte les caractères accentués). 

4. Ecrire un programme qui demande un nombre à l’utilisateur, et l’informe ensuite si ce nombre est négatif (<0) ou positif (>=0). 

5. Ecrire un programme qui demande un nombre à l’utilisateur, et l’informe ensuite si ce nombre est positif, négatif ou nul.

6. Veuillez écrire un programme qui résout l’équation du premier degré : ax+b=0. 
   L'utilisateur saisit les valeurs réelles de a et de b puis le programme calcule et affiche la valeur de x. 

   ​     Exemple :
   ​          Soit l'équation ax+b = 0
   ​               Veuillez saisir la valeur de a : 0.5
   ​               Veuillez saisir la valeur de b : 5
   ​               L'équation 0.5*x+5=0, a comme solution x=-10

   Remarque : Il y a un petit piège dans lequel il ne faudrait pas tomber ;-)

7. Veuillez écrire un programme qui saisit trois nombres a, b, c et qui affiche les valeurs saisies par ordre  croissant.

   ​	Exemple :
   ​         Veuillez saisir le 1e nombre : 4.2
   ​         Veuillez saisir le 2e nombre : 10.5
   ​         Veuillez saisir le 3e nombre : -5
   ​         Vous avez saisi les valeurs suivantes : -5, 4.2 et 10.5

8. La compagnie d'aviation "Les Ailes" vous demande de réaliser un programme qui sera mis à la      disposition des voyageurs dans les aéroports. Ce programme devra permettre aux clients d'interroger le système sur le prix du billet; celui-ci varie en fonction du type de voyageur ainsi que du nombre de vols déjà effectués avec la compagnie au cours de l'année de la manière suivante:

   Les employés de la compagnie (type de voyageur n°1) bénéficient d'un rabais de 20% sur le prix de base du billet,

   - les membres du club "Cigogne" (type n°2) obtiennent un rabais de 10% sur le prix de base du billet, 
   - les autres voyageurs (type n°3) n'obtiennent pas de rabais.

   De plus, si le voyageur a déjà volé avec la compagnie lors de l'année courante, il bénéficie d'un rabais supplémentaire (sur le prix de base) proportionnel au nombre de vols effectués; celui-ci se monte à 10% pour un vol, à 15% pour 2, 3 ou 4 vols et à 20% pour 5 vols ou plus.

   Le programme que vous êtes chargés de réaliser calculera et affichera le prix effectif du billet (arrondi à 5 centimes) à partir du prix de base, du type de voyageur et du nombre de vols effectués au cours de l'année.

   ​	Exemple :
   ​	     Entrez le prix du billet : 123.45
   ​	     Tapez 1 si vous êtes un client normal,
   ​	     Tapez 2 si vous êtes un employé de la compagnie,
   ​	     Tapez 3 si vous êtes membre du club CIGOGNE.
   ​	     3
   ​	     Entez le nombre de vols effectués avec notre compagnie : 45 
   ​         Prix de base : 123.45.-
   ​	     Votre rabais : 30%
   ​	     Votre prix : 86.40.-

9. Un cinéma désire automatiser le calcul du prix de ses billets d'entrée. 
         Le prix du billet varie en fonction de différents critères : 
                - Les enfants jusqu'à l'âge de 7 ans y compris payent 5 Frs ; 
                - Les jeunes entre 8 à 18 ans y compris payent 10 Frs; 
                - Pour les autres, le prix est de 15 Frs. 
   De plus, une réduction de 20% est faite sur ce prix le lundi, une réduction de 10% est faite le mardi et le jeudi, les autres jours il n'y a pas de réduction. 
   Le programme que vous êtes chargés de réaliser calculera et affichera le prix à payer (arrondi à 50 centimes) à partir de l'âge et du jour.

   ​     Exemple : 
   ​          Saisissez l'âge de la personne : 15
   ​          Veuillez entrer le nom du jour en minuscule (Ex: lundi) : lundi
   ​          Prix de base : 10.-
   ​          Votre rabais : 20%
   ​          Votre prix :  8.00.- 

10. Une entreprise de vente de pièces détachées désire automatiser le calcul des factures pour ses clients.
    La somme à payer varie en fonction du nombre de pièces de la manière suivante: 
            - Les clients achetant au moins 50 pièces bénéficient d'un rabais de 3%, 
            - ceux qui achètent au moins 100 pièces obtiennent un rabais de 5%, enfin,
            - ceux qui achètent 1000 pièces ou plus obtiennent un rabais de 10%.
    Sur le prix obtenu, les clients doivent payer la TVA qui se monte :
            - à 8,2% pour des lots comprenant jusqu'à 250 pièces y compris, 
            - à 6,3% pour les lots comprenant jusqu'à 500 pièces y compris et 
            - à 4,5% pour les lots de plus de 500 pièces.

    Le programme que vous êtes chargés de réaliser calculera et affichera la somme à payer (arrondie à 10 centimes) à partir de la donnée du nombre de pièces et du prix unitaire (prix d'une pièce).

    ​     Exemple :
    ​          Combien de pièces voulez-vous acheter ? 552
    ​          Quel est le prix unitaire de la pièce ? 4.75
    ​          Le prix TTC pour 552 pièces à 4.75.- avec un rabais de 5% et un taux TVA à 4.5% sera de : 2602.90.- 

11. Ecrire un programme qui demande à l'utilisateur de saisir une date sous la forme de trois entiers (jour / mois / année). Indiquez à l'utilisateur si la date saisie est valide ou non. 

    Quelques indications :

    Pour la durée du mois, c'est selon le numéro du mois :
     - pour les mois 4, 6, 9, 11 : 30 jours
     - pour le mois 2, 29 jours pour les années bissextiles sinon c'est 28 jours
     - pour les autres, 31 jours

    Pour une année bissextile :
    Si l'année est divisible par 4 mais pas par 100 ou si elle est divisible par 400, alors elle est bissextile sinon elle ne l'est pas.

    ​     Exemple :
    ​          Veuillez saisir le jour : 29
    ​          Veuillez saisir le mois : 2
    ​          Veuillez saisir l'année : 2000

    ​          La date 29.2.2000 est valide 

12. Veuillez écrire un programme qui décompose une somme d'argent (saisie par l'utilisateur) en le moins de pièces de 5.-, de 2.- et de 1.- possibles.

    ​      Exemple :
    ​           Veuillez saisir la somme à décomposer : 18
    ​           Il faut 5 pièces pour arriver à 18.- :
    ​                 3 pièces de 5.-
    ​                 1 pièce de 2.-
    ​                 1 pièce de 1.-

