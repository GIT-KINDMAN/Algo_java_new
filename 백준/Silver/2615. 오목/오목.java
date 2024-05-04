import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[] di = {-1, 0, 1, 1};
    static int[] dj = {1, 1, 1, 0};
    static int win;
    static String point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        win = 0;
        outer:
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    check(i, j, map[i][j]);
                }
                if (win != 0) break outer;
            }
        }

        if (win == 0) {
            System.out.println(0);
        } else {
            System.out.println(win);
            System.out.println(point);
        }
    }

    private static void check(int si, int sj, int who) {
        for (int d = 0; d < 4; d++) {
            if (dfs(si, sj, si, sj, d, who, 1)) {
                if (win != 0) return;
            }
        }
    }

    private static boolean dfs(int si, int sj, int ni, int nj, int d, int who, int depth) {
        int nexti = ni + di[d], nextj = nj + dj[d];

        if (depth == 5) {
            if (!inBoundary(nexti, nextj) || map[nexti][nextj] != who) {
                int previ = si - di[d], prevj = sj - dj[d];
                if (!inBoundary(previ, prevj) || map[previ][prevj] != who) {
                    win = who;
                    point = (si + 1) + " " + (sj + 1);
                    return true;
                }
            }
            return false;
        }

        if (inBoundary(nexti, nextj) && map[nexti][nextj] == who) {
            return dfs(si, sj, nexti, nextj, d, who, depth + 1);
        }
        return false;
    }

    private static boolean inBoundary(int i, int j) {
        return 0 <= i && i < 19 && 0 <= j && j < 19;
    }
}
