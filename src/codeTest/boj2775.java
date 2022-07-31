package codeTest;

import java.io.*;
public class boj2775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[k+1][n+1];
            for (int j = 1; j <= n; j++) {
                arr[0][j] = j;
            }

            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= n; l++) {
                    arr[j][l] = arr[j][l-1] + arr[j-1][l];
                }
            }
            result[i] = arr[k][n];
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
