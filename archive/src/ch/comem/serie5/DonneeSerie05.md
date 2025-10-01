Comem – Cours BaseProg M53

# Série 5 (Fonctions)

1. Ecrire une fonction qui additionne trois réels reçu en paramètre et qui affiche le résultat sous la forme
   4.5 + 5.2 + 6.4 = 16.1

2. Ecrire une fonction qui additionne trois réels reçu en paramètre et qui retourne le résultat.      

3. Ecrire une fonction qui retourne le caractère reçu en paramètre en majuscule.

   ​	Exemple : 
   ​		"a" => "A" 
   ​	Remarque : Ne pas tenir compte des accents.

4. Ecrire une fonction qui retourne le caractère reçu en paramètre en minuscule.

   ​		Exemple : 
   ​			"A" => "a"

5. En vous basant sur les fonctions de l'exercice 3 et 4, veillez écrire une fonction nommée 'ucfirst' prenant      comme paramètre une chaine de caractère et qui retourne une chaine de caractère dont la 1ère lettre est une majuscule suivie de lettres minuscules.

   ​	Exemple :
   ​		"PAUL" => "Paul"
   ​		"simone" => "Simone"

6. Ecrire une fonction nommée 'implode' prenant comme paramètre :
    - un séparateur de son choix (virgule par exemple)
    - un tableau de réels
     et qui rend une chaine de caractère contenant les éléments du tableau séparés par le caractère voulu : 
        5.5, 7.6, 3.1, 9.2, 56.4

7. Ecrire une fonction permettant de trier les éléments d'un tableau par ordre croissant.
   Voici comment procéder :
   Prendre les deux premiers éléments du tableau. 
   Si le premier et plus grand que le deuxième, les permuter
   Recommencer l'opération avec les deux éléments suivants du tableau
   idem jusqu'à la fin du tableau.

   ​	Exemple :
   ​             5          6          3          1          Traitement de 5 et 6 => rien à faire
   ​             5          6          3          1          Traitement de 6 et 3 => permuter 
   ​             5          3          6          1          Traitement de 6 et 1 => permuter
   ​             5          3          1          6          Le plus grand chiffre est en place
   Même logique pour les (size(tab)-1) éléments du tableau
   ​             5          3          1          6          Traitement de 5 et 3 => permuter
   ​             3          5          1          6          Traitement de 5 et 1 => permuter
   ​             3          1          5          6          L'avant dernier chiffre est en place
   Même logique pour les (size(tab)-2) éléments du tableau
   ​             3          1          5          6          Traitement de 1 et 3 => permuter
   ​             1          3          5          6          Tous les éléments sont en place :-)

8. Ecrire une fonction prenant comme paramètres un nombre et un tableau de réel et qui retourne un booléen permettant de savoir si le nombre et contenu dans le tableau.

9. Ecrire une fonction permettant d'arrondir un chiffre à la précision voulue.

10. Ecrire une fonction permettant de retourner un nombre aléatoire compris entre deux bornes (valeur des bornes comprises).