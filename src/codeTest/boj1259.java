package codeTest;

import java.io.*;
import java.util.*;
public class boj1259 {
    static String input;
    public static String isPal(String input){
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length/2; i++) {
            if(arr[i] != arr[arr.length-i-1]){
                return "no";
            }
        }

        return "yes";
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        do{
            input = br.readLine();
            if(!input.equals("0")) {
                sb.append(isPal(input) + "\n");
            }
        }while(!input.equals("0"));
        System.out.println(sb);
    }
}
