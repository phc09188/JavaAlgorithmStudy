package BAEKJOON;

import java.io.*;

import java.util.*;

class Node implements Comparable<Node>{
    int next;
    int cost;
    public Node(int next, int cost){
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class boj1916 {
    static List<Node>[] list;
    static int a;
    static int[] dp;
    static boolean[] visited;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        visited  = new boolean[M];
        list = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] =new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[first].add(new Node(last, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());
        search(start);
        System.out.println(dp[finish]);
    }
    static void search(int start ) {
        Queue<Node> q = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        q.add(new Node(start, 0));
        dp[start] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int to = node.next;
            if (visited[to]) continue;
            visited[node.next] = true;
            for (Node next : list[to]) {
                if (dp[next.next] >= dp[to] + next.cost) {
                    dp[next.next] = dp[to] + next.cost;
                    q.add(new Node(next.next, dp[next.next]));
                }
            }
        }
    }
}
