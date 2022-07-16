package codeTest;

import java.io.*;
import java.util.*;
public class boj9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '('){
                    stack.push(s.charAt(j));
                }else{
                    if(stack.isEmpty()){
                        stack.push(s.charAt(j));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
