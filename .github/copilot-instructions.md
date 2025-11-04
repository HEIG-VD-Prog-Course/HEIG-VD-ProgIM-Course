# GitHub Copilot Instructions

This repository contains teaching materials for a programming course
(HEIG-VD-ProgIM-Course).

## Context

- **Language**: Course materials are primarily in French
- **Target Audience**: Students learning programming for the first time
- **Content Type**: Educational presentations (Marp), code examples, exercises,
  and PlantUML diagrams
- **Level**: Beginner - first programming course, no prior experience required
- **Technology Stack**: Java, algorithms, data structures, software design

## Teaching Philosophy

This course follows key pedagogical principles:

- **Straight to the point**: Quick, efficient and useful content without wasting
  time
- **Open**: Content can be improved, changed, and discussed openly
- **Resilient**: Materials should be understandable and maintainable by others
- **Freedom**: Students should pursue topics they find interesting and engaging
- **Shit happens**: Create a safe space where mistakes are acceptable and
  students can openly discuss challenges

### Learning Approach

- **Self-directed learning**: Give students tools to learn independently
- **Big picture first**: Short presentations provide overview, then students
  explore deeper through hands-on materials
- **Flexible pace**: Students can choose their own path - theory first,
  practical first, or mixed
- **Hybrid-friendly**: All materials available for on-site or remote learning
- **Real-world relevance**: Focus on practical skills used in industry, not just
  academic exercises
- **"Teach them to fish"**: Guide students to find solutions rather than giving
  direct answers

### Pedagogical Foundations

- Bloom's taxonomy for learning objectives
- _"L'intelligence ce n'est pas ce que l'on sait mais ce que l'on fait quand on
  ne sait pas."_ - Jean Piaget
- Competency-based learning: mobilizing and combining resources to solve real
  problems

## Guidelines

### General Instructions

1. **Language Style**: Use real-life, story-like language instead of programming
   terms when creating examples or explanations
2. **French Content**: Most content should be in French unless specifically
   working on code
3. **Educational Focus**: Explanations should be clear, pedagogical, and
   appropriate for beginner-level students
4. **No Emojis**: Never use emojis in any course materials, presentations, or
   exercises
5. **Encourage exploration**: Guide students toward solutions without giving
   direct answers - "teach them to fish"
6. **Real-world relevance**: Prefer practical, industry-relevant examples over
   purely academic ones
7. **Respect student freedom**: Support diverse approaches and personal projects
   that engage students

### Author Attribution

All course materials must include the following attribution format:

```markdown
V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].
```

- Always use "V. Guidoux" as the author
- Include the GitHub Copilot attribution line
- Include the CC BY-SA 4.0 license reference with link variable `[licence]`

### File Structure

- `XX.XX-topic/` folders contain course modules
- `01-supports-de-cours/` contains presentation materials (PRESENTATION.md using
  Marp)
- `02-exemples-de-code/` contains runnable code examples (when applicable)
- `03-exercices/` contains exercises (when applicable)
- PlantUML diagrams are in `images/` folders with `.plantuml` extension

### Root README Structure

The root `README.md` file at the repository root serves as the main entry point
and navigation hub for the entire course. It is the **ONLY** file in the
repository that uses emojis (for section headings).

#### Structure Requirements:

1. **Title and Introduction**: Course name, license link, and welcome text
2. **🎯 Objectifs généraux**: High-level learning objectives for the entire
   course
3. **➡️ Par où commencer ?**: Quick start guide pointing to course modalities
4. **📅 Programme**: Table with course numbers and topics, each linking to
   detailed sections below
5. **🕐 Cours XX sections**: One section per course session with:
   - Clock emoji matching the course number (🕐, 🕑, 🕒, 🕓, 🕔, 🕕, 🕖, 🕗, 🕘,
     🕙, 🕚, 🕛)
   - Topic titles matching the titles from `XX.XX-topic/README.md` files
   - Ressources annexes from each module's `README.md` (supports de cours,
     presentations, exercises)

#### Important Notes:

