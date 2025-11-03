# GitHub Copilot Instructions

This repository contains teaching materials for a programming course
(HEIG-VD-ProgIM-Course).

## Context

- **Language**: Course materials are primarily in French
- **Target Audience**: Complete beginners in programming, learning Java and
  algorithms from scratch
- **Content Type**: Educational presentations (Marp), exercises, and PlantUML
  diagrams
- **Level**: Introductory - assume no prior programming knowledge

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
   appropriate for beginners
4. **No Emojis**: Never use emojis in any course materials, presentations, or
   exercises
5. **Encourage exploration**: Guide students toward solutions without giving
   direct answers - "teach them to fish"
6. **Real-world relevance**: Prefer practical, industry-relevant examples over
   purely academic ones
7. **Respect student freedom**: Support diverse approaches and personal projects
   that engage students

### File Structure

- `XX.XX-topic/` folders contain course modules
- `01-supports-de-cours/` contains presentation materials (PRESENTATION.md using
  Marp)
- `02-exercices/` contains exercises
- PlantUML diagrams are in `images/` folders with `.plantuml` extension. They
  are generated manually using the `./build-all-plantuml-diagram.sh` script.

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
- Exercices : [Lien vers le contenu](./02-exercices/README.md)

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

### Subfolder README Structure

Both `01-supports-de-cours/README.md` and `02-exercices/README.md` must include
a "Ressources" section at the beginning with the following links:

- Link to parent folder objectives and evaluation methods
- Link to course materials README
- Link to web presentation
- Link to PDF presentation
- Link to exercises README

Example format (adjust XX.XX and topic name):

```markdown
## Ressources

- Objectifs, méthodes d'enseignement et d'apprentissage, et méthodes
  d'évaluation : [Lien vers le contenu](..)
- Supports de cours : [Lien vers le contenu](../01-supports-de-cours/README.md)
  ·
  [Presentation (web)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/index.html)
  ·
  [Presentation (PDF)](https://HEIG-VD-Prog-Course.github.io/HEIG-VD-ProgIM-Course/XX.XX-topic/01-supports-de-cours/XX.XX-topic-presentation.pdf)
- Exercices : [Lien vers le contenu](../02-exercices/README.md)
```

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

### Code Examples

- Use Java for code examples
- Keep examples simple and relatable
- Prefer practical, everyday scenarios over abstract concepts
- Follow pedagogical progression from simple to complex
- **Use English for all code elements**: variable names, method names, class
  names, and parameter names must be in English, even when course content is in
  French

### When Editing

- Maintain consistent formatting across all markdown files
- Ensure PlantUML diagrams follow the same style patterns
- Keep exercises aligned with course material in corresponding support files
- Preserve the educational tone and accessibility of the content
