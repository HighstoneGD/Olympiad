import java.util.*;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static Map<Integer, Integer> parentness = new HashMap<>();
    private static List<Integer> finalMissions = new ArrayList<>();
    private static int[] time;
    private static int N;
    private static int M;
    private static int allTime = 0;
    private static boolean executeProgram;

    public static void main(String[] args) {
        executeProgram = input();

        if (executeProgram) {
            findAllFinalMissions();

            if (N == 1) {
                System.out.println(time[0]);
            } else {
                for (int key : finalMissions) {
                    allTime += restoreChain(key);
                    if (restoreChain(key) == -1) {
                        return;
                    }
                }
                System.out.println(allTime);
            }

        }
    }

    private static boolean input() {
        N = in.nextInt();

        if (N < 1 || N > 100) {
            return false;
        }

        time = new int[N];

        for (int i = 0; i < N; i++) {
            time[i] = in.nextInt();

            if (time[i] < 1 || time[i] > 100) {
                return false;
            }
        }

        M = in.nextInt();

        if (M != N - 1) {
            return false;
        }

        for (int i = 0; i < M; i++) {
            int curF;
            int curT;

            try {
                curF = in.nextInt();
            } catch (Exception e) {
                return false;
            }
            try {
                curT = in.nextInt();
            } catch (Exception e) {
                return false;
            }

            if (curT == 1 || parentness.containsKey(curT) || curT < 1 || curT > N || curF < 1 || curF > N) {
                return false;
            }

            parentness.put(curT, curF);
        }

        return true;
    }

    private static int restoreChain(int finalMission) {
        int counter = finalMission;
        int curTime = time[finalMission - 1];

        while (counter != 1) {
            counter = parentness.get(counter);

            if (parentness.get(counter) == null && counter != 1) {
                return -1;
            }

            curTime += time[counter - 1];
        }

        return curTime;
    }

    private static void findAllFinalMissions() {
        for (int key : parentness.keySet()) {
            if (!parentness.containsValue(key)) {
                finalMissions.add(key);
            }
        }
    }
}
