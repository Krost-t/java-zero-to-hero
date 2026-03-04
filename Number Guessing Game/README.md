# 🎯 Number Guessing Game

**Guess the secret number with limited attempts and progressive hints**

Number Guessing Game is an interactive Java console game where the computer randomly chooses a secret number and you must guess it in a limited number of tries, with **textual hints** guiding you.

---

## 🚀 Project Goal

This project practices:

- Using **`Scanner`** to read user input  
- Generating random numbers with **`ThreadLocalRandom`**  
- Control flow with **loops** and **conditions**  
- Designing a simple **game loop** and user feedback

---

## 📦 How It Works

At the start of the game:

- The programme generates a random integer **between -100 and 100**  
- You have **10 attempts** to find it  
- After each guess, you receive a **hint**:
  - "Much too high!"  
  - "Too high!"  
  - "Much too low!"  
  - "Too low!"  
  - "Close!"

If you guess correctly, the game ends with a **congratulatory message**.  
If you fail after all attempts, the game reveals the **secret number**.

---

## 🛠 Installation & Compilation

### Compile

```bash
javac src/App.java
```

### Run

```bash
java -cp src App
```

---

## 🧪 Example Session

```text
Welcome to the Guess Game!
You have 10 chances to find the secret number between -100 and 100.
After each guess, you'll get a hint to help you.

Attempt 1 / 10
Enter your guess: 50
 X Too high!
Chances left: 9

Attempt 2 / 10
Enter your guess: 10
 X Close!
Chances left: 8
...
```

---

## 🧠 Code Structure

The programme is based on:

- `ThreadLocalRandom.current().nextInt(-100, 100 + 1)` → Generates the secret number  
- A `for` loop from 1 to 10 → Manages the attempts  
- Comparison between `guess` and `secretNumber` → Produces hints based on the difference (`diff`)  
- `Scanner` → Reads user input from the console  

