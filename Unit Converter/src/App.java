import java.util.Scanner;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] categories = {"Distance", "Weight", "Volume", "Currency"};
        System.out.println("Welcome to the Unit Converter!");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }

        System.out.print("Choose the type of conversion: ");
        int type = scanner.nextInt();

        System.out.print("Enter the value to convert: ");
        double value = scanner.nextDouble();

        HashMap<String, Double> units = new HashMap<>();
        switch (type) {
            case 1:
                units.put("m", 1.0);
                units.put("km", 1000.0);
                units.put("mi", 1609.34);
                break;
            case 2:
                units.put("kg", 1.0);
                units.put("g", 0.001);
                units.put("lb", 0.453592);
                break;
            case 3:
                units.put("l", 1.0);
                units.put("ml", 0.001);
                units.put("gal", 3.78541);
                break;
            case 4:
                units.put("EUR", 1.0);
                units.put("USD", 1.1);
                units.put("GBP", 0.88);
                units.put("CNY", 7.2);
                break;
            default:
                System.out.println("Invalid type!");
                scanner.close();
                return;
        }

        System.out.println("Available units: " + units.keySet());
        System.out.print("From unit: ");
        String fromUnit = scanner.next();
        System.out.print("To unit: ");
        String toUnit = scanner.next();

        if (!units.containsKey(fromUnit) || !units.containsKey(toUnit)) {
            System.out.println("Invalid unit!");
        } else {
            double baseValue = value * units.get(fromUnit);
            double convertedValue = baseValue / units.get(toUnit);
            System.out.println(value + " " + fromUnit + " = " + convertedValue + " " + toUnit);
        }

        scanner.close();
    }
}