- Clock emojis cycle through hours: 🕐 (1), 🕑 (2), 🕒 (3), 🕓 (4), 🕔 (5), 🕕
  (6), 🕖 (7), 🕗 (8), 🕘 (9), 🕙 (10), 🕚 (11), 🕛 (12)
- Each course section is a **summary** of the "Ressources annexes" from the
  corresponding `XX.XX-topic/README.md`
- Update the Programme table whenever new courses are added
- Emojis are **only allowed in the root README.md**, never in module or
  subfolder READMEs

### Module Root README Structure

Each `XX.XX-topic/README.md` file must follow this structure:

```markdown
# [Topic Title]

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Supports de cours : [Lien vers le contenu](./01-supports-de-cours/README.md) ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf)
- Exemples de code : [Lien vers le contenu](./02-exemples-de-code/) (if
  applicable)
- Exercices : [Lien vers le contenu](./03-exercices/README.md) (if applicable)

## Objectifs

[List of learning objectives from 01-supports-de-cours/README.md]

## Méthodes d'enseignement et d'apprentissage

Les méthodes d'enseignement et d'apprentissage utilisées pour animer le cours
sont les suivantes :

- Présentation magistrale.
- Discussions collectives.
- Travail en autonomie.

## Méthodes d'évaluation

L'évaluation prend la forme d'exercices à réaliser en autonomie en classe ou à
la maison.

L'évaluation se fait en utilisant les critères suivants :

- Capacité à s'approprier des exemples de code. (if examples exist)
- Capacité à appliquer les exemples de code à des situations similaires. (if
  examples exist)
- Capacité à répondre avec justesse.
- Capacité à argumenter.

Les retours se font de la manière suivante :

- Corrigé des exercices.

L'évaluation ne donne pas lieu à une note.

## À faire pour la semaine suivante

Chaque personne est libre de gérer son temps comme elle le souhaite. Cependant,
il est recommandé pour le cours suivant de :

- Relire les supports de cours si nécessaire.
- Finaliser l'appropriation des exemples de code qui n'ont pas été vus en
  classe. (if examples exist)
- Finaliser les exercices qui n'ont pas été terminés en classe.

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
```

### Module Evaluation Patterns

Modules can have different evaluation approaches:

**Standard modules** (with exercises):

- Capacité à s'approprier des exemples de code
- Capacité à appliquer les exemples de code à des situations similaires
- Capacité à répondre avec justesse
- Capacité à argumenter

**Introductory modules** (modalités):

- No formal evaluation

### "À faire pour la semaine suivante" Variations

**For modules with examples and exercises:**

```markdown
- Relire les supports de cours si nécessaire.
- Finaliser les exercices qui n'ont pas été terminés en classe.
```

**For introductory modules:**

```markdown
- Relire les supports de cours si nécessaire.
```

### Subfolder README Structure

Both `01-supports-de-cours/README.md` and `03-exercices/README.md` must include
a "Ressources annexes" section at the beginning with the following links:

- Link to parent folder objectives and evaluation methods
- Link to course materials README
- Link to web presentation
- Link to PDF presentation
- Link to code examples README (if applicable)
- Link to exercises README

Example format (adjust XX.XX and topic name):

```markdown
## Ressources annexes

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/) (if
  applicable)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)
```

### Code Examples README Structure

Each `02-exemples-de-code/README.md` must follow this structure:

```markdown
# [Topic Title] - Exemples de code

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

[Same resources section as exercises with proper links]

## Exemples de code

Ce dossier contient des exemples de code en lien avec les éléments vus en cours.

Ces exemples ont deux buts bien précis :

1. Vous familiariser à la lecture de code et sa compréhension de façon autonome.
2. Servir de base pour les exercices et les projets libres à réaliser.

Ces exemples sont construits pour être simples d'accès et facilement
compréhensibles. Ils sont à votre disposition pour vous aider à progresser dans
votre apprentissage.

Ces exemples sont triés par ordre de complexité croissante. Nous vous
conseillons de les explorer dans l'ordre et de prendre le temps de les exécuter
sur votre machine et de prendre le temps de les comprendre en profondeur
\*\*sans recourir à de l'aide externe (

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
```

### Exercise Solutions

- Solutions are integrated directly in the exercise README using `<details>`
  tags
