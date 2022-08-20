package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj10830 {
    static int N;
    final static int limit = 1000;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); long B = Long.parseLong(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) %limit;
            }
        }
        int[][] result = OddorNot(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                sb.append(result[i][j] +" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static int[][] multimatrix(int[][] arr, int[][] arr2){
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    copy[i][j] += (arr[i][k]*arr2[k][j])%limit;
                }
                copy[i][j] %= limit;
            }
        }
        return copy;
    }
    public static int[][] OddorNot(long cnt){
        if(cnt==1){
            return arr;
        }
        int[][] copy = OddorNot(cnt/2);
        if(cnt%2 ==0){
            return multimatrix(copy, copy);
        }
        else{
            int[][] copy2 = multimatrix(copy,arr);
            return multimatrix(copy, copy2);
        }
    }
}
