# Bibliothèques et packages - Exercices

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/07.01-bibliotheques-et-packages/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/07.01-bibliotheques-et-packages/01-supports-de-cours/07.01-bibliotheques-et-packages-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/)

## Exercice 1 : Gestion de tâches avec `ArrayList`

Créez un programme de gestion de tâches qui utilise `ArrayList` pour stocker des
tâches sous forme de chaînes de caractères.

Le programme doit permettre de :

1. Ajouter une nouvelle tâche.
2. Afficher toutes les tâches.
3. Marquer une tâche comme terminée (la supprimer de la liste).
4. Compter le nombre de tâches restantes.

Utilisez un menu simple avec `Scanner` pour interagir avec l'utilisatrice.

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Gestionnaire de tâches ===\n");

        while (running) {
            System.out.println("\n1. Ajouter une tâche");
            System.out.println("2. Afficher les tâches");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Nombre de tâches restantes");
            System.out.println("5. Quitter");
            System.out.print("\nChoix : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choice) {
                case 1:
                    System.out.print("Nouvelle tâche : ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Tâche ajoutée !");
                    break;

                case 2:
                    System.out.println("\n=== Liste des tâches ===");
                    if (tasks.isEmpty()) {
                        System.out.println("Aucune tâche.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("Aucune tâche à terminer.");
                    } else {
                        System.out.print("Numéro de la tâche terminée : ");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (taskNumber > 0 && taskNumber <= tasks.size()) {
                            String completed = tasks.remove(taskNumber - 1);
                            System.out.println("Tâche terminée : " + completed);
                        } else {
                            System.out.println("Numéro invalide.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Nombre de tâches restantes : " + tasks.size());
                    break;

                case 5:
                    running = false;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}
```

</details>

## Exercice 2 : Générateur de nombres aléatoires

Créez un programme qui simule un jeu de devinette avec `Random`.

Le programme doit :

1. Générer un nombre aléatoire entre 1 et 100.
2. Demander à l'utilisatrice de deviner le nombre.
3. Indiquer si la réponse est trop haute, trop basse, ou correcte.
4. Compter le nombre de tentatives.
5. À la fin, afficher des statistiques (nombre de tentatives, pourcentage de
   réussite par rapport au nombre optimal).

<details>
<summary>Solution</summary>

```java
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Jeu de devinette ===\n");
        System.out.println("Je pense à un nombre entre 1 et 100.");
        System.out.println("Pouvez-vous le deviner ?\n");

        // Génération du nombre secret
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean found = false;

        // Boucle de jeu
        while (!found) {
            System.out.print("Votre proposition : ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Trop petit ! Essayez encore.\n");
            } else if (guess > secretNumber) {
                System.out.println("Trop grand ! Essayez encore.\n");
            } else {
                found = true;
                System.out.println("\n🎉 Bravo ! Vous avez trouvé le nombre " +
                        secretNumber + " en " + attempts + " tentatives.");
            }
        }

        // Statistiques
        System.out.println("\n=== Statistiques ===");
        System.out.println("Nombre de tentatives : " + attempts);

        // Le nombre optimal de tentatives pour deviner entre 1 et 100
        // est de 7 (log2(100) ≈ 6.64)
        int optimalAttempts = 7;
        double efficiency = ((double) optimalAttempts / attempts) * 100;

        System.out.printf("Nombre optimal : %d%n", optimalAttempts);
        System.out.printf("Efficacité : %.1f%%%n", efficiency);

        if (attempts <= optimalAttempts) {
            System.out.println("Excellent ! Vous avez été très efficace.");
        } else if (attempts <= optimalAttempts * 2) {
            System.out.println("Bien joué ! Vous pouvez encore vous améliorer.");
        } else {
            System.out.println("Continuez à vous entraîner !");
        }

        scanner.close();
    }
}
```

</details>

## Exercice 3 : Gestion d'événements avec `LocalDateTime`

Créez un système de gestion d'événements qui utilise `java.time` pour manipuler
des dates et des heures.

Le programme doit :

1. Créer plusieurs événements avec un nom, une date et une heure.
2. Afficher tous les événements futurs (après maintenant).
3. Calculer le temps restant jusqu'au prochain événement.
4. Trier les événements par ordre chronologique.
5. Formater l'affichage de manière lisible.

<details>
<summary>Solution</summary>

```java
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Event {
    private String name;
    private LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isFuture() {
        return dateTime.isAfter(LocalDateTime.now());
    }

    public Duration getDurationUntil() {
        return Duration.between(LocalDateTime.now(), dateTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm");
        return name + " - " + dateTime.format(formatter);
    }
}

public class EventManager {
    public static void main(String[] args) {
        System.out.println("=== Gestionnaire d'événements ===\n");

        // Création des événements
        ArrayList<Event> events = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        events.add(new Event("Réunion d'équipe", now.plusDays(2).withHour(14).withMinute(0)));
        events.add(new Event("Présentation projet", now.plusDays(7).withHour(10).withMinute(30)));
        events.add(new Event("Formation Java", now.plusDays(1).withHour(9).withMinute(0)));
        events.add(new Event("Revue de code", now.plusDays(5).withHour(16).withMinute(0)));
        events.add(new Event("Événement passé", now.minusDays(2).withHour(15).withMinute(0)));

        // Filtrage des événements futurs
        ArrayList<Event> futureEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.isFuture()) {
                futureEvents.add(event);
            }
        }

        // Tri chronologique
        Collections.sort(futureEvents, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getDateTime().compareTo(e2.getDateTime());
            }
        });

        // Affichage des événements futurs
        System.out.println("Événements à venir :\n");
        for (Event event : futureEvents) {
            System.out.println(event);
        }

        // Prochain événement
        if (!futureEvents.isEmpty()) {
            Event nextEvent = futureEvents.get(0);
            Duration timeUntil = nextEvent.getDurationUntil();

            long days = timeUntil.toDays();
            long hours = timeUntil.toHours() % 24;
            long minutes = timeUntil.toMinutes() % 60;

            System.out.println("\n=== Prochain événement ===");
            System.out.println(nextEvent);
            System.out.printf("Dans %d jours, %d heures et %d minutes%n",
                    days, hours, minutes);
        } else {
            System.out.println("\nAucun événement à venir.");
        }

        // Statistiques
        System.out.println("\n=== Statistiques ===");
        System.out.println("Total d'événements : " + events.size());
        System.out.println("Événements futurs : " + futureEvents.size());
        System.out.println("Événements passés : " + (events.size() - futureEvents.size()));
    }
}
```

</details>

## Exercice 4 : Carnet d'adresses avec fichiers

Créez un carnet d'adresses qui sauvegarde et charge les contacts depuis un
fichier texte.

Le programme doit :

1. Permettre d'ajouter des contacts (nom, téléphone, email).
2. Afficher tous les contacts.
3. Rechercher un contact par nom.
4. Sauvegarder tous les contacts dans un fichier `contacts.txt`.
5. Charger les contacts depuis le fichier au démarrage.

Format du fichier : une ligne par contact avec les champs séparés par des
points-virgules.

<details>
<summary>Solution</summary>

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String toFileLine() {
        return name + ";" + phone + ";" + email;
    }

    public static Contact fromFileLine(String line) {
        String[] parts = line.split(";");
        if (parts.length == 3) {
            return new Contact(parts[0], parts[1], parts[2]);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-15s | %s", name, phone, email);
    }
}

public class AddressBook {
    private static final String FILENAME = "contacts.txt";
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chargement des contacts
        loadContacts();

        System.out.println("=== Carnet d'adresses ===\n");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Ajouter un contact");
            System.out.println("2. Afficher tous les contacts");
            System.out.println("3. Rechercher un contact");
            System.out.println("4. Sauvegarder et quitter");
            System.out.print("\nChoix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    searchContact(scanner);
                    break;
                case 4:
                    saveContacts();
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Nom : ");
        String name = scanner.nextLine();

        System.out.print("Téléphone : ");
        String phone = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact ajouté !");
    }

    private static void displayContacts() {
        System.out.println("\n=== Liste des contacts ===\n");

        if (contacts.isEmpty()) {
            System.out.println("Aucun contact.");
        } else {
            System.out.println(String.format("%-20s | %-15s | %s",
                    "Nom", "Téléphone", "Email"));
            System.out.println("-".repeat(60));

            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void searchContact(Scanner scanner) {
        System.out.print("Nom à rechercher : ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchName.toLowerCase())) {
                if (!found) {
                    System.out.println("\n=== Résultats ===\n");
                    found = true;
                }
                System.out.println(contact);
            }
        }

        if (!found) {
            System.out.println("Aucun contact trouvé.");
        }
    }

    private static void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                Contact contact = Contact.fromFileLine(line);
                if (contact != null) {
                    contacts.add(contact);
                    count++;
                }
            }

            System.out.println(count + " contacts chargés depuis " + FILENAME);

        } catch (IOException e) {
            System.out.println("Aucun fichier de contacts trouvé. Démarrage avec un carnet vide.");
        }
    }

    private static void saveContacts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Contact contact : contacts) {
                writer.write(contact.toFileLine());
                writer.newLine();
            }

            System.out.println(contacts.size() + " contacts sauvegardés dans " + FILENAME);

        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}
```

