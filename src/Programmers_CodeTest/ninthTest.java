package Programmers_CodeTest;

import java.util.*;
public class ninthTest {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    /*1번
    static HashSet<Integer> set;
    static ArrayList<ArrayList<Node>> list;
    public static int solution1(int N, int[][] friend, int[][] time) {
        int answer = 0;
        list = new ArrayList<>();
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < friend.length; i++) {
            int cnt  =0;
            for(int a : friend[i]){
                list.get(i).add(new Node(a, time[i][cnt]));
                cnt++;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.add(new Node(0,0));
        int result = 0;
        while(!pq.isEmpty()){

            Node cur = pq.poll();
            if(set.contains(cur.to)) continue;
            set.add(cur.to);
            if(set.size() == N){
                result = cur.weight;
                break;
            }
            for (int i = 0; i < list.get(cur.to).size(); i++) {
                Node a = list.get(cur.to).get(i);
                pq.offer(new Node(a.to, cur.weight+a.weight));
            }
        }
        return result;
    }*/

    /* 2번
    static int answer = 1000000;
    static ArrayList<ArrayList<Node>> list;

    public static int solution(int N, int[][] flight, int a, int b, int k) {
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] arr : flight) {
            list.get(arr[0]).add(new Node(arr[1], arr[2]));
        }
        dfs(a,b, 0,0,k);
        return answer;
    }
    public static void dfs(int start, int end,int time, int cnt, int limit){
        if(cnt >limit){
            return;
        }
        if(start == end){
            answer = Math.min(time, answer);
            return;
        }
        for (int i = 0; i < list.get(start).size(); i++) {
            Node cur = list.get(start).get(i);
            dfs(cur.to, end, time + cur.weight,cnt+1, limit);
        }
    }*/
    /* 3번
    static ArrayList<ArrayList<Integer>> list;
    public static int solution(int N, int[][] graph, int[] infected) {
        int answer = 0;
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                if(graph[i][j] ==1){
                    list.get(i).add(j);
                }
            }
        }
        int k = 0;
        for(int infect : infected){
            dfs(infect,N, infect);
            if(k < list.get(infect).size()){
                k = infect;
            }
        }

        return k;
    }
    public static void dfs(int start, int N,int cur){
        int cnt = 0;
        if(list.get(start).size() >N-1){
            return;
        }
        for (int i = 0; i < list.get(cur).size(); i++) {
            int a = list.get(cur).get(i);
            if(list.get(start).contains(a))continue;
            list.get(start).add(a);
            cnt++;
        }
        if(cnt ==0){
            return;
        }
    }*/
    static int[][] weight;
    static int answer =0;
    public static int solution(int[] x, int[] y) {
        weight = new int[x.length][x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = i; j < x.length; j++) {
                if(i ==j) weight[i][j] = 0;
                else{
                    weight[i][j] = manhattan(x[i],x[j],y[i],y[j]);
                    weight[j][i] = weight[i][j];
                }
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o,p) -> o.weight - p.weight);
        pq.offer(new Node(0,0));
        HashSet<Integer> set = new HashSet<>();
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(set.contains(cur.to))continue;
            set.add(cur.to);
            answer += cur.weight;
            for (int i = 0; i < weight.length; i++) {
                if(!set.contains(i)){
                    pq.offer(new Node(i, weight[cur.to][i]));
                }
            }
        }
        return answer;
    }

    public static int manhattan(int x1, int x2, int y1,int y2){
        int a = Math.abs(x1-x2); int b = Math.abs(y1 - y2);
        return a+b;
    }

    public static void main(String[] args){
//        int[][] friend = {{1,4},{2,3},{4},{1},{0,2}};
//        int[][] time = {{5,2},{6,4},{9},{1},{2,6}};
//        System.out.println(solution1(5,friend,time));
//        int[][] flight = {{0,2,1},{1,3,20},{1,0,8},{2,3,1},{0,3,3}};
//        System.out.println(solution(4,flight,1,3,2));
//        int[][] graph = {{1,1,1,0},{1,1,0,0},{1,0,1,1},{0,0,1,1}};
//        int[] infected = {1,3};
//        System.out.println(solution(4,graph,infected));
        int[] x = {0,0,3,3,6};
        int[] y = {0,3,1,4,3};
        System.out.println(solution(x,y));

    }
}
