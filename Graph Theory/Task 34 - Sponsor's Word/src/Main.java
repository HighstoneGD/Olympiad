import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static boolean executeProgram;
    private static int participants;
    private static int prizes;
    private static int terms;
    private static int start;
    private static int[][] graph;
    private static int[] winners;
    private static int[] winnersTime;
    private static int[] departments;
    private static Map<Integer, Boolean> isVisited;

    public static void main(String[] args) {
        executeProgram = input();

        if (executeProgram) {
            Dijkstra();
            winnersTime = new int[winners.length];
            for (int i = 0; i < winners.length; i++) {
                winnersTime[i] = departments[winners[i]];
            }

            boolean isSponsorGood = true;

            for (int winnerTime : winnersTime) {
                if (winnerTime > 366) {
                    isSponsorGood = false;
                }
            }

            if (isSponsorGood) {
                System.out.println("The good sponsor!" + winnersTime[findMaxElemIndex(winnersTime)]);
            } else {
                System.out.println("It is not fault of sponsor...");
            }
        }
    }

    private static boolean input() {
        participants = in.nextInt();
        prizes = in.nextInt();
        terms = in.nextInt();

        if (participants < 1 || participants > 365 || prizes < 1 || prizes > 365 || prizes > participants || terms < 0) {
            return false;
        }

        graph = new int[participants][participants];
        winners = new int[prizes];

        for (int i = 0; i < prizes; i++) {
            winners[i] = in.nextInt();
            if (winners[i] > participants || winners[i] < 1) {
                return false;
            }
        }

        for (int i = 0; i < participants; i++) {
            for (int j = 0; j < participants; j++) {
                graph[i][j] = 0;
            }
        }

        for (int i = 0; i < terms; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int t = in.nextInt();

            if (a < 1 || a > 365 || b < 1 || b > 365 || a == b || t < 0 || t > 365) {
                return false;
            }

            graph[a - 1][b - 1] = t;
        }

        start = in.nextInt();

        if (start < 1 || start > participants) {
            return false;
        }

        return true;
    }

    private static void Dijkstra() {
        // initializing begin
        departments = new int[participants];
        isVisited = new HashMap<>();

        for (int i = 0; i < participants; i++) {
            isVisited.put(i, false);
        }

        int index;

        for (int department : departments) {
            department = 400;
        }

        departments[start - 1] = 0;
        // initializing finished

        while (isVisited.containsValue(false)) {
            index = findMinElemIndex(departments);

            System.out.println("Dijkstra executing for index = " + index + " because visited = " + isVisited.get(index));

            int curDep = -1;

            for (int time : graph[index]) {
                curDep++;

                if (!isVisited.get(curDep) || departments[curDep] > departments[index] + graph[index][curDep]) {
                    departments[curDep] = departments[index] + graph[index][curDep];
                }
            }

            isVisited.replace(index, false, true);
            System.out.println("isVisited = " + isVisited.get(index));
        }

    }

    private static int findMinElemIndex(int[] array) {
        int minValIndex = 0;
        int curIndex = -1;

        for (int element : array) {
            curIndex++;
            System.out.println("curIndex = " + curIndex);
            if (element < array[minValIndex] && !isVisited.get(curIndex)) {
                minValIndex = curIndex;
            }
        }

        return minValIndex;
    }

    private static int findMaxElemIndex(int[] array) {
        int maxValIndex = 0;
        int curIndex = -1;

        for (int element : array) {
            curIndex++;
            if (element < array[maxValIndex]) {
                maxValIndex = curIndex;
            }
        }

        return maxValIndex;
    }
}
