import java.util.*;

public class App {

    public static Boolean isOperation(String operation) {
        return operation.matches("^[0-9+\\-*/%^()\\[\\]. ]+$");
    }

    public enum Priority {

        POWER('^', 3),
        MULTIPLICATION('*', 2),
        DIVISION('/', 2),
        MODULO('%', 2),
        ADDITION('+', 1),
        SUBTRACTION('-', 1);

        private final char symbol;
        private final int priority;

        Priority(char symbol, int priority) {
            this.symbol = symbol;
            this.priority = priority;
        }

        public char getSymbol() {
            return symbol;
        }

        public int getPriority() {
            return priority;
        }

        public static Priority fromSymbol(char symbol) {
            for (Priority op : values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operator: " + symbol);
        }

        public static boolean isOperator(char c) {
            for (Priority op : values()) {
                if (op.symbol == c) return true;
            }
            return false;
        }
    }

    public static double calculs(String operation) {

        // 1️⃣ Normalisation
        operation = operation.replace("[", "(")
                             .replace("]", ")")
                             .replaceAll("(\\d)\\(", "$1*(")
                             .replaceAll("\\s+", "");

        // 2️⃣ Conversion en postfix (Shunting Yard)
        List<String> output = new ArrayList<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < operation.length(); i++) {

            char c = operation.charAt(i);

            // Nombre (support multi-chiffres)
            if (Character.isDigit(c) || c == '.') {
                StringBuilder number = new StringBuilder();
                while (i < operation.length() &&
                      (Character.isDigit(operation.charAt(i)) || operation.charAt(i) == '.')) {
                    number.append(operation.charAt(i));
                    i++;
                }
                i--;
                output.add(number.toString());
            }

            // Parenthèse ouvrante
            else if (c == '(') {
                operators.push(c);
            }

            // Parenthèse fermante
            else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.pop();
            }

            // Opérateur
            else if (Priority.isOperator(c)) {

                while (!operators.isEmpty() &&
                        operators.peek() != '(' &&
                        Priority.fromSymbol(operators.peek()).getPriority() >=
                        Priority.fromSymbol(c).getPriority()) {

                    output.add(String.valueOf(operators.pop()));
                }

                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            output.add(String.valueOf(operators.pop()));
        }

        // 3️⃣ Évaluation postfix
        Stack<Double> values = new Stack<>();

        for (String token : output) {

            if (token.matches("-?\\d+(\\.\\d+)?")) {
                values.push(Double.parseDouble(token));
            } else {
                double b = values.pop();
                double a = values.pop();
                char op = token.charAt(0);

                switch (op) {
                    case '^': values.push(Math.pow(a, b)); break;
                    case '*': values.push(a * b); break;
                    case '/': values.push(a / b); break;
                    case '%': values.push(a % b); break;
                    case '+': values.push(a + b); break;
                    case '-': values.push(a - b); break;
                }
            }
        }

        return values.pop();
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java App \"expression\"");
            return;
        }

        if (isOperation(args[0])) {
            double result = calculs(args[0]);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid expression.");
        }
    }
}