# GitHub Copilot Instructions

This repository contains teaching materials for a programming course
(HEIG-VD-ProgIM-Course).

## Context

- **Language**: Course materials are primarily in French
- **Target Audience**: Students with prior programming experience, learning
  advanced Java and algorithmic concepts
- **Content Type**: Educational presentations (Marp), code examples, exercises,
  and PlantUML diagrams
- **Level**: Intermediate - builds upon programming foundations
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

- Capacité à répondre avec justesse.
- Capacité à argumenter.

Les retours se font de la manière suivante :

- Corrigé des exercices.

L'évaluation ne donne pas lieu à une note.

## À faire pour la semaine suivante

Chaque personne est libre de gérer son temps comme elle le souhaite. Cependant,
il est recommandé pour le cours suivant de :

- Relire les supports de cours si nécessaire.
- Finaliser les exercices qui n'ont pas été terminés en classe.

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
```

### Module Evaluation Patterns

Modules can have different evaluation approaches:

**Standard modules** (with exercises):

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
sur votre machine et de prendre le temps de les comprendre en profondeur **sans
recourir à de l'aide externe (

[licence]:
	https://github.com/HEIG-VD-Prog-Course/HEIG-VD-ProgIM-Course/blob/main/LICENSE.md
```

### Exercise Solutions

- Each exercise solution must be in a `solution-exercice-XX/` subfolder
- Solutions should include a complete, working implementation
- Reference solutions in the exercise README:
  `Une solution possible est disponible dans le dossier [\`solution-exercice-01\`](./solution-exercice-01/)`

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
- **Marp Presentations**: Use `.marp/theme.css` for styling
  - **Structure**: All presentations must follow the template structure in
    `00.00-template/01-supports-de-cours/PRESENTATION.md`
  - **Slide separation**: NEVER use `---` to separate slides, only use headings
    (`##`)
  - **Consistent sections**: Include title slide, objectives, content, "À vous
    de jouer !", questions, and sources sections
  - **When creating/editing**: Keep the template structure and only modify
    content and update URLs/links
  - **Quiz presentations**: For quiz/revision presentations, use the
    "Question/Answer" format:
    - Use `## Question X - Donnée` for the question slide
    - Use `## Question X - Réponse` for single-slide answers
    - Use `## Question X - Réponse (1/2)` and `## Question X - Réponse (2/2)`
      when the answer needs multiple slides (even if content could fit on one
      slide, always indicate pagination explicitly)
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

### When Editing

- Maintain consistent formatting across all markdown files
- Ensure PlantUML diagrams follow the same style patterns
- Keep exercises aligned with course material in corresponding support files
- Preserve the educational tone and accessibility of the content
- Always verify that all cross-references and links are correct
- Update the Programme table in root README when adding new course modules
- Ensure all "Ressources annexes" sections are complete and accurate
