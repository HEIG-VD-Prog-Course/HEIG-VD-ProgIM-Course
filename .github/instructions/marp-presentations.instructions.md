---
name: Marp-Presentations
description: Guidelines for creating and editing Marp slide presentations
applyTo: "**/PRESENTATION.md"
---

# Marp Presentation Guidelines

All presentations MUST follow the exact structure in
`00.00-template/01-supports-de-cours/PRESENTATION.md`.

## Frontmatter Structure (MANDATORY)

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
- NEVER use `:` in value without quotes
- Set `headingDivider: 6` to auto-create slides from `##` headings
- Use `[license]` (NOT `[licence]`) for consistency

## Slide Separation (CRITICAL RULE)

**NEVER use `---` to separate slides** after the frontmatter. The only `---`
allowed are:

1. Line 1: Opening frontmatter delimiter
2. Line 3: Closing frontmatter delimiter

All other slides are automatically created by `##` headings thanks to
`headingDivider: 6`.

❌ **WRONG**:

```markdown
## Slide 1

## Content here

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

## Required Sections (in order)

1. **Title slide** with `_class: lead` and `_paginate: false`
2. **"Retrouvez plus de détails"** section with `_class: lead`
3. **Objectifs** starting with "À la fin de cette séance, vous devriez être
   capable de :" with `![bg right:40%][illustration-objectifs]`
4. **Content sections** (as many `##` headings as needed)
5. **"À vous de jouer !"** with standard bullets and
   `![bg right:40%][illustration-a-vous-de-jouer]`
6. **Questions** with `_class: lead`
7. **Sources** with illustration credits and all URL references

## Footer URL Structure (MANDATORY)

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

Replace `XX.XX-topic` with actual module folder name.

## Slide Content Density Guidelines

**When to split a slide into multiple parts:**

- **Text-heavy slides**: If explanatory text exceeds ~150 words (excluding code)
- **Mixed content**: When combining significant text (>100 words) AND code
  examples
- **Long lists**: When bullet point lists exceed 8-10 items
- **Multiple code blocks**: When showing 2+ substantial code examples (>10 lines
  each)
- **Complex explanations**: When explaining 4+ distinct concepts on one slide

**Multi-part slide format:**

```markdown
## Title (1/n)

[First part of content]

## Title (2/n)

[Second part of content]
```

**Splitting strategies:**

- **Text + Code**: Put explanatory text on (1/2), code example on (2/2)
- **Long lists**: Group related items (e.g., 3-4 items per slide)
- **Before/After examples**: Split into separate slides with clear labels
- **Definitions**: One concept per slide when explaining vocabulary

## Quiz Presentations (Special Format)

For quiz/revision presentations, use the "Question/Answer" format:

- Use `## Question X - Donnée` for the question slide
- Use `## Question X - Réponse` for single-slide answers
- Use `## Question X - Réponse (1/2)` and `## Question X - Réponse (2/2)` when
  the answer needs multiple slides

## Common Mistakes to Avoid

1. ❌ Using `theme: default` instead of `theme: custom-marp-theme`
2. ❌ Adding `<style>` tag with `@import` (theme is already configured)
3. ❌ Using `---` to separate slides (breaks with `headingDivider: 6`)
4. ❌ Using `[licence]` instead of `[license]`
5. ❌ Forgetting `![bg right:40%][illustration-objectifs]` on objectives slide
6. ❌ Not including "À la fin de cette séance, vous devriez être capable de :"
7. ❌ Using `<!-- _class: title -->` instead of proper lead structure
8. ❌ Missing "Retrouvez plus de détails dans le support de cours" section
9. ❌ Not creating `images/` folder with `home.jpg` placeholder

## Technical Specifications

- **Markdown**: Use Prettier formatting (80 character ruler)
- **Encoding**: UTF-8 with LF line endings
- **Theme**: Use `.marp/theme.css` via `theme: custom-marp-theme` in frontmatter
