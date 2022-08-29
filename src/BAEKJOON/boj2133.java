package BAEKJOON;

import java.io.*;
public class boj2133 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[31]; int[] DP = new int[31];
        DP[0] =1; DP[2] =3;
        for (int i = 4; i <=30 ; i+=2) {
            arr[i] = arr[i-2] + DP[i-4];
            DP[i] = DP[i-2] *3 + arr[i]*2;
        }
        System.out.println(DP[N]);
    }
}
