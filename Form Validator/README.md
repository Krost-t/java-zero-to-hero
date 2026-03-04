# ✅ Form Validator

**Validate user input fields from the console**

Form Validator is a Java console application that simulates a basic form and validates each field using **regular expressions**. The programme keeps asking until the input matches the required format, then prints a summary at the end.

---

## 🚀 Project Goal

This project is designed to practice:

- Using **`Scanner`** for interactive input
- Validating strings with **`Pattern`** and **regex**
- Building reusable validation helpers (`isValid`, `askUntilValid`)
- Control flow with **`do/while`** loops and user feedback

---

## 📦 How It Works

When you run the programme, it asks for:

1. **Name**
2. **Surname**
3. **Date of birth** (`dd/mm/yyyy`)
4. **Email**
5. **Password**

For each field, the programme:

- Prints a prompt
- Reads user input
- Checks it against a regex pattern
- Prints an error message if invalid
- Repeats until valid, then prints `Valid!`

At the end, it prints `FORM COMPLETED SUCCESSFULLY` and echoes all collected values.

---

## ✅ Validation Rules

| Field | Rule (simplified) | Regex used |
|------|--------------------|-----------|
| Name / Surname | Letters only | `^[a-zA-Z]+$` |
| Date of birth | Format only: `dd/mm/yyyy` | `^\\d{2}/\\d{2}/\\d{4}$` |
| Email | Basic email format | `^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$` |
| Password | 8+ chars, 1 uppercase, 1 lowercase, 1 digit | `^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$` |

Notes:

- The date validation checks the **format only** (e.g. it does not reject `99/99/0000`).
- The password is displayed in the final recap (fine for learning, not for real apps).

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
==== FORM VALIDATOR ====

Enter your name: John1
Only letters allowed.
Enter your name: John
Valid!

Enter your surname: Doe
Valid!

Enter your date of birth (dd/mm/yyyy): 2000-01-01
Date must be in format dd/mm/yyyy.
Enter your date of birth (dd/mm/yyyy): 01/01/2000
Valid!

Enter your email: john@invalid
Invalid email format.
Enter your email: john.doe@example.com
Valid!

Enter your password: password
Password must contain 8+ chars, 1 uppercase, 1 lowercase, 1 digit.
Enter your password: Password1
Valid!

===== FORM COMPLETED SUCCESSFULLY =====
Name: John
Surname: Doe
Date of birth: 01/01/2000
Email: john.doe@example.com
Password: Password1
```

---

## 🧠 Code Structure

The programme is based on:

- `Pattern NAME / EMAIL / DATE / PASSWORD` → Regex rules for each field
- `isValid(String, Pattern)` → Returns whether an input matches a regex
- `askUntilValid(Scanner, message, pattern, errorMessage)` → Prompts until the input is valid
- `main(String[])` → Runs the interactive form flow and prints the final recap
