package codeTest;

import java.io.*;
import java.util.StringTokenizer;

public class boj18111 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int min =Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        int time = Integer.MAX_VALUE;
        int high = 0;
        for (int i = min; i <= max; i++) {
            int count = 0;
            int block = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(i>= arr[j][k]){
                        count += (i - arr[j][k]);
                        block -= (i- arr[j][k]);
                    }else{
                        count += (arr[j][k] - i) *2;
                        block += (arr[j][k] -i);
                    }
                }
            }
            if(block <0) break;
            if(time >= count){
                time = count;
                high = i;
            }
        }
        System.out.println(time + " " + high);
    }
}
