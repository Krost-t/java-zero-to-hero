# 🔁 Unit Converter

**Convert values between different units (distance, weight, volume, currency)**  

Unit Converter is a Java console application that lets you convert a numerical value from one unit to another within a given **category** (distance, weight, volume, or currency) using a simple text-based menu.

---

## 🚀 Project Goal

This project is designed to practice:

- Using **`Scanner`** for user input  
- Managing options with **menus and `switch`**  
- Storing conversion factors in a **`HashMap<String, Double>`**  
- Converting values by using a **common base unit**

---

## 📦 How It Works

When you run the programme:

1. It displays a list of categories:
   - `1. Distance`
   - `2. Weight`
   - `3. Volume`
   - `4. Currency`
2. You select a **conversion type** by entering its number  
3. You enter the **value** to convert  
4. The programme builds a `HashMap` of units and their **relative factor** to a base unit  
5. You choose:
   - the **source unit** (`fromUnit`)
   - the **target unit** (`toUnit`)
6. It converts the value and prints the result.

If you choose an invalid type or unit, the programme prints an **error message**.

---

## 🌐 Supported Categories & Units

### 1. Distance

- `m` → metre (base unit)  
- `km` → kilometre (`1 km = 1000 m`)  
- `mi` → mile (`1 mi = 1609.34 m`)  

### 2. Weight

- `kg` → kilogram (base unit)  
- `g` → gram (`1 g = 0.001 kg`)  
- `lb` → pound (`1 lb ≈ 0.453592 kg`)  

### 3. Volume

- `l` → litre (base unit)  
- `ml` → millilitre (`1 ml = 0.001 l`)  
- `gal` → US gallon (`1 gal ≈ 3.78541 l`)  

### 4. Currency (example rates)

- `EUR` → base currency  
- `USD` → `1 EUR ≈ 1.1 USD`  
- `GBP` → `1 EUR ≈ 0.88 GBP`  
- `CNY` → `1 EUR ≈ 7.2 CNY`  

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

## 🧪 Examples

```text
Welcome to the Unit Converter!
1. Distance
2. Weight
3. Volume
4. Currency
Choose the type of conversion: 1
Enter the value to convert: 5
Available units: [m, km, mi]
From unit: km
To unit: m
5.0 km = 5000.0 m
```

```text
Choose the type of conversion: 4
Enter the value to convert: 10
Available units: [EUR, USD, GBP, CNY]
From unit: EUR
To unit: USD
10.0 EUR = 11.0 USD
```

---

## 🧠 Code Structure

The programme is based on:

- `String[] categories` → Lists all conversion categories  
- `HashMap<String, Double> units` → Maps each unit to a factor relative to a base unit  
- A `switch (type)` → Fills the map according to the chosen category  
- Conversion logic:
  - `baseValue = value * units.get(fromUnit)`  
  - `convertedValue = baseValue / units.get(toUnit)`  
- `Scanner` → Reads numeric and string inputs from the user  