</details>

## Exercice 5 : Calculatrice avec `BigDecimal`

Créez une calculatrice qui utilise `BigDecimal` de `java.math` pour effectuer
des calculs précis avec des nombres décimaux.

Le programme doit :

1. Permettre d'effectuer les opérations de base (addition, soustraction,
   multiplication, division).
2. Gérer la précision des résultats (nombre de décimales).
3. Afficher l'historique des calculs effectués.
4. Calculer des pourcentages et des puissances.

<details>
<summary>Solution</summary>

```java
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class PreciseCalculator {
    private static ArrayList<String> history = new ArrayList<>();
    private static final int PRECISION = 10; // Nombre de décimales

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Calculatrice précise ===\n");

        while (running) {
            System.out.println("\n1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Pourcentage");
            System.out.println("6. Puissance");
            System.out.println("7. Afficher l'historique");
            System.out.println("8. Quitter");
            System.out.print("\nChoix : ");

            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 6) {
                System.out.print("Premier nombre : ");
                BigDecimal a = scanner.nextBigDecimal();

                System.out.print("Second nombre : ");
                BigDecimal b = scanner.nextBigDecimal();

                BigDecimal result = null;
                String operation = "";

                switch (choice) {
                    case 1:
                        result = a.add(b);
                        operation = "+";
                        break;
                    case 2:
                        result = a.subtract(b);
                        operation = "-";
                        break;
                    case 3:
                        result = a.multiply(b);
                        operation = "×";
                        break;
                    case 4:
                        if (b.compareTo(BigDecimal.ZERO) == 0) {
                            System.out.println("Erreur : division par zéro !");
                            continue;
                        }
                        result = a.divide(b, PRECISION, RoundingMode.HALF_UP);
                        operation = "÷";
                        break;
                    case 5:
                        // Calcul de "a" est "b"% de quoi
                        result = a.multiply(b).divide(
                                new BigDecimal("100"),
                                PRECISION,
                                RoundingMode.HALF_UP
                        );
                        operation = "% de";
                        break;
                    case 6:
                        // Puissance (limité aux entiers pour b)
                        try {
                            int exponent = b.intValueExact();
                            result = a.pow(exponent);
                            operation = "^";
                        } catch (ArithmeticException e) {
                            System.out.println("Erreur : l'exposant doit être un entier.");
                            continue;
                        }
                        break;
                }

                if (result != null) {
                    // Suppression des zéros inutiles
                    result = result.stripTrailingZeros();

                    String calculation = a + " " + operation + " " + b + " = " + result;
                    history.add(calculation);

                    System.out.println("\nRésultat : " + result);
                }

            } else if (choice == 7) {
                displayHistory();
            } else if (choice == 8) {
                running = false;
                System.out.println("Au revoir !");
            } else {
                System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }

    private static void displayHistory() {
        System.out.println("\n=== Historique des calculs ===\n");

        if (history.isEmpty()) {
            System.out.println("Aucun calcul effectué.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }
}
```

