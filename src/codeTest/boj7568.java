package codeTest;

import java.io.*;
import java.util.StringTokenizer;
public class boj7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int cnt;
        for (int i = 0; i < arr.length; i++) {
            cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    cnt++;
                }
            }
            arr[i][2] = cnt+1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][2] + " ");
        }
    }
}
