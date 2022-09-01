package BAEKJOON;

import java.io.*;
import java.util.*;
class Net implements Comparable<Net>{
    int next;
    int cost;
    public Net(int next, int cost){
        this.next = next;
        this.cost = cost;
    }
    @Override
    public int compareTo(Net o){
        return cost - o.cost;
    }
}
public class boj1922 {
    static List<Net>[] network;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        network = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            network[i] = new ArrayList<>();
        }
        int result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            network[next].add(new Net(cur, cost));
            network[cur].add(new Net(next,cost));
        }
        PriorityQueue<Net> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.add(new Net(1,0));
        while(!pq.isEmpty()){
            Net cur = pq.poll();
            if(visited[cur.next]) continue;
            result += cur.cost;
            visited[cur.next] = true;
            for(Net net : network[cur.next]){
                if(!visited[net.next]){
                    pq.add(net);
                }
            }
        }
        System.out.println(result);
    }
}
