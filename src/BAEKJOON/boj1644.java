package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1644 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(arr[i] ==0){
                list.add(i);
                for (int j = i; j <= n; j = j+i) {
                    arr[j] =1;
                }
            }
        }
        int answer = 0; int sum =0; int p1 =0; int p2 =0;
        while(true){
            if(sum >= n){
                sum -= list.get(p1);
                p1++;
            }else if(p2 == list.size()){
                break;
            }else if(sum<n){
                sum += list.get(p2);
                p2++;
            }
            if(sum == n){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
