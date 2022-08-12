package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1654 {
    public static void search (int[] arr1, int a,int n){
        long first = 1;
        long last = a;
        long mid =0;

        while(first <= last) {
            mid = (first + last) / 2;
            int cnt = 0;
            for (int i = 0; i < arr1.length; i++) {
                cnt += arr1[i]/mid;
            }
            if(cnt<n){
                last = mid -1;
            }else{
                first = mid +1;
            }
        }
        System.out.println(last);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        search(arr, arr[k-1], n);
    }
}
