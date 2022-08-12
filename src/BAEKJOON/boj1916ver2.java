package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1916ver2 {
    static int[] cost;
    static int a;
    public static int search(int[] first, int[] last, int start, int finish, int resultcost, boolean[] visited){
        if(start == finish){
            a = Integer.MAX_VALUE;
            a = Math.min(resultcost, a);
            return a;
        }else {
            for (int i = 0; i < last.length; i++) {
                if (last[i] == finish && !visited[i]) {
                    resultcost += cost[i];
                    visited[i] = true;
                    search(first, last, start, first[i], resultcost,visited);
                    resultcost = 0;
                }
            }
        }
        return a;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] first = new int[M];
        int[] last = new int[M];
        boolean[] visited = new boolean[M];
        cost = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            first[i] = Integer.parseInt(st.nextToken());
            last[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());
        int resultcost = search(first,last, start, finish, 0, visited);
        System.out.println(resultcost);

    }
}
