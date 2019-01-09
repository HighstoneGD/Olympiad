import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static int N;
    private static int[] bags;
    private static int[] paresOfBags;
    private static int firstHand;
    private static int secondHand;

    public static void main(String[] args) {
        boolean executeProgram = input();

        if (executeProgram) {
            fillParesOfBags();
            firstHand = paresOfBags[findMax(paresOfBags)];
            bags[findMax(paresOfBags)] = -1;
            bags[findMax(paresOfBags) + 1] = -1;

            for (int pare : paresOfBags) {
                pare = -1;
            }

            fillParesOfBags();
            secondHand = paresOfBags[findMax(paresOfBags)];
            System.out.println((firstHand + secondHand) + " first: " + firstHand + ", second: " + secondHand);

            for (int pare : paresOfBags) {
                System.out.println("pare " + pare);
            }
        }
    }

    private static boolean input() {
        int N = in.nextInt();
        if (N < 4 && N > 10000) {
            return false;
        }
        bags = new int[N];
        paresOfBags = new int[N - 1];

        for (int i = 0; i < N; i++) {
            bags[i] = in.nextInt();
            if (bags[i] < 0 || bags[i] > 1000000) {
                return false;
            }
        }

        return true;
    }

    private static void fillParesOfBags() {
        for (int i = 0; i < N - 1; i++) {
            if (bags[i] != -1 && bags[i + 1] != -1) {
                paresOfBags[i] = bags[i] + bags[i + 1];
            }
        }
    }

    private static int findMax(int[] array) {
        int index = 0;
        int cur = 0;

        for (int element : array) {
            if (array[index] < element) {
                index = cur;
            }
            cur++;
        }

        return index;
    }
}
