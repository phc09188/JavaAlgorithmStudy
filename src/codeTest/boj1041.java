package codeTest;

import java.io.*;
public class boj1041 {
    static int min = Integer.MAX_VALUE;
    static int arrmin = Integer.MAX_VALUE;
    static int arrmax = 0;
    public static void combination22(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            int sum =0;
            for (int i = 0; i < n; i++) {
                if (visited[i] && visited[n-i-1]){
                    sum =0;
                    break;
                }
                else if(visited[i]){
                    sum += arr[i];
                }
            }
            if(sum != 0) {
                min = Math.min(min, sum);
            }
            return;
        }
        if(depth ==n){
            return;
        }
        visited[depth] = true;
        combination22(arr, visited, depth+1, n, r-1);
        visited[depth] = false;
        combination22(arr, visited, depth+1, n, r);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int[] arr = new int[6];
        boolean[] visited = new boolean[6];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(input[i]);
            arrmin = Math.min(arrmin, arr[i]);
            arrmax = Math.max(arrmax, arr[i]);
        }
        if(n==1){
            int sum = 0;
            for (int i = 0; i < 6; i++) {
                sum += arr[i];
            }
            sum -= arrmax;
            System.out.println(sum);
        }else {
            combination22(arr, visited, 0, arr.length, 3);
            int min3 = min;
            combination22(arr, visited, 0, 6, 2);
            int min2 = min;
            long mul2 = 8 * (n - 2) + 4;
            long mul1 = (n - 2) * (n - 1) * 4 + (n - 2) * (n - 2);
            long sum = (4 * min3) + min2 * mul2 + arrmin * mul1;
            System.out.println(sum);
        }
    }
}
