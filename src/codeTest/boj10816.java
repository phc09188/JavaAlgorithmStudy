package codeTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10816 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int t = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(st.nextToken());
            // 여기서 result 값은 탐색해서 찾아낸 개수의 값이 아니다! 고치자!
            int result = Arrays.binarySearch(arr, a);
            if(result <0){
                sb.append(0 +" ");
            }else {
                sb.append(result + " ");
            }
        }
        System.out.println(sb);
    }
}