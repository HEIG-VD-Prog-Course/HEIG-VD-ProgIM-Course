Comem – Cours BaseProg M53

# Série 3 (Boucles)

1. Contrôle de saisie : écrire un algorithme qui demande à l’utilisateur un nombre dans l’intervalle [1;3], qui lit cette valeur et qui recommence tant que la réponse ne convient pas.
   Exemple :
      	Veuillez saisir un nombre dans l'intervalle [1;3]
          0
      	La valeur 0 ne fait pas partie de l'intervalle spécifié...
      	Veuillez saisir un nombre dans l'intervalle [1;3]
      	4
      	La valeur 4 ne fait pas partie de l'intervalle spécifié...
      	Veuillez saisir un nombre dans l'intervalle [1;3]
      	2
      	La valeur : 2 est correcte :-)

2. Ecrire un compte à rebours à partir d’un entier positif saisi par l’utilisateur.

   Exemple : 
   		Veuillez saisir un nombre strictement positif
   		0
   		Le nombre n'est pas strictement positif
   		Veuillez saisir un nombre strictement positif
   		4
   		Compte à rebours à partir de 4
               4
   			3
               2
   			1
   			0	

3. Ecrire un programme qui affiche les nombres entiers pairs de l’intervalle [1 ;N], N étant saisi par l’utilisateur.

   ​	Exemple :
   ​		Ce programme affiche les nombres pairs entre 1 et une limite supérieure saisie par l'utilisateur.
   ​		Entrez la limite supérieure (>=2) des nombres pairs à afficher
   ​		5
   ​		Liste des nombres pairs entre 1 et 5 est :
   ​			2
   ​			4

4. A partir de la donnée d'un capital de départ "C", d'un taux d'intérêt "I" et d'un nombre de périodes "P", calculer et afficher le capital obtenu après chaque période.
   Exemple :
      		Entrez le capital (>0) de départ
      		2000
      		Entrez le taux d'intérêt en %
      		5
      		Entrez le nombre de périodes (>0)
      		3
      		Une somme de 2000 placée durant 3 période(s) avec un taux d'intérêt de 5% génère : 
      			après 1 période(s) : 2100
      			après 2 période(s) : 2205
      			après 3 période(s) : 2315.25 

5. Ecrire un programme qui permette à un utilisateur de saisir 5 nombres entiers. Une fois les nombres saisis, le programme affichera le plus petit et le plus grand des nombres saisis.

   Exemple :
   ​		Entrez le 1er nombre
   ​		3
   ​		Entrez le 2e nombre
   ​		-4
   ​		Entrez le 3e nombre
   ​		7

   ​		Entrez le 4e nombre
   ​		-8
   ​		Entrez le 5e nombre
   ​		3

   ​		Le plus petit nombre saisi est -8
   ​		Le plus grand nombre saisi est 7

6. Ecrire un programme qui permette de compter combien il y a de nombres inférieurs ou égaux à 15 dans une liste de 5 nombres entiers saisis par l'utilisateur : 

   Exemple :
   ​		Entrez le 1e nombre
   ​		5
   ​		Entrez le 2e nombre
   ​		10
   ​		Entrez le 3e nombre
   ​		15
   ​		Entrez le 4e nombre
   ​		20
   ​		Entrez le 5e nombre
   ​		-5

   ​		Il y a 4 nombre(s) <= 15 

7. Ecrire un algorithme qui demande un  nombre entier de départ, et qui calcule la somme des entiers à partir de 1 jusqu’à ce nombre. 

   Par exemple, si l’on entre 5, le programme doit calculer : 1 + 2 + 3 + 4 + 5 = 15

8. Ecrire un algorithme qui demande un nombre de départ (entier positif), et qui calcule sa factorielle.

   Exemple : la factorielle de 5, notée 5!, vaut 1 x 2 x 3 x 4 x 5 = 120.

9. L'utilisateur choisit un nombre N de notes et saisi ces N notes. 
     A la fin de la saisie, le programme affiche la moyenne et la plus grande de ces notes. 
     (De plus, il faut assurer le contrôle de la validité de notes saisies [1.0;6.0])

10. Idem mais cette fois-ci, on ne demande pas à l'utilisateur combien de notes il veut saisir, mais c'est lui qui stoppe la saisie en entrant une note invalide (hors de l'intervalle de validité).

    Exemple :
    	Entrez la 1e note [1;6] :
    	3
    	Entrez la 2e note [1;6] :
    	6
    	Entrez la 3e note [1;6] :
    	2
    	Entrez la 4e note [1;6] :
    	0
    	La note 0 n'a pas été prise en compte !

    ​    La moyenne des notes vaut : 3.66666666666667
    ​    La meilleure note est : 6

11. Afficher les premiers termes de la suite de Fibonacci jusqu'à l'ordre N. La donnée N doit être positive ou nulle. La suite de Fibonacci est définie par:

    ​	F(0)=0
    ​	F(1)=1
    ​	F(k)=F(k-2)+F(k-1) pour k>1

    ​	Exemple : 
    ​		Quel est l'ordre du nombre de Fibonacci à calculer ? (>=0)
    ​		5
    ​		f(0) = 0
    ​		f(1) = 1
    ​		f(2) = 1 (On additionne les 2 chiffres précédents 0+1)
    ​		f(3) = 2 (On additionne les 2 chiffres précédents 1+1)
    ​		f(4) = 3 (On additionne les 2 chiffres précédents 1+2)
    ​		f(5) = 5 (On additionne les 2 chiffres précédents 2+3 etc.) 

12. Afficher un échiquier 8x8 : case noire = caractère #, case blanche = caractère o.

    ​	Exemple : 
    ​              o   #   o   #   o   #   o   #    
    ​              \#   o   #   o   #   o   #   o 
    ​              o   #   o   #   o   #   o   # 
    ​              \#   o   #   o   #   o   #   o 
    ​              o   #   o   #   o   #   o   # 
    ​              \#   o   #   o   #   o   #   o 
    ​              o   #   o   #   o   #   o   # 
    ​              \#   o   #   o   #   o   #   o 