- Each exercise should include a complete, working solution hidden by default
- Format:

  ````markdown
  <details>
  <summary>Solution</summary>

  ```java
  // Complete solution code here
  ```
  ````

  </details>
  ```

- Include explanatory notes after the solution code block when necessary

### URL Conventions

All web presentation and PDF links follow this pattern:

- Base: `https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/`
- Web: `{base}XX.XX-topic/01-supports-de-cours/index.html`
- PDF: `{base}XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf`

For project modules with parentheses in folder names, use URL-encoded or escaped
paths in Markdown:

- Folder: `01.03-projet-libre-(1-sur-8)/`
- URL: Use `<...>` brackets to handle special characters in Markdown links

### Repository Information

- **Repository**: HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course
- **GitHub Organization**: HEIG-VD-Prog-Course
- **Hosted URL Base**:
  https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/
- **License**: CC BY-SA 4.0
- **License URL**:
  https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

### Technical Specifications

- **Markdown**: Use Prettier formatting (80 character ruler)
- **Encoding**: UTF-8 with LF line endings
- **Marp Presentations**: Follow strict template structure

  - **Reference template**: All presentations MUST follow the exact structure in
    `00.00-template/01-supports-de-cours/PRESENTATION.md`
  - **Theme**: Use `.marp/theme.css` via `theme: custom-marp-theme` in
    frontmatter

  #### Frontmatter Structure (MANDATORY)

  ```markdown
  ---
  marp: true
  ---

  <!--
  theme: custom-marp-theme
  size: 16:9
  paginate: true
  author: V. Guidoux, avec l'aide de GitHub Copilot
  title: HEIG-VD ProgIM1 Course - [Topic]
  description: [Brief description] pour l'unité d'enseignement ProgIM1 enseigné à la HEIG-VD, Suisse
  url: https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/index.html
  header: "**[Topic]**"
  footer: '[**HEIG-VD**](https://heig-vd.ch) - [ProgIM1 2025-2026](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course) - [CC BY-SA 4.0](https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md)'
  headingDivider: 6
  math: mathjax
  -->
  ```

  **CRITICAL**:

  - Use `theme: custom-marp-theme` (NOT `theme: default`)
  - NEVER use `<style>` tag with `@import url('.marp/theme.css')`
  - Set `headingDivider: 6` to auto-create slides from `##` headings
  - Use `[license]` (NOT `[licence]`) for consistency

  #### Slide Separation (CRITICAL RULE)

  **NEVER use `---` to separate slides** after the frontmatter. The only `---`
  allowed are:

  1. Line 1: Opening frontmatter delimiter
  2. Line 3: Closing frontmatter delimiter

  All other slides are automatically created by `##` headings thanks to
  `headingDivider: 6`.

  ❌ **WRONG**:

  ```markdown
  ## Slide 1

  Content here

  ---

  ## Slide 2

  More content
  ```

  ✅ **CORRECT**:

  ```markdown
  ## Slide 1

  Content here

  ## Slide 2

  More content
  ```

  #### Required Sections (in order)

  1. **Title slide** with `_class: lead` and `_paginate: false`
  2. **"Retrouvez plus de détails"** section with `_class: lead`
  3. **Objectifs** starting with "À la fin de cette séance, vous devriez être
     capable de :" with `![bg right:40%][illustration-objectifs]`
  4. **Content sections** (as many `##` headings as needed)
  5. **"À vous de jouer !"** with standard bullets and
     `![bg right:40%][illustration-a-vous-de-jouer]`
  6. **Questions** with `_class: lead`
  7. **Sources** with illustration credits and all URL references

  #### Footer URL Structure (MANDATORY)

  All presentations must include these URL references at the end:

  ```markdown
  <!-- URLs -->

  [presentation-web]:
  	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/index.html
  [presentation-pdf]:
  	https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf
  [cours]:
  	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/XX.XX-topic/01-supports-de-cours
  [exercices]:
  	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/tree/main/XX.XX-topic/03-exercices
  [license]:
  	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md

  <!-- Illustrations -->

  [illustration-principale]: ./images/home.jpg
  [illustration-objectifs]:
  	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
  [illustration-a-vous-de-jouer]:
  	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
  ```

  **Replace `XX.XX-topic` with actual module folder name.**

  #### Common Mistakes to Avoid

  1. ❌ Using `theme: default` instead of `theme: custom-marp-theme`
  2. ❌ Adding `<style>` tag with `@import` (theme is already configured)
  3. ❌ Using `---` to separate slides (breaks with `headingDivider: 6`)
  4. ❌ Using `[licence]` instead of `[license]`
  5. ❌ Forgetting `![bg right:40%][illustration-objectifs]` on objectives slide
  6. ❌ Not including "À la fin de cette séance, vous devriez être capable de :"
  7. ❌ Using `<!-- _class: title -->` instead of proper lead structure
  8. ❌ Missing "Retrouvez plus de détails dans le support de cours" section
  9. ❌ Not creating `images/` folder with `home.jpg` placeholder

  #### Quiz Presentations (Special Format)

  For quiz/revision presentations, use the "Question/Answer" format:

  - Use `## Question X - Donnée` for the question slide
  - Use `## Question X - Réponse` for single-slide answers
  - Use `## Question X - Réponse (1/2)` and `## Question X - Réponse (2/2)` when
    the answer needs multiple slides

