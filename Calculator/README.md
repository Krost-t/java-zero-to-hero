# 🧮 Calculator

**Evaluate mathematical expressions from the command line**

Calculator is a Java command-line application that evaluates mathematical expressions with support for **basic operations**, **parentheses**, **operator precedence**, and the **Shunting Yard algorithm** for correct parsing.

---

## 🚀 Project Goal

This project provides a calculator that:

- ➕ Addition (`+`)
- ➖ Subtraction (`-`)
- ✖️ Multiplication (`*`)
- ➗ Division (`/`)
- 📊 Modulo (`%`)
- 🔢 Power (`^`)
- 📐 Parentheses and brackets (`()`, `[]`)
- 🧠 Correct operator precedence (PEMDAS)

---

## 📦 How It Works

The programme takes a single argument: a mathematical expression as a string.

```bash
java App "expression"
```

The programme:

1. **Validates** the expression (numbers, operators, parentheses only)
2. **Normalises** the input (brackets → parentheses, implicit multiplication)
3. **Converts** infix to postfix using the **Shunting Yard algorithm**
4. **Evaluates** the postfix expression and displays the result

---

## 🔢 Supported Operators

| Operator | Symbol | Priority | Example |
|----------|--------|----------|---------|
| Power | `^` | 3 (highest) | `2^3` → 8 |
| Multiplication | `*` | 2 | `3*4` → 12 |
| Division | `/` | 2 | `10/2` → 5 |
| Modulo | `%` | 2 | `10%3` → 1 |
| Addition | `+` | 1 | `2+3` → 5 |
| Subtraction | `-` | 1 | `5-2` → 3 |

---

## 📐 Valid Expression Format

The expression may contain:

- **Digits** and decimal numbers (e.g. `3.14`)
- **Operators**: `+`, `-`, `*`, `/`, `%`, `^`
- **Parentheses**: `()` or `[]` (brackets are converted to parentheses)
- **Spaces** (ignored)
- **Implicit multiplication**: `2(3+4)` is interpreted as `2*(3+4)`

---

## 🛠 Installation & Compilation

### Compile

```bash
javac src/App.java
```

### Run

```bash
java -cp src App "2 + 3 * 4"
```

---

## 🧪 Examples

```bash
# Basic operations
java -cp src App "5 + 3"
# Result: 8.0

# Operator precedence
java -cp src App "2 + 3 * 4"
# Result: 14.0

# Parentheses
java -cp src App "(2 + 3) * 4"
# Result: 20.0

# Power
java -cp src App "2^10"
# Result: 1024.0

# Complex expression
java -cp src App "10 % 3 + 2^3 * 2"
# Result: 18.0
```

---

## 🧠 Code Structure

The programme is based on:

| Method / Element | Role |
|------------------|------|
| `isOperation(String)` | Validates that the expression contains only allowed characters |
| `Priority` (enum) | Associates each operator with its symbol and precedence level |
| `calculs(String)` | Main logic: normalisation → Shunting Yard → postfix evaluation |
| `main(String[])` | Entry point: checks arguments and displays the result |

### Algorithm: Shunting Yard

The **Shunting Yard algorithm** (Dijkstra) converts an infix expression (e.g. `2 + 3 * 4`) into postfix notation (Reverse Polish Notation), which is then evaluated using a stack. This ensures correct handling of operator precedence and parentheses.

---
