package BAEKJOON;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1976 {
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); int M = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur ==1) union(i,j);
            }
        }
        boolean result = true;
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i <  M; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(start !=find(cur)){
                result = false;
            }
        }
        if(result) System.out.println("YES");
        else System.out.println("NO");
    }
    public static int find(int x){
        if(x == parents[x]){
            return x;
        }
        return parents[x] = find(parents[x]);
    }
    public static void union(int i, int j){
        i = find(i);
        j = find(j);
        if(i != j){
            if(i<j){
                parents[j] = i;
            }else{
                parents[i] = j;
            }
        }
    }
}
