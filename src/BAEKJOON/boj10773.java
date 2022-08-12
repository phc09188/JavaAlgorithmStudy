package BAEKJOON;

import java.io.*;
import java.util.Stack;


public class boj10773 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
