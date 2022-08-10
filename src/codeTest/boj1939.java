package codeTest;

import java.io.*;
import java.util.*;
class island{
    int next;
    int weight;
    public island( int next, int weight){
        this.next = next;
        this.weight = weight;
    }
}
public class boj1939 {
    static int N,M, result;
    static List<island>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        int left = Integer.MAX_VALUE; int right = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
            list[a].add(new island(b,c)); list[b].add(new island(a,c));
            left = Math.min(left, c);
            right = Math.max(right, c);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); int finish = Integer.parseInt(st.nextToken());
        while(left  <= right){
            visited = new boolean[N+1];
            int mid = (left + right)/2;
            if(bfs(mid, start, finish)){
                left = mid +1;
            }
            else right = mid -1;
        }
        System.out.println(right);
    }
    public static boolean bfs(int mid, int start, int finish){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        visited[start] = true;
        while(!qu.isEmpty()){
            int temp = qu.poll();
            if(temp == finish) return true;
            for (int i = 0; i < list[temp].size(); i++) {
                if(list[temp].get(i).weight >= mid && visited[list[temp].get(i).next] == false){
                    visited[list[temp].get(i).next] = true;
                    qu.offer(list[temp].get(i).next);
                }
            }
        }
        return false;
    }
}

//    public static void dfs(int start, int finish, int limitweight){
//        if(start == finish){
//            result = start;
//            return;
//        }
//        visited[start] = true;
//        for(island i : list[start]){
//            if(!visited[i.next] && limitweight<= i.weight){
//                dfs(i.next, finish, limitweight);
//            }
//        }
//    }
