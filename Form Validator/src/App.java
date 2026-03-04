import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

    private static final Pattern NAME =
            Pattern.compile("^[a-zA-Z]+$");

    private static final Pattern EMAIL =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern DATE =
            Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");

    private static final Pattern PASSWORD =
            Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");

    public static boolean isValid(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }

    public static String askUntilValid(
            Scanner scanner,
            String message,
            Pattern pattern,
            String errorMessage) {

        String input;

        do {
            System.out.print(message);
            input = scanner.nextLine();

            if (!isValid(input, pattern)) {
                System.out.println( errorMessage);
            }

        } while (!isValid(input, pattern));

        System.out.println("Valid!\n");
        return input;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==== FORM VALIDATOR ====\n");

        String name = askUntilValid(
                scanner,
                "Enter your name: ",
                NAME,
                "Only letters allowed."
        );

        String surname = askUntilValid(
                scanner,
                "Enter your surname: ",
                NAME,
                "Only letters allowed."
        );

        String date = askUntilValid(
                scanner,
                "Enter your date of birth (dd/mm/yyyy): ",
                DATE,
                "Date must be in format dd/mm/yyyy."
        );

        String email = askUntilValid(
                scanner,
                "Enter your email: ",
                EMAIL,
                "Invalid email format."
        );

        String password = askUntilValid(
                scanner,
                "Enter your password: ",
                PASSWORD,
                "Password must contain 8+ chars, 1 uppercase, 1 lowercase, 1 digit."
        );

        System.out.println("===== FORM COMPLETED SUCCESSFULLY =====");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Date of birth: " + date);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        scanner.close();
    }
}