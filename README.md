# Farey Sequence Explorer

A sophisticated interactive visualization engine for exploring the mathematical beauty of Farey sequences through real-time generative graphics and computational number theory.

## Overview

The Farey Sequence Explorer is a high-performance web application that transforms abstract number theory into immersive visual experiences. Built with vanilla JavaScript and HTML5 Canvas, this project demonstrates advanced mathematical visualization techniques, particle systems, and interactive data representation without external dependencies.

## Mathematical Foundation

The Farey sequence of order n is the sequence of completely reduced fractions between 0 and 1 which, when in lowest terms, have denominators less than or equal to n, arranged in order of increasing size.

### Key Properties

- **Cardinality**: |Fₙ| = 1 + Σφ(k) for k = 1 to n, where φ is Euler's totient function
- **Bounds**: Every sequence starts with 0/1 and terminates with 1/1
- **Mediant Property**: For neighbors a/b < c/d in Fₙ, their mediant (a+c)/(b+d) appears in F_{b+d}
- **Adjacency Condition**: Neighbors satisfy bc - ad = 1 (unimodular condition)

## Technical Architecture

### Core Algorithms

```javascript
// Euclidean algorithm for GCD computation
function gcd(a, b) {
    while (b !== 0) {
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// Farey sequence generation with O(n² log n) complexity
function generateFarey(n) {
    const sequence = [];
    for (let b = 1; b <= n; b++) {
        for (let a = 0; a <= b; a++) {
            if (gcd(a, b) === 1) {
                sequence.push({ num: a, den: b, val: a / b });
            }
        }
    }
    sequence.sort((a, b) => a.val - b.val);
    return sequence;
}
```

### Rendering Pipeline

1. **Background Layer**: Particle system with force-directed interactions and proximity-based edge rendering
2. **Visualization Layer**: HTML5 Canvas with radial gradients, dynamic scaling, and coordinate mapping
3. **UI Layer**: CSS Grid layout with glassmorphism effects and hardware-accelerated animations

### Performance Optimizations

- RequestAnimationFrame for 60fps rendering
- Debounced input handling for slider interactions
- Lazy computation with loading states for n > 30
- Spatial indexing for hover detection on visualization canvas

## Features

### Interactive Controls

- **Order Slider**: Dynamic range 1-50 with real-time sequence regeneration
- **Generate Button**: Trigger manual recomputation with visual feedback
- **Hover Interactions**: Tooltip system displaying fraction values and decimal approximations

### Visualization Modes

- **Number Line Projection**: Fractions mapped to [0,1] interval with denominator-based vertical positioning
- **Statistical Dashboard**: Live computation of sequence length, mediant values, and maximum denominators
- **Tag Cloud Display**: Scrollable fraction grid with hover animations

### Visual Effects

- Particle network background with mouse-repulsion physics
- Glassmorphism UI panels with dynamic border gradients
- Pulsing animations and chromatic aberration on title elements
- Responsive design adapting to viewport dimensions

## Browser Compatibility

- Chrome 80+
- Firefox 75+
- Safari 13+
- Edge 80+

Requires ES6+ support and CSS Grid/Flexbox capabilities.

## Usage

1. Open `index.html` in a modern web browser
2. Adjust the order slider to generate sequences of different complexity
3. Hover over visualization points to inspect specific fractions
4. Observe statistical properties updating in real-time

## Mathematical Extensions

The codebase includes implementations of:

- Euler's totient function for sequence length prediction
- Mediant computation for neighbor analysis
- Farey rank algorithms (commented in source for future implementation)

## License

MIT License - Feel free to extend, modify, or integrate into educational platforms.

## Author - Jordan Leturgez

Built with precision for the mathematics and visualization community.
```
