package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj1966 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Queue<int[]> qu = new LinkedList<>();
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                qu.offer(new int[] {j, Integer.parseInt(st.nextToken())});
            }
            while(!qu.isEmpty()) {
                int max = -1;
                for (int j = 0; j < qu.size(); j++) {
                    if (qu.peek()[1] > max) {
                        max = qu.peek()[1];
                    }
                    qu.offer(qu.poll());
                }
                if (qu.peek()[0] == m && qu.peek()[1] == max) {
                    cnt++;
                    qu.poll();
                    break;
                }
                if (qu.peek()[1] == max) {
                    cnt++;
                    qu.poll();
                } else {
                    qu.offer(qu.poll());
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
