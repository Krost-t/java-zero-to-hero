# 🔤 Character Counter

**Count the number of characters in a given text**

Character Counter is a very simple Java command-line application that takes a text as input and prints the **total number of characters** it contains.

---

## 🚀 Project Goal

This project reinforces:

- **Command-line arguments** handling in Java  
- Use of the **`String.length()`** method  
- Basic **input validation** (presence of at least one argument)

---

## 📦 How It Works

The programme expects **one argument**: the text whose length you want to measure.

```bash
java App "your text here"
```

The programme:

1. Reads the first argument `args[0]`  
2. Uses the `length()` method to get the number of characters  
3. Displays the size in the console

If no argument is provided, you can extend the programme to display a usage message (e.g. `Please provide a text as argument`).

---

## 🛠 Installation & Compilation

### Compile

```bash
javac src/App.java
```

### Run

```bash
java -cp src App "Hello World"
```

---

## 🧪 Examples

```bash
java -cp src App "Hello"
# With length function : the string of characters is of size 5

java -cp src App "Java Zero To Hero"
# With length function : the string of characters is of size 18
```

---

## 🧠 Code Structure

The programme is based on:

- `main(String[] args)` → Reads the first command-line argument and prints its length using `args[0].length()`.

