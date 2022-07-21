package codeTest;

import java.io.*;
import java.util.*;
public class boj1018 {
    public static boolean[][] arr;
    public static int min = 64;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if(input.charAt(j) == 'W'){
                    arr[i][j] = true;
                }else{
                    arr[i][j] = false;
                }
            }
        }
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                search(i,j);
            }
        }
        System.out.println(min);
    }
    public static void search(int x, int y){
        int end_x = x+8;
        int end_y = y+8;
        int count = 0;
        boolean TF = arr[x][y];
        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if(arr[i][j] != TF){
                    count++;
                }
                TF = (!TF);
            }
            TF = !TF;
        }
        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}
