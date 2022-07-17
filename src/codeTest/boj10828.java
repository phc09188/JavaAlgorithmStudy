package codeTest;

import java.io.*;
import java.util.*;
public class boj10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int num =-1;
            if(input.length != 1){
                num = Integer.parseInt(input[1]);
            }

            if(name.equals("push")){
                stack.push(num);
            }else if(name.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1 + "\n");
                }else{
                    sb.append(stack.pop() +" \n");
                }
            }else if(name.equals("size")){
                sb.append(stack.size() + "\n");
            }else if(name.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1 +"\n");
                }else{
                    sb.append(0 + "\n");
                }
            }else if(name.equals("top")){
                if(stack.isEmpty()){
                    sb.append(-1+ "\n");
                }else{
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
