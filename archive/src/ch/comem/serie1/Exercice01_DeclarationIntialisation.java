package ch.comem.serie1;

/* 
   Déclarez une variable nommée age de type entier et initialisez-la avec la valeur 22.
   Afficher ensuite un message sous la forme :
   Votre âge : 22
*/
public class Exercice01_DeclarationIntialisation {

    // Règle les éventuels problèmes d'affichage des accents
    static {
        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out), true, "UTF-8"));
            
        } catch (java.io.UnsupportedEncodingException ex) {
            System.out.println("VM dont support UTF-8");
        }
    }
    
    public static void main(String[] args) {
        int age = 22;
        System.out.println("Votre âge : " + age);
    }
    
}
