package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class boj1978 {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        boolean[] arr = new boolean[1001];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < 1001; i++) {
            if(arr[i]) continue;
            for (int j = i+i; j < 1001 ; j +=i) {
                arr[j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(!arr[input]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
