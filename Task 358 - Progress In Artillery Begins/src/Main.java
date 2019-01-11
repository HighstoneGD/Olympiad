import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static int num;
    private static String stringNum;
    private static boolean executeProgram;
    private static int lumenodiods = 0;

    public static void main(String[] args) {
        executeProgram = input();

        if (executeProgram) {
            Map<Character , Integer> numerals = new HashMap<Character, Integer>();
            numerals.put('0', 6);
            numerals.put('1', 2);
            numerals.put('2', 5);
            numerals.put('3', 5);
            numerals.put('4', 4);
            numerals.put('5', 5);
            numerals.put('6', 6);
            numerals.put('7', 3);
            numerals.put('8', 7);
            numerals.put('9', 6);

            for (char c : stringNum.toCharArray()) {
                lumenodiods += numerals.get(c);
            }
            System.out.println(lumenodiods);
        }
    }

    private static boolean input() {
        num = in.nextInt();

        if (num < 0 || num > 1000000000) {
            return false;
        }

        stringNum = Integer.toString(num);
        return true;
    }
}
