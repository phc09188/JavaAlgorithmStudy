package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1229 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = {0, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 2};
        int[] dp = new int[N + 1];
        if (N < 13) {
            System.out.println(d[N]);
        } else {
            for (int i = 0; i < d.length; i++) {
                dp[i] = d[i];
            }
            // 육각수들을 뽑아냄
            ArrayList<Integer> list = get(N);
            for (int i = 13; i < N + 1; i++) {
                int min = Integer.MAX_VALUE;
                for (int a : list) {
                    if (a > i) {
                        break;
                    }
                    min = Math.min(min, dp[i - a]);
                }
                dp[i] = min + 1;
            }
            System.out.println(dp[N]);
        }
    }

    public static ArrayList<Integer> get(int limit) {
        int n = 1;
        int current = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (current <= limit) {
            current = n * (2 * n - 1);
            list.add(current);
            n += 1;
        }
        return list;
    }
}
