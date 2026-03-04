import java.util.HashMap;

public class App {
    public String textColor(String color) {
        HashMap<String, String> colorMap = new HashMap<>();
        colorMap.put("R_Black", "\u001b[0;30m");
        colorMap.put("R_Red", "\u001b[0;31m");
        colorMap.put("R_Green", "\u001b[0;32m");
        colorMap.put("R_Yellow", "\u001b[0;33m");
        colorMap.put("R_Blue", "\u001b[0;34m");
        colorMap.put("R_Purple", "\u001b[0;35m");
        colorMap.put("R_Cyan", "\u001b[0;36m");
        colorMap.put("R_White", "\u001b[0;37m");

        return colorMap.get(color);
    }

    public static String resetColor() {
        return "\u001b[0m";
    }

    public String textStyle(String text) {
        HashMap<String, String> styleMap = new HashMap<>();
        styleMap.put("ITALIC", "\u001B[3m");
        styleMap.put("UNDERLINE", "\u001B[4m");
        styleMap.put("BLINK", "\u001B[5m");
        styleMap.put("RAPID_BLINK", "\u001B[6m");
        styleMap.put("REVERSE_VIDEO", "\u001B[7m");
        styleMap.put("INVISIBLE_TEXT", "\u001B[8m");

        return styleMap.get(text);
    }

    public String bgColor(String color) {
        HashMap<String, String> bgColorMap = new HashMap<>();
        bgColorMap.put("BG_Black", "\u001b[40m");
        bgColorMap.put("BG_Red", "\u001b[41m");
        bgColorMap.put("BG_Green", "\u001b[42m");
        bgColorMap.put("BG_Yellow", "\u001b[43m");
        bgColorMap.put("BG_Blue", "\u001b[44m");
        bgColorMap.put("BG_Purple", "\u001b[45m");
        bgColorMap.put("BG_Cyan", "\u001b[46m");
        bgColorMap.put("BG_White", "\u001b[47m");

        return bgColorMap.get(color);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        for (String arg : args) {
            if (arg.contains(".")) {
                int index = arg.indexOf(".");
                String key = arg.substring(0, index);
                String text = arg.substring(index + 1);
                String code = null;

                if (app.textColor(key) != null) {
                    code = app.textColor(key);
                } else if (app.bgColor(key) != null) {
                    code = app.bgColor(key);
                } else if (app.textStyle(key) != null) {
                    code = app.textStyle(key);
                }else {
                    System.out.println("Error");
                }

                if (code != null) {
                    arg = code + text + resetColor();
                }
            }
            System.out.print(arg + " ");
        }
        System.out.println();
    }
}