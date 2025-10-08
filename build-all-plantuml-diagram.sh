#!/usr/bin/env sh

## Variables
WORKDIR=$(pwd)
PLANTUML_DOCKER_IMAGE="plantuml/plantuml:1.2025"
PLANTUML_CMD="docker run --rm --volume=\"$WORKDIR\":/workspace --user $(id -u):$(id -g) $PLANTUML_DOCKER_IMAGE"

# Convert diagrams
echo "Converting diagrams to PNG files..."
eval "$PLANTUML_CMD -tpng -nbthread auto -nometadata -progress /workspace/**/*.plantuml"

# Optimize PNG files
echo "Optimizing PNG files..."
find . -type f -name "*.plantuml" -exec sh -c 'optipng "${0%.plantuml}.png"' {} \;

echo "All diagrams processed successfully!"
