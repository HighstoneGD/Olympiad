import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static int N;
    private static int M;
    private static int curN;
    private static int curM;
    private static int divisionGrade = 0;
    private static boolean executeProgram;
    private static boolean isFinal = false;

    public static void main(String[] args) {
        executeProgram = input();
        curM = M;
        curN = N;

        if (executeProgram) {
            while (!isFinal) {
                if (curN % 2 == 1 && curM % 2 == 1) {
                    divisionGrade++;
                    curM = (curM - 1)/2;
                    curN = (curN - 1)/2;
                } else {
                    isFinal = true;
                }
            }

            System.out.println(countFinalAmount(divisionGrade));
        }
    }

    private static boolean input() {
        N = in.nextInt();
        M = in.nextInt();

        if (N < 1 || N > 1000000000 || M < 1 || M > 1000000000) {
            return false;
        }

        return true;
    }

    private static int countFinalAmount(int divGrade) {
        int amount = 1;
        if (divGrade == 0) {
            return 0;
        } else if (divGrade == 1){
            return 1;
        } else {
            for (int i = 0; i < divGrade - 1; i++) {
                amount = amount * 4 + 1;
            }
            return amount;
        }
    }
}
