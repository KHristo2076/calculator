import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number: ");
        String exp = scn.nextLine();
        String resoult = calc(exp);
        System.out.println(resoult);
    }

    public static String calc(String input) {
        Convertor convertor = new Convertor();
        String[] actions = new String[]{"+", "-", "/", "*"};
        String[] regexActions = new String[]{"\\+", "\\-", "/", "\\*"};
        String act = input.replaceAll("[0-9,\\w]", "");
        int countActions = act.length();

        try {
            if (countActions > 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException var14) {
            System.out.println("My calculator can only work with two numbers");
            System.exit(1);
        }

        int actionIndex = -1;

        for(int i = 0; i < actions.length; ++i) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }

        String[] data = input.split(regexActions[actionIndex]);
        if (convertor.isRoman(data[0]) == convertor.isRoman(data[1])) {
            boolean isRoman = convertor.isRoman(data[0]);
            int a;
            int b;
            if (isRoman) {
                a = convertor.RomanToInt(data[0]);
                b = convertor.RomanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            try {
                if (a > 10 || b > 10 || a < 1 || b < 1) {
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException var15) {
                System.out.println("Please enter a value less than 10 and not less than 1");
                System.exit(1);
            }

            int var10000;
            switch (actions[actionIndex]) {
                case "+" -> var10000 = a + b;
                case "-" -> var10000 = a - b;
                case "*" -> var10000 = a * b;
                case "/" -> var10000 = a / b;
                default -> var10000 = 0;
            }

            int resoult = var10000;
            return isRoman ? convertor.IntToRoman(resoult) : String.valueOf(resoult);
        } else {
            return "Invalid input";
        }
    }
}
