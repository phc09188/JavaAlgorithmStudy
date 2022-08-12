package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean isTrue = true;
        while(isTrue) {
            Stack<Character> stack1 = new Stack();
            char[] arr = br.readLine().toCharArray();
            if (arr.length == 1 && arr[arr.length - 1] == '.') {
                isTrue = false;
                break;
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == '(') {
                        stack1.add(arr[i]);
                    } else if (arr[i] == '[') {
                        stack1.add(arr[i]);
                    } else if (arr[i] == ')') {
                        if (stack1.isEmpty()) {
                            stack1.add(arr[i]);
                            break;
                        } else if(stack1.peek() == '(') {
                            stack1.pop();
                        }else{
                            break;
                        }
                    } else if (arr[i] == ']') {
                        if (stack1.isEmpty()) {
                            stack1.add(arr[i]);
                            break;
                        } else if(stack1.peek() == '[') {
                            stack1.pop();
                        }else{
                            break;
                        }
                    }

                }
            }
            if(stack1.isEmpty()){
                sb.append("yes" +"\n");
            }else{
                sb.append("no" + "\n");
            }
        }
        System.out.println(sb);
    }
}
