package BAEKJOON;

import java.io.*;
import java.util.*;


public class boj1920 {

    public static int search (int[] arr1, int n, int a){
        int first = 0;
        int last = n-1;
        int mid =0;
        while(first <= last){
            mid = (first + last)/2;
            if(arr1[mid]==a){
                return 1;
            }
            if(arr1[mid] <a){
                first = mid +1;

            }else{
                last = mid -1;
            }
        }
        return 0;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n =Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr1);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(search(arr1,arr1.length,Integer.parseInt(st.nextToken())) + "\n");
        }
        System.out.println(sb);
    }
}