</details>

## Exercice 6 : Bibliothèque de livres

Créez un système de gestion de bibliothèque qui utilise plusieurs concepts vus
dans ce cours.

Le programme doit :

1. Gérer une collection de livres (titre, auteur, année, disponibilité).
2. Utiliser `ArrayList` pour stocker les livres.
3. Calculer des statistiques (livre le plus ancien, nombre de livres par
   auteur).
4. Sauvegarder et charger la bibliothèque depuis un fichier.
5. Permettre d'emprunter et de retourner des livres avec des dates.
6. Afficher les livres empruntés avec leur date de retour prévue.

<details>
<summary>Solution</summary>

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;
    private LocalDate dueDate;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
        this.dueDate = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void borrow(int days) {
        available = false;
        dueDate = LocalDate.now().plusDays(days);
    }

    public void returnBook() {
        available = true;
        dueDate = null;
    }

    public String toFileLine() {
        String dueDateStr = (dueDate != null) ? dueDate.toString() : "";
        return title + ";" + author + ";" + year + ";" + available + ";" + dueDateStr;
    }

    public static Book fromFileLine(String line) {
        String[] parts = line.split(";");
        if (parts.length >= 4) {
            Book book = new Book(parts[0], parts[1], Integer.parseInt(parts[2]));
            book.available = Boolean.parseBoolean(parts[3]);

            if (parts.length == 5 && !parts[4].isEmpty()) {
                book.dueDate = LocalDate.parse(parts[4]);
            }

            return book;
        }
        return null;
    }

    @Override
    public String toString() {
        String status = available ? "Disponible" : "Emprunté";
        String info = String.format("%-30s | %-20s | %d | %s",
                title, author, year, status);

        if (!available && dueDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            info += " (retour: " + dueDate.format(formatter) + ")";
        }

        return info;
    }
}

