import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static int N;
    private static int[] bags;
    private static int[] paresOfBags;
    private static int firstHand;
    private static int secondHand;
    private static boolean executeProgram;
    private static int sumOfFour;

    public static void main(String[] args) {
        executeProgram = input();
        sumOfFour = bags[0] + bags[1] + bags[2] + bags[3];

        if (executeProgram) {
            fillParesOfBags();
            firstHand = paresOfBags[findMax(paresOfBags)];
            bags[findMax(paresOfBags)] = -1;
            bags[findMax(paresOfBags) + 1] = -1;

            for (int i = 0; i < paresOfBags.length; i++) {
                paresOfBags[i] = -1;
            }

            fillParesOfBags();

            boolean k = false;
            for (int pare : paresOfBags) {
                if (pare != -1) {
                    k = true;
                }
            }

            if (k) {
                secondHand = paresOfBags[findMax(paresOfBags)];
                System.out.println((firstHand + secondHand));
            } else {
                System.out.println(sumOfFour);
            }

        }
    }

    private static boolean input() {
        N = in.nextInt();
        if (N < 4 || N > 10000) {
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