- **PlantUML**: Render using local server at http://localhost:9090
  - Generate diagrams manually using `./build-all-plantuml-diagram.sh` script

### Code Examples

- Use **Java** for all code examples
- Keep examples simple and relatable
- Prefer practical, everyday scenarios over abstract concepts
- Follow pedagogical progression from simple to complex
- **Use English for all code elements**: variable names, method names, class
  names, and parameter names must be in English, even when course content is in
  French
- Follow Java best practices and conventions (camelCase, proper access
  modifiers, etc.)
- Include proper package declarations and imports when relevant

### Individual Code Example Structure

Each individual example within `02-exemples-de-code/XX-example-name/` must
follow this structure:

#### README Format

Every code example must have a `README.md` that follows this pattern:

```markdown
# Exemple : [Example Title]

Cet exemple illustre [brief description] avec :

- [Feature/concept 1]
- [Feature/concept 2]
- [Feature/concept 3]
- [Additional features as needed]

[Optional: Additional notes about running, compiling, testing, etc.]
```

**Guidelines for README content:**

- Start with "Cet exemple illustre" followed by the main learning goal
- Use bullet points to list specific features demonstrated
- Keep descriptions concise and focused on what students will learn
- Add practical tips (e.g., how to compile, run, expected output) when relevant
- No emojis in code example READMEs

#### File Organization Patterns

**Simple Examples** (for basic concepts):

```
XX-example-name/
├── README.md
├── Main.java (or main entry point)
└── [OtherClass].java (as needed)
```

#### Code Example Best Practices

1. **Self-Contained**: Each example must be runnable independently without
   external dependencies (except JDK standard library and common build tools)

2. **Progressive Complexity**: Number examples in order of increasing complexity
   (`01-`, `02-`, `03-`, etc.)

3. **Functional Code**: Examples must work out-of-the-box when students compile
   and run them. Include clear instructions for compilation/execution in README

4. **Educational Comments**:

   - Add Javadoc comments for classes and public methods
   - Use inline comments in French to explain complex logic or pedagogical
     points
   - Reference Java documentation when introducing new APIs
   - Example:
     `// Documentation : https://docs.oracle.com/en/java/javase/17/docs/api/`

5. **Modern Java Standards**:

   - Use recent Java features appropriate to the course level (Java 11+)
   - Follow proper encapsulation (private fields, public methods)
   - Use meaningful variable names that reflect purpose
   - Apply proper access modifiers (private, protected, public)
   - Use interfaces and abstract classes when demonstrating OOP concepts
   - Leverage collections framework appropriately
   - Use try-with-resources for resource management

6. **Java Naming Conventions**:

   - Classes: PascalCase (`UserManager`, `BankAccount`)
   - Methods/variables: camelCase (`calculateTotal`, `firstName`)
   - Constants: UPPER_SNAKE_CASE (`MAX_SIZE`, `DEFAULT_VALUE`)
   - Packages: lowercase (`com.example.algorithms`, `models`)