public class Library {
    private static final String FILENAME = "library.txt";
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadLibrary();

        System.out.println("=== Système de bibliothèque ===\n");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Ajouter un livre");
            System.out.println("2. Afficher tous les livres");
            System.out.println("3. Emprunter un livre");
            System.out.println("4. Retourner un livre");
            System.out.println("5. Statistiques");
            System.out.println("6. Sauvegarder et quitter");
            System.out.print("\nChoix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    borrowBook(scanner);
                    break;
                case 4:
                    returnBook(scanner);
                    break;
                case 5:
                    displayStatistics();
                    break;
                case 6:
                    saveLibrary();
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Titre : ");
        String title = scanner.nextLine();

        System.out.print("Auteur : ");
        String author = scanner.nextLine();

        System.out.print("Année : ");
        int year = scanner.nextInt();
        scanner.nextLine();

        books.add(new Book(title, author, year));
        System.out.println("Livre ajouté !");
    }

    private static void displayBooks() {
        System.out.println("\n=== Catalogue ===\n");

        if (books.isEmpty()) {
            System.out.println("Aucun livre dans la bibliothèque.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    private static void borrowBook(Scanner scanner) {
        displayBooks();

        if (books.isEmpty()) {
            return;
        }

        System.out.print("\nNuméro du livre à emprunter : ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine();

        if (bookNumber > 0 && bookNumber <= books.size()) {
            Book book = books.get(bookNumber - 1);

            if (book.isAvailable()) {
                System.out.print("Durée de l'emprunt (jours) : ");
                int days = scanner.nextInt();
                scanner.nextLine();

                book.borrow(days);
                System.out.println("Livre emprunté ! À retourner avant le " +
                        book.getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            } else {
                System.out.println("Ce livre est déjà emprunté.");
            }
        } else {
            System.out.println("Numéro invalide.");
        }
    }

    private static void returnBook(Scanner scanner) {
        // Afficher seulement les livres empruntés
        System.out.println("\n=== Livres empruntés ===\n");

        ArrayList<Integer> borrowedIndices = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).isAvailable()) {
                borrowedIndices.add(i);
                System.out.println((borrowedIndices.size()) + ". " + books.get(i));
            }
        }

        if (borrowedIndices.isEmpty()) {
            System.out.println("Aucun livre emprunté.");
            return;
        }

        System.out.print("\nNuméro du livre à retourner : ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= borrowedIndices.size()) {
            Book book = books.get(borrowedIndices.get(choice - 1));
            book.returnBook();
            System.out.println("Livre retourné !");
        } else {
            System.out.println("Numéro invalide.");
        }
    }

    private static void displayStatistics() {
        System.out.println("\n=== Statistiques ===\n");

        int available = 0;
        int borrowed = 0;
        int oldestYear = Integer.MAX_VALUE;
        String oldestBook = "";

        // Comptage par auteur
        HashMap<String, Integer> authorCounts = new HashMap<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                available++;
            } else {
                borrowed++;
            }

            if (book.getYear() < oldestYear) {
                oldestYear = book.getYear();
                oldestBook = book.getTitle();
            }

            String author = book.getAuthor();
            authorCounts.put(author, authorCounts.getOrDefault(author, 0) + 1);
        }

        System.out.println("Nombre total de livres : " + books.size());
        System.out.println("Livres disponibles : " + available);
        System.out.println("Livres empruntés : " + borrowed);

        if (!books.isEmpty()) {
            System.out.println("\nLivre le plus ancien :");
            System.out.println("  " + oldestBook + " (" + oldestYear + ")");
        }

        System.out.println("\nNombre de livres par auteur :");
        for (String author : authorCounts.keySet()) {
            System.out.println("  " + author + " : " + authorCounts.get(author));
        }
    }

    private static void loadLibrary() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                Book book = Book.fromFileLine(line);
                if (book != null) {
                    books.add(book);
                    count++;
                }
            }

            System.out.println(count + " livres chargés depuis " + FILENAME + "\n");

        } catch (IOException e) {
            System.out.println("Aucune bibliothèque trouvée. Démarrage avec une collection vide.\n");
        }
    }

    private static void saveLibrary() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Book book : books) {
                writer.write(book.toFileLine());
                writer.newLine();
            }

            System.out.println(books.size() + " livres sauvegardés dans " + FILENAME);

        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}
```

</details>

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
