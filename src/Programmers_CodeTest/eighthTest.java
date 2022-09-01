package Programmers_CodeTest;

import java.util.*;
class Consulting{
    int start;
    int end;
    int profit;
    public Consulting(int cur, int next, int cost){
        this.start = cur;
        this.end = next;
        this.profit = cost;
    }
}
class pos{
    int x;
    int y;
    public pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class eighthTest {
    public static int solution(int[] start, int[] end, int[] price) {
        List<Consulting> list = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            list.add(new Consulting(start[i],end[i],price[i]));
        }
        return findMaxProfit(list);
    }
    public static int findLastNonConflictingConsulting(List<Consulting> list, int n){
        for (int i = n-1; i >= 0; i--) {
            if(list.get(i).end <= list.get(n).start){
                return i;
            }
        }
        return -1;
    }
    public static int findMaxProfit(List<Consulting> list, int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return list.get(0).profit;
        }
        int index = findLastNonConflictingConsulting(list, n);
        int incl = list.get(n).profit + findMaxProfit(list, index);
        int excl = findMaxProfit(list, n-1);
        return Math.max(incl, excl);
    }
    public static int findMaxProfit(List<Consulting> list){
        Collections.sort(list, Comparator.comparingInt(x -> x.end));
        return findMaxProfit(list, list.size()-1);
    }
    /*public static int solution(int[] start, int[] end, int[] price) {
        int answer = 0;
        List<Consulting>[] consulting = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            consulting[i] = new ArrayList<>();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < start.length; i++) {
            min = Math.min(start[i], min);
            consulting[start[i]].add(new Consulting(start[i],end[i], price[i]));
            consulting[end[i]].add(new Consulting(end[i],start[i], price[i]));
        }
        PriorityQueue<Consulting> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[10001];
        pq.add(new Consulting(0,min,0));
        boolean is = false;
        while(!pq.isEmpty()) {
            Consulting cur = pq.poll();
            for (int i = cur.cur; i < cur.next; i++) {
                if (visited[i]) {
                    is = true;
                }
            }
            if (!is) {
                answer += cur.cost;
                for (int i = cur.cur; i < cur.next; i++) {
                    visited[i] = true;
                }
                for (Consulting con : consulting[cur.next]) {
                    if (!visited[con.next]) {
                        pq.add(con);
                    }
                }
            }
        }
        return answer;
    }*/
    static int enddepth;
    static int endn;
    static int min = Integer.MAX_VALUE;
    public static int solution2(int depth, int n, int[][] blocks) {
        endn = n;
        enddepth = depth;
        for (int i = 0; i < blocks[0].length; i++) {
            dfs(0, i,0,blocks);
        }
        return min;
    }
    public static void dfs(int depth, int n, int sum,int[][] blocks){
        if(depth == enddepth && n == endn){
            sum += blocks[depth][n];
            min = Math.min(min,sum);
            return;
        }else if(depth == enddepth){
            return;
        }
        int a = Integer.MAX_VALUE;
        int idx = 0;
        sum += blocks[depth][n];
        for (int i = n-1; i <= n+1; i++) {
            if(i>=0 && i <blocks[0].length){
                if(a>blocks[depth+1][i]){
                    a = blocks[depth+1][i];
                    idx = i;
                }
            }
        }
        dfs(depth+1, idx, sum, blocks);
    }
    /*static int Max =0;
    static int size;
    public static int solution3(int N, int[] rewards) {
        boolean[] visited = new boolean[N];

        size = N;
    }
    public static void dfs(int cur,int[] rewards, boolean[] visited,int cnt,int sum){
        if(cnt == size){
            Max = Math.max(sum, Max);
            return;
        }
        if(visited[cur]){
            return;
        }
        visited[cur] = true;
        if(cur+1 <size && !visited[cur+1]){
            visited[cur+1] = true;
            cnt++;
        }else if(cur+1>=size&& !visited[0]){
            visited[0] = true;
            cnt++;
        }
        if(cur-1>=0 && !visited[cur-1]){
            visited[cur-1] = true;
            cnt++;
        }else if(cur-1<0 && visited[size-1]){
            visited[size-1] = true;
            cnt++;
        }
        sum += rewards[cur];
        for (int i = cur+2; i < size; i++) {

        }
    }*/
    static int[][] dirs = {{0,1}, {1,0}};
    static int answer =0;
    public static int solution(int[][] maze) {
        dfs(0,0,maze,false);
        return answer;
    }
    public static void dfs(int x, int y, int[][] maze, boolean key){
        if(x>=maze.length || y>=maze.length|| x<0|| y<0){
            return;
        }
        if(x == maze.length-1 && y == maze.length-1){
            if(key) {
                answer += 1;
            }
            return;
        }
        for(int[] dir : dirs){
            int cx = dir[1] +x;
            int cy = dir[0] +y;
            if(cx>=maze.length || cy>=maze.length|| cx<0|| cy<0) continue;
            if(maze[cx][cy] ==0){dfs(cx,cy,maze,key);}
            else if(maze[cx][cy] ==2){dfs(cx,cy,maze,true);}
            else{
                continue;
            }
        }
    }
    public static void main(String[] args){
        int[] start = {1,5,10,6,5};
        int[] end = {5,6,12,9,12};
        int[] price = {10,40,30,20,50};
        int[][] blocks = {{5,6,2,6}, {1,6,4,9},{5,6,9,4},{55,14,21,14}};
        System.out.println(solution2(3,3,blocks));
        System.out.println(solution(start, end, price));
//        int[] rewards = {1, 1, 10, 1, 1, 1, 10, 1, 1, 10};
//        System.out.println(solution3(10,rewards));
//        int[][] maze = {{0,1,0}, {0,2,0},{1,0,0}};
//        System.out.println(solution(maze));
    }
}
