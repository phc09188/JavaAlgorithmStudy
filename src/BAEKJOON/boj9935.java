package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj9935 {
    public static String result ="";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();
        solutionRecursion(input, bomb);
        System.out.println(result);
    }
    public static void solutionStack(String input, String bomb){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
            if(stack.size() >= bomb.length()){
                boolean isTrue = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size()- bomb.length() + j) != bomb.charAt(j)){
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue){
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            result = "FRULA";
        }else {
            StringBuilder sb = new StringBuilder();
            for (Character c: stack){
                sb.append(c);
            }
            result = sb.toString();
        }
    }


    public static void solutionRecursion(String input, String bomb){
        if(!input.contains(bomb)){
            result = input;
        }
        if(input.equals(bomb)){
            result = "FRULA";
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            boolean istrue = false;
            if (input.charAt(i) == bomb.charAt(0)) {
                for (int j = 0; j < bomb.length(); j++) {
                    if (input.charAt(i+j) != bomb.charAt(j)) {
                        istrue = false;
                        break;
                    }
                    istrue = true;
                }
            }
            if (istrue) {
                String adjinput = input.substring(0, i) + input.substring(i + bomb.length(), input.length());
                solutionRecursion(adjinput, bomb);
            }
        }
    }
}
