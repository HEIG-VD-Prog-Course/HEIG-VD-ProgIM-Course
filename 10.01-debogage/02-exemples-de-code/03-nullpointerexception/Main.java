/**
 * Exemple de débogage : NullPointerException
 * 
 * Ce programme contient un bug qui cause une NullPointerException.
 * 
 * MISSION :
 * 1. Lancer le programme et observer l'exception
 * 2. Placer des breakpoints avant l'endroit qui plante
 * 3. Inspecter les variables pour trouver laquelle est null
 * 4. Remonter dans le code pour comprendre pourquoi
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Débogage : NullPointerException ===\n");

        // Créer quelques étudiants
        Student alice = new Student("Alice", 20);
        Student bob = new Student("Bob", 22);
        Student charlie = null; // BUG : charlie n'est pas initialisé

        // Afficher les informations
        displayStudent(alice);
        displayStudent(bob);
        displayStudent(charlie); // NullPointerException ici

        System.out.println("\n=== Fin de l'exemple ===");
    }

    /**
     * Affiche les informations d'un étudiant.
     * 
     * @param student l'étudiant à afficher
     */
    public static void displayStudent(Student student) {
        // BUG : Pas de vérification si student est null
        System.out.println("Nom : " + student.getName());
        System.out.println("Âge : " + student.getAge());
        System.out.println("Email : " + student.getEmail());
        System.out.println();
    }
}

/**
 * Classe représentant un étudiant.
 */
class Student {
    private String name;
    private int age;
    private String email;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        // BUG : email n'est jamais initialisé (reste null)
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        // BUG : retourne null si email n'a pas été défini
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

/*
 * CORRECTIONS :
 * 
 * 1. Dans main() :
 * - Initialiser charlie correctement :
 * Student charlie = new Student("Charlie", 19);
 * 
 * Ou vérifier avant d'utiliser :
 * if (charlie != null) {
 * displayStudent(charlie);
 * }
 * 
 * 2. Dans displayStudent() :
 * - Ajouter une vérification au début :
 * if (student == null) {
 * System.out.println("Erreur : étudiant null");
 * return;
 * }
 * 
 * 3. Dans getEmail() :
 * - Retourner une valeur par défaut si email est null :
 * return email != null ? email : "Non défini";
 * 
 * Ou initialiser email dans le constructeur :
 * this.email = "non-defini@email.com";
 * 
 * EXPLICATION :
 * - NullPointerException arrive quand on essaie d'utiliser un objet null
 * - Le débogueur permet de voir quelle variable est null
 * - Il faut toujours vérifier qu'un objet n'est pas null avant de l'utiliser
 */
