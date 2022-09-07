package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj13418 {
    static class Node{
        int to;
        int updown;

        public Node(int to, int updown) {
            this.to = to;
            this.updown = updown;
        }
    }
    static int n;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, road));
            list[end].add(new Node(start, road));
        }
        PriorityQueue<Node> pq1 = new PriorityQueue<>((x,y) -> x.updown - y.updown);
        PriorityQueue<Node> pq2 = new PriorityQueue<>((x,y) -> y.updown - x.updown);
        int max = (int)Math.pow(mst(0, pq1),2);
        int min = (int)Math.pow(mst(0, pq2),2);
        System.out.println(max -min);
    }
    public static int mst(int start, PriorityQueue<Node> pq){
        boolean[] visited = new boolean[n+1];
        pq.offer(new Node(start, -1));
        int cnt = 0;
        while(!pq.isEmpty()){
            Node a = pq.poll();
            if(!visited[a.to]) visited[a.to] = true;
            else continue;

            if(a.updown ==0) cnt++;
            for (int i = 0; i < list[a.to].size(); i++) {
                pq.offer(list[a.to].get(i));
            }
        }
        return cnt;
    }
}
