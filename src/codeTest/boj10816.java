package codeTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10816 {
    private static int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;
        while(lo < hi){
            int mid = (lo + hi)/2;
            if(key < arr[mid]){
                hi = mid;
            }else{
                lo = mid +1;
            }
        }
        return lo;
    }
    private static int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(key <= arr[mid]){
                hi = mid;
            }else{
                lo = mid +1;
            }
        }
        return lo;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] firstarr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            firstarr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(firstarr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());

            sb.append( upperBound(firstarr,input) - lowerBound(firstarr,input)+ " ");
        }
        System.out.println(sb);
    }
}