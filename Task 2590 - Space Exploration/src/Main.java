import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static int n;
    private static int amount = 0;
    private static boolean executeProgram;
    private static char[][] area;
    private static boolean isFinished;

    public static void main(String[] args) {
        executeProgram = input();

        try {
            if (executeProgram) {

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (area[i][j] == '*') {
                            fillAsteroid(i, j);
                        }
                    }
                }

                System.out.println(amount);
            }
        } catch (Exception e) {}

    }

    private static boolean input() {
        String nSt = in.nextLine();
        try {
            n = Integer.valueOf(nSt);
        } catch (Exception e) {}

        if (n < 1 || n > 1000) {
            return false;
        }

        area = new char[n][n];

        try {
            for (int i = 0; i < n; i++) {
                String inputString = in.nextLine();
                for (int j = 0; j < n; j++) {
                    area[i][j] = inputString.charAt(j);
                    if (area[i][j] != '.' && area[i][j] != '*') {
                        return false;
                    }
                }
            }
        } catch (Exception e) {}

        return true;
    }

    private static void fillAsteroid(int coorI, int coorJ) {
        amount++;
        area[coorI][coorJ] = (char)amount;
        isFinished = false;

        while (!isFinished) {
            fillPart(coorI, coorJ, amount);
        }
    }

    private static void fillPart(int coorI, int coorJ, int count) {
        if (coorI + 1 < n && area[coorI + 1][coorJ] == '*') {
            area[coorI + 1][coorJ] = (char)count;
            fillPart(coorI + 1, coorJ, count);
        }

        if (coorI - 1 >= 0 && area[coorI - 1][coorJ] == '*') {
            area[coorI - 1][coorJ] = (char)count;
            fillPart(coorI - 1, coorJ, count);
        }

        if (coorJ + 1 < n && area[coorI][coorJ + 1] == '*') {
            area[coorI][coorJ + 1] = (char)count;
            fillPart(coorI, coorJ + 1, count);
        }

        if (coorJ - 1 >= 0 && area[coorI][coorJ - 1] == '*') {
            area[coorI][coorJ - 1] = (char)count;
            fillPart(coorI, coorJ - 1, count);
        }

        isFinished = true;
    }
}
