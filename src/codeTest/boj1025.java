package codeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1025{
    static int[][] arr;
    static String[] input;
    static int n, m;
    static int result = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        input = new String[n+1];
        for (int i = 0; i < n; i++) {
            input[i]= br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input[i].charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                search(j,i);
            }
        }
        System.out.println(result);
    }
    public static void search(int c, int r){
        for (int i = -n; i < n; i++) {
            for (int j = -m; j < m; j++) {
                if(i ==0 &&j == 0) continue;
                int x = c;
                int y = r;
                int k =0;
                while(x>=0 && x<m &&y>=0&& y<n){
                    k*=10;
                    k += arr[y][x];
                    int root = (int)Math.sqrt(k);
                    if(Math.pow(root, 2) == k){
                        result = Math.max(result, k);
                    }
                    x+=j;
                    y+=i;
                }
            }
        }
    }
}
