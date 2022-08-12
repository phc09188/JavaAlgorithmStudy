package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1662 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Integer> mul = new Stack<>();
        Stack<Integer> len = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '('){
                cnt-= 1;
                int mulnum = arr[i-1] - '0';
                len.add(cnt);
                mul.add(mulnum);
                cnt =0;
            }else if(arr[i] == ')'){
                int val = mul.pop();
                val *= cnt;
                int plus = len.pop();
                cnt = plus + val;
            }else cnt++;
        }
        System.out.println(cnt);
    }
}
