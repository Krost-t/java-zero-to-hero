# ✨ Hello World Plus

**Print custom messages with style and formatting**

Hello World Plus is a Java command-line application that allows you to print custom messages with **colours**, **styles**, and **coloured backgrounds** in the terminal using ANSI codes.

---

## 🚀 Project Goal

This project extends the traditional *Hello World* programme by adding:

- 🎨 Text colours  
- 🖌 Background colours  
- ✨ Visual styles (italic, underline, blinking, etc.)  
- 🔄 Automatic style reset after each word  

---

## 📦 How It Works

Each argument passed to the programme must follow this format:

```bash
KEY.Message
```


The programme:

1. Splits the key and the message using the `.` character  
2. Checks whether the key matches:
   - a text colour  
   - a background colour  
   - a text style  
3. Applies the corresponding ANSI code  
4. Resets the style after printing  

---

## 🎨 Available Text Colours

| Key | Effect |
|------|--------|
| `R_Black` | Black |
| `R_Red` | Red |
| `R_Green` | Green |
| `R_Yellow` | Yellow |
| `R_Blue` | Blue |
| `R_Purple` | Purple |
| `R_Cyan` | Cyan |
| `R_White` | White |

---

## 🖌 Available Background Colours

| Key | Effect |
|------|--------|
| `BG_Black` | Black background |
| `BG_Red` | Red background |
| `BG_Green` | Green background |
| `BG_Yellow` | Yellow background |
| `BG_Blue` | Blue background |
| `BG_Purple` | Purple background |
| `BG_Cyan` | Cyan background |
| `BG_White` | White background |

---

## ✨ Available Styles

| Key | Effect |
|------|--------|
| `ITALIC` | Italic |
| `UNDERLINE` | Underline |
| `BLINK` | Blinking |
| `RAPID_BLINK` | Rapid blinking |
| `REVERSE_VIDEO` | Reverse colours |
| `INVISIBLE_TEXT` | Invisible text |

---

## 🛠 Installation & Compilation

### Compile

```bash
javac App.java
```

### Run

```bash
java App R_Green.Hello UNDERLINE.World BG_Blue.Plus
```

## 🧪 Example

```bash
java App R_Red.Error BG_Yellow.Warning ITALIC.Note
```

## 🧠 Code Structure

The programme is based on:

* textColour(String colour) → returns the ANSI code for text colour

* bgColour(String colour) → returns the ANSI code for background colour

* textStyle(String text) → returns the ANSI code for style

* resetColour() → resets the terminal style

Each method uses a HashMap to associate a key with an ANSI code.