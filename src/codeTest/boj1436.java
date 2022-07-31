package codeTest;

import java.io.*;
public class boj1436 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int num = 665;
        while(cnt != N){
            num++;
            char[] arr = String.valueOf(num).toCharArray();
            for (int i = 0; i < arr.length-2; i++) {
                if(arr[i] == '6' && arr[i+1] =='6'&& arr[i+2] == '6'){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(num);
    }
}
