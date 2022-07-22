package codeTest;


import java.io.*;
import java.util.*;
public class boj2798 {
    static int max = -1;
    static int limit =0;
    public static void combination(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if(sum > max && sum <= limit){
                max = sum;
            }
            return;
        }
        if(depth ==n){
            return;
        }
        visited[depth] = true;
        combination(arr, visited, depth+1, n, r-1);
        visited[depth] = false;
        combination(arr, visited, depth+1, n, r);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        limit = m;
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        combination(arr,visited,0,n,3);
        System.out.println(max);
    }
}
