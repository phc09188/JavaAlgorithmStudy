package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj14950 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight-y.weight);
        pq.add(new Node(1,0));
        boolean[] visited = new boolean[n+1];
        int cnt = -1;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.to]) continue;
            visited[cur.to] = true;
            result += cur.weight;
            for (int i = 0; i < list.get(cur.to).size(); i++) {
                Node adj = list.get(cur.to).get(i);
                pq.offer(new Node(adj.to,adj.weight));
            }
            if(cnt>=0) {
                result += cnt* t;
            }
            cnt++;
        }
        System.out.println(result);
    }
}
