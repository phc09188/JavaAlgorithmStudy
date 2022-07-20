package codeTest;

import java.io.*;
import java.util.*;

public class boj10799 {
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ac = br.readLine();
        char[] input = ac.toCharArray();
        ArrayList<Integer> razer = new ArrayList();
        int n = 0;
        int result =0;
        while(n <input.length){
            if(input[n] == '('){
                stack.push(n);
            }else{
                if(input[n-1] == '('){
                    int a = stack.pop();
                    razer.add(a);
                }else{
                    int a = stack.pop();
                    boolean isTrue = false;
                    for (int i = 0; i < razer.size(); i++) {
                        if(razer.get(i) > a){
                            result++;
                            isTrue = true;
                        }
                    }
                    if(isTrue){
                        result++;
                    }
                }
            }
            n++;
        }
        System.out.println(result);
    }
}
