package ch.comem.serie3_Suite;

import ch.comem.Clavier;

public class Exercice07_Horloge {

    public static void main(String[] args) throws InterruptedException{
        String affichageHorloge;
        int saisie;
        int min;
        int max;
        
        min = 0;
        int maxHeures;
        
        maxHeures = 23;
        int maxMinutes;
        
        maxMinutes = 59;
        int maxSecondes;
        
        maxSecondes = 59;
        boolean saisieOk;
        int typeSaisie;
        String message;
        int heures = 0;
        int minutes = 0;
        int secondes = 0;
        int saisieDesHeures;
        
        saisieDesHeures = 1;
        int saisieDesMinutes;
        
        saisieDesMinutes = 2;
        int saisieDesSecondes;
        
        saisieDesSecondes = 3;
        message = "heures";
        max = maxHeures;
        
        // Saisie des heures, minutes et secondes
        for (typeSaisie = saisieDesHeures; typeSaisie <= saisieDesSecondes; typeSaisie++) {
            do {
                saisie = Clavier.rend_int("Veuillez saisir les " + message + " : ");
                saisieOk = saisie >= min && saisie <= max;
                if (!saisieOk) {
                    System.out.println("Les " + message + " doivent êtres comprises entre " + min + " et " + max + " !");
                }
            }
            while (!saisieOk);
            if (typeSaisie == saisieDesHeures) {
                heures = saisie;
                message = "minutes";
                max = maxMinutes;
            } else {
                if (typeSaisie == saisieDesMinutes) {
                    minutes = saisie;
                    message = "secondes";
                } else {
                    secondes = saisie;
                }
            }
        }
        
        // Affichage de l'horloge
        do {
            affichageHorloge = "";
            if (heures <= 9) {
                affichageHorloge = affichageHorloge + "0";
            }
            affichageHorloge = affichageHorloge + heures + ":";
            if (minutes <= 9) {
                affichageHorloge = affichageHorloge + "0";
            }
            affichageHorloge = affichageHorloge + minutes + ":";
            if (secondes <= 9) {
                affichageHorloge = affichageHorloge + "0";
            }
            affichageHorloge = affichageHorloge + secondes;
            System.out.println(affichageHorloge);
            
            Thread.sleep(1000);
            
            // Mise à jour des compteur
            secondes = secondes + 1;
            if (secondes == maxSecondes + 1) {
                secondes = 0;
                minutes = minutes + 1;
            }
            if (minutes == maxMinutes + 1) {
                minutes = 0;
                heures = heures + 1;
            }
            if (heures == maxHeures + 1) {
                heures = 0;
            }
        }
        while (true);
        
        // Eh oui, une fois n'est pas coutume...; une boucle infinie a du sens parfois ;-)
    }
}
