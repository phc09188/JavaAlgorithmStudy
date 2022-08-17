package Programmerslv2;

import java.util.Stack;

public class 큰수만들기 {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length()- k; int start =0;
        while(start < number.length() && answer.length() != len){
            int leftnum = k + answer.length() +1; int max = 0;
            for (int i = start; i < leftnum; i++) {
                if(max< number.charAt(i) -'0'){
                    max = number.charAt(i) -'0'; start = i+1;
                }
            }
            answer.append(Integer.toString(max));
        }
        return answer.toString();
    }
    public static String stackSolution(String number, int k){
        char[] result = new char[number.length()-k];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while(!stack.isEmpty() && stack.peek()<c && k-->0){
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args){
        //System.out.println(solution("1924", 2));
        System.out.println(stackSolution("4177252841", 4));
    }
}