7. **Code Structure**:

   - Include proper package declarations
   - Import only necessary classes (avoid wildcards unless pedagogically
     relevant)
   - One public class per file
   - Organize methods logically (constructors, public methods, private methods)
   - Keep methods focused and reasonably sized

8. **Documentation Standards**:

   - Include Javadoc for all public classes and methods
   - Use `@param`, `@return`, `@throws` tags appropriately
   - Explain the "why" in comments, not just the "what"
   - Example:
     ```java
     /**
      * Calcule le montant total avec la TVA appliquée.
      *
      * @param amount le montant de base avant TVA
      * @param taxRate le taux de TVA (0.077 pour 7.7%)
      * @return le montant total incluant la TVA
      */
     public double calculateWithTax(double amount, double taxRate) {
         return amount * (1 + taxRate);
     }
     ```

9. **Real-World Scenarios**: Use relatable examples:

   - Bank account management
   - Student grade systems
   - Library book management
   - E-commerce shopping carts
   - Task/Todo managers
   - Game scores and leaderboards
   - Event calendars
   - Contact directories

10. **Input/Output Patterns**:

    - Use `System.out.println()` for simple output demonstrations
    - Use `Scanner` for console input when needed
    - Format output clearly for students to understand results
    - Example:
      ```java
      System.out.println("=== Résultats ===");
      System.out.printf("Montant total: %.2f CHF%n", total);
      ```

11. **Error Handling**:

    - Demonstrate proper exception handling where relevant
    - Use checked exceptions for recoverable errors
    - Use unchecked exceptions for programming errors
    - Always clean up resources properly
    - Example:
      ```java
      try {
          // Operation risquée
      } catch (IOException e) {
          System.err.println("Erreur lors de la lecture: " + e.getMessage());
      }
      ```

12. **Main Method Pattern**:

    ```java
    public class Main {
        public static void main(String[] args) {
            System.out.println("=== Exemple : [Title] ===\n");

            // Démonstration du concept
            demonstrateConcept();

            System.out.println("\n=== Fin de l'exemple ===");
        }

        private static void demonstrateConcept() {
            // Implementation
        }
    }
    ```

13. **Testing Demonstrations** (when relevant):

    - Include simple test cases to verify behavior
    - Show assert statements for validation
    - Demonstrate edge cases
    - Example:
      ```java
      // Test avec différentes valeurs
      assert calculator.add(2, 3) == 5 : "Addition simple échouée";
      assert calculator.divide(10, 0) throws ArithmeticException : "Division par zéro non gérée";
      ```

14. **Build Instructions in README**: Always include compilation and execution
    instructions:

    ````markdown
    ## Compilation et exécution

    ### Sans package

    ```bash
    javac Main.java
    java Main
    ```
    ````

#### Naming Conventions for Examples

- Use descriptive folder names with hyphens: `01-classe-simple`,
  `02-heritage-et-polymorphisme`
- Start with a number to indicate order
- Use French for folder names (aligning with course language)
- Be specific about what the example demonstrates
- Examples:
  - `01-variables-et-types`
  - `02-structures-de-controle`
  - `03-tableaux-et-collections`
  - `04-programmation-orientee-objet`
  - `05-interfaces-et-abstraction`
  - `06-gestion-des-exceptions`
  - `07-fichiers-et-serialisation`

#### What NOT to Include

- No complex build processes, even Maven/Gradle basics
- No heavy frameworks (Spring, JavaFX, etc.)
- No excessive abstractions that obscure learning objectives
- No deprecated Java features (avoid `Vector`, `Hashtable`, etc.)
- No GUI code
- No database connections in early examples (keep them simple)
- No external libraries unless absolutely necessary for the concept

### When Editing

- Maintain consistent formatting across all markdown files
- Ensure PlantUML diagrams follow the same style patterns
- Keep exercises aligned with course material in corresponding support files
- Preserve the educational tone and accessibility of the content
- Always verify that all cross-references and links are correct
- Update the Programme table in root README when adding new course modules
- Ensure all "Ressources annexes" sections are complete and accurate
