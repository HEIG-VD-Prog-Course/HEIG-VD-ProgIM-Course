Comem – Cours BaseProg M53

# Série 5 (Fonctions - Tableau multidimensionnels)

1. Reprendre l'exercice permettant à plusieurs personnes de jouer à une partie de [minigolf](https://fr.wikipedia.org/wiki/Minigolf) et le structurer à l'aide de fonctions et d'un tableau à deux dimensions.
   
   
   
1. Ecrire une fonction permettant d'afficher un échiquier
   'O' : Case blanche
   '#'  : Case noire
   
   ```java
           A   B   C   D   E   F   G   H   
           
   8       O   #   O   #   O   #   O   #       8
   7       #   O   #   O   #   O   #   O       7
   6       O   #   O   #   O   #   O   #       6
   5       #   O   #   O   #   O   #   O       5
   4       O   #   O   #   O   #   O   #       4
   3       #   O   #   O   #   O   #   O       3
   2       O   #   O   #   O   #   O   #       2
   1       #   O   #   O   #   O   #   O       1
               
           A   B   C   D   E   F   G   H 
   ```
   
3. Ecrire une fonction permettant de placer un pion sur une case d'un échiquier

   Exemple pour placer un pion sur la case D5 d'un échiquier : (On affiche le caractère P pour indiquer le pion)

   ```java
   
           A   B   C   D   E   F   G   H   
               
   8       O   #   O   #   O   #   O   #       8
   7       #   O   #   O   #   O   #   O       7
   6       O   #   O   #   O   #   O   #       6
   5       #   O   #   P   #   O   #   O       5
   4       O   #   O   #   O   #   O   #       4
   3       #   O   #   O   #   O   #   O       3
   2       O   #   O   #   O   #   O   #       2
   1       #   O   #   O   #   O   #   O       1
               
           A   B   C   D   E   F   G   H 
   ```

4. Ecrire les fonctions permettant de :

   - placer un cavalier sur une case d'un échiquier (s'il n'y a pas d'autres pièces dessus)
   - déplacer un cavalier d'une case à une autre (si c'est possible en respectant les règles de déplacement en ['L'](https://fr.wikipedia.org/wiki/Probl%C3%A8me_du_cavalier) du cavalier)

5. Ecrire un programme permettant de jouer au problème du cavalier.

   Un [cavalier](https://fr.wikipedia.org/wiki/Cavalier_(échecs)) posé sur une case quelconque d'un échiquier doit en visiter toutes les cases sans passer deux fois sur la même. 
   Indications :

   - Le programme doit permettre de placer un cavalier n'importe où sur un échiquier
   - On doit pouvoir déplacer le cavalier (si c'est possible) sur une case non visitée
   - Le programme doit se souvenir des déplacements effectués (E8, G7, H5, ...)
   - Les cases visitées de l'échiquier doivent être numérotées de 1 à 64 