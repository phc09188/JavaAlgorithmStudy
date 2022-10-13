package BAEKJOON;


import java.util.*;
import java.io.*;
public class boj1918 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >='A' && arr[i] <='Z') sb.append(arr[i]+"");
            else{
                if(arr[i]=='(') stack.push(arr[i]);
                else if(arr[i] ==')'){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    if(!stack.isEmpty()) stack.pop();
                }else{
                    while(!stack.isEmpty() && pre(stack.peek()) >= pre(arr[i])){
                        sb.append(stack.pop());
                    }
                    stack.push(arr[i]);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
    public static int pre(char c){
        if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return 0;
    }
}
