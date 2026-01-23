---
name: Module-Structure
description: Guidelines for module organization and README structure
applyTo: "**/README.md"
---

# Module Structure Guidelines

## File Structure

- `XX.XX-topic/` folders contain course modules
- `01-supports-de-cours/` contains:
  - `README.md`: Complete, self-contained course material with all theoretical
    content needed to achieve learning objectives
  - `PRESENTATION.md`: Marp slides that introduce and motivate the topic (not
    meant to be exhaustive)
  - `images/`: PlantUML diagrams (`.plantuml` extension) and illustrations
- `02-exemples-de-code/` contains runnable code examples (when applicable)
- `03-exercices/` contains exercises (when applicable)

**Important**: The `README.md` in `01-supports-de-cours/` must be comprehensive
enough for students to learn independently without requiring external resources.

## Root README Structure

The root `README.md` file at the repository root serves as the main entry point
and navigation hub for the entire course. It is the **ONLY** file in the
repository that uses emojis (for section headings).

### Structure Requirements:

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

**Important Notes:**

- Clock emojis cycle through hours: 🕐 (1), 🕑 (2), 🕒 (3), 🕓 (4), 🕔 (5), 🕕
  (6), 🕖 (7), 🕗 (8), 🕘 (9), 🕙 (10), 🕚 (11), 🕛 (12)
- Each course section is a **summary** of the "Ressources annexes" from the
  corresponding `XX.XX-topic/README.md`
- Update the Programme table whenever new courses are added
- Emojis are **only allowed in the root README.md**, never in module or
  subfolder READMEs

## Module Root README Structure

Each `XX.XX-topic/README.md` file must follow this structure:

```markdown
# [Topic Title]

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Ressources annexes

- Supports de cours : [Lien vers le contenu](./01-supports-de-cours/README.md) ·
  [Presentation (web)](https://heig-vd-progim-course.github.io/heig-vd-progim1-course/XX.XX-topic/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://heig-vd-progim-course.github.io/heig-vd-progim1-course/XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf)
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
	https://github.com/HEIG-VD-Prog-Course/heig-vd-progim1-course/blob/main/LICENSE.md
```

## Module Evaluation Patterns

**Standard modules** (with exercises):

- Capacité à s'approprier des exemples de code
- Capacité à appliquer les exemples de code à des situations similaires
- Capacité à répondre avec justesse
- Capacité à argumenter

**Introductory modules** (modalités):

- No formal evaluation

## "À faire pour la semaine suivante" Variations

**For modules with examples and exercises:**

```markdown
- Relire les supports de cours si nécessaire.
- Finaliser les exercices qui n'ont pas été terminés en classe.
```

**For introductory modules:**

```markdown
- Relire les supports de cours si nécessaire.
```

## Subfolder README Structure

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
  [Presentation (web)](https://heig-vd-progim-course.github.io/heig-vd-progim1-course/XX.XX-topic/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://heig-vd-progim-course.github.io/heig-vd-progim1-course/XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf)
- Exemples de code : [Lien vers le contenu](../02-exemples-de-code/) (if
  applicable)
- Exercices : [Lien vers le contenu](../03-exercices/README.md)
```

## Code Examples README Structure

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
sur votre machine et de prendre le temps de les comprendre en profondeur **sans
recourir à de l'aide externe**.

[licence]:
	https://github.com/HEIG-VD-Prog-Course/heig-vd-progim1-course/blob/main/LICENSE.md
```

## Exercise Solutions

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

</details>
````

- Include explanatory notes after the solution code block when necessary
