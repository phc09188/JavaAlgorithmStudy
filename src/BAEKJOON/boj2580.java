package BAEKJOON;

import java.io.*;
import java.util.*;

public class boj2580 {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0,0);
    }

    private static void search(int i, int j) {
        if(j ==9){
            search(i+1, 0);
        }
        if(i ==9){
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 9; k++) {
                for (int l = 0; l < 9; l++) {
                    sb.append(arr[k][l]).append(' ');
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(arr[i][j] ==0){
            for (int k = 1; k <=9; k++) {
                if(sudoku(i,j,k)){
                    arr[i][j] = k;
                    search(i,j+1);
                }
            }
            arr[i][j] = 0;
            return;
        }
        search(i,j+1);
    }

    private static boolean sudoku(int i, int j, int value) {
        for (int l = 0; l < 9; l++) {
            if(arr[l][j] == value){
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if(arr[i][k] == value){
                return false;
            }
        }
        int row = (i/3)*3; int col = (j/3)*3;
        for (int k = row; k <row+3; k++) {
            for (int l = col; l <col+3; l++) {
                if(arr[k][l] == value){
                    return false;
                }
            }
        }
        return true;
    }
}